package org.comstudy21.shop.model;

public class ProductDto {
	
	private int no;
	private String name;
	private int price;
	private String company;
	private int year;
	
	public ProductDto() {
		this(0,"",0,"",0);
	}

	public ProductDto(int no, String name, int price, String company, int year) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.company = company;
		this.year = year;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "ProductDto [no=" + no + ", name=" + name + ", price=" + price + ", company=" + company + ", year="
				+ year + "]";
	}

	
	

}
