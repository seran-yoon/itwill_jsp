package org.comstudy21.employe.dto;

public class EmployeDto {
	
	String course;
	String name;
	String jumin1;
	String jumin2;
	String address;
	String phone;
	String mobile;
	String payment;
	String start_day;
	String end_day;
	String collect_person_info;
	
	public EmployeDto() {
		this("","","","","","","","","","","");
	}

	public EmployeDto(String course, String name, String jumin1, String jumin2, String address, String phone,
			String mobile, String payment, String start_day, String end_day, String collect_person_info) {
		this.course = course;
		this.name = name;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;
		this.payment = payment;
		this.start_day = start_day;
		this.end_day = end_day;
		this.collect_person_info = collect_person_info;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin1() {
		return jumin1;
	}

	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}

	public String getJumin2() {
		return jumin2;
	}

	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStart_day() {
		return start_day;
	}

	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}

	public String getEnd_day() {
		return end_day;
	}

	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}

	public String getCollect_person_info() {
		return collect_person_info;
	}

	public void setCollect_person_info(String collect_person_info) {
		this.collect_person_info = collect_person_info;
	}

	@Override
	public String toString() {
		return "EmployeDto [course=" + course + ", name=" + name + ", jumin1=" + jumin1 + ", jumin2=" + jumin2
				+ ", address=" + address + ", phone=" + phone + ", mobile=" + mobile + ", payment=" + payment
				+ ", start_day=" + start_day + ", end_day=" + end_day + ", collect_person_info=" + collect_person_info
				+ "]";
	}
	

}
