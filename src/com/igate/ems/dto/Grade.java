package com.igate.ems.dto;

public class Grade {
	
	/************************************
	POJO for getting GRADE Details 
	************************************/
	private String gradeCode;
	private String description;
	private long minSal;
	private long maxSal;

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getMinSal() {
		return minSal;
	}

	public void setMinSal(long minSal) {
		this.minSal = minSal;
	}

	public long getMaxSal() {
		return maxSal;
	}

	public void setMaxSal(long maxSal) {
		this.maxSal = maxSal;
	}

	@Override
	public String toString() {
		return "Grade [gradeCode=" + gradeCode + ", description=" + description
				+ ", minSal=" + minSal + ", maxSal=" + maxSal + "]";
	}

}
