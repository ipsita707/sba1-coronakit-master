package com.eval.coronakit.entity;

public class Item {

	private Integer id;
	private String title;
	private String unit;
	private Integer price;

	public Item() {
		// left unimplemente
	}

	public Item(Integer id, String title, String unit, Integer price) {
		super();
		this.id = id;
		this.title = title;
		this.unit = unit;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", unit=" + unit + ", price=" + price + "]";
	}

}
