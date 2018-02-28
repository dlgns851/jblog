package com.javaex.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaex.LogDTO.LogDTO;
//import kr.co.smh.mongo.log.MongoLogger;

@Component    //이거 해줘야 빈 만들어줌 
@Aspect
public class TimeCheckAdvice {

	@Autowired
	private HttpSession session;

	//@Autowired
//	private MongoLogger mongoLogger;

	private static final Logger logger = LoggerFactory.getLogger(TimeCheckAdvice.class);

	// @Around("execution(* kr.co.smh.service..*(..))")
	@Around("within(kr.co.smh.service..*)")       //어라운드 어노테이션 자체가 어드바이스다     
	public Object timeLog(ProceedingJoinPoint joinPoint) throws Throwable {  //대신 호출 해주는 이런 메소드들을 '어드바이스' 라고 부름 
		String signature = joinPoint.getSignature().toShortString();         //joinPoint = 
		logger.info(signature + " is start");
		long st = System.currentTimeMillis();

		try {
			logger.info(signature + " Running");
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			LogDTO logDTO = new LogDTO();
			logDTO.setSignature(signature);
			logDTO.setCurrentTime(et - st);
			//mongoLogger.insertLog(logDTO);
			logger.info(signature + " is finished");
			logger.info(signature + " 경과시간 : " + (et - st));
		}
	}
}