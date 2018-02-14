package com.javaex.vo;

public class CategoryVo {

	int cateNo;
	int userNo;
	String cateName;
	String description;
	String regDate;
	int postCount;
	public CategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryVo(int cateNo, int userNo, String cateName, String description, String regDate) {
		super();
		this.cateNo = cateNo;
		this.userNo = userNo;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}
	
	public int getPostCount() {
		return postCount;
	}
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", userNo=" + userNo + ", cateName=" + cateName + ", description="
				+ description + ", regDate=" + regDate + ", postCount=" + postCount + "]";
	}
	
	
	
	
	
}
