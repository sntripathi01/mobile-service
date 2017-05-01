package com.redox.mobile.service.model;

import java.util.Map;

public class FeeSlipResponse {

	private String months;
	private String feeDate;
	private String feeTime;
	private String name;
	private String gradeGroup;
	private String receptNo;
	private Map<String, Float> feeComponents;
	private String total;
	private String userName;
	private String mode;
	private String admissionNo;

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getFeeDate() {
		return feeDate;
	}

	public void setFeeDate(String feeDate) {
		this.feeDate = feeDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGradeGroup() {
		return gradeGroup;
	}

	public void setGradeGroup(String gradeGroup) {
		this.gradeGroup = gradeGroup;
	}

	public String getReceptNo() {
		return receptNo;
	}

	public void setReceptNo(String receptNo) {
		this.receptNo = receptNo;
	}

	public Map<String, Float> getFeeComponents() {
		return feeComponents;
	}

	public void setFeeComponents(Map<String, Float> feeComponents) {
		this.feeComponents = feeComponents;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getFeeTime() {
		return feeTime;
	}

	public void setFeeTime(String feeTime) {
		this.feeTime = feeTime;
	}

	public String getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	@Override
	public String toString() {
		return "FeeSlipResponse [months=" + months + ", feeDate=" + feeDate + ", feeTime=" + feeTime + ", name=" + name
				+ ", gradeGroup=" + gradeGroup + ", receptNo=" + receptNo + ", feeComponents=" + feeComponents
				+ ", total=" + total + ", userName=" + userName + ", mode=" + mode + ", admissionNo=" + admissionNo
				+ "]";
	}

}
