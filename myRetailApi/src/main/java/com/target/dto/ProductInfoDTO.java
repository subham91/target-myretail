package com.target.dto;

public class ProductInfoDTO {

	private Long id;
	private String name;
	private ProductPriceInfoDTO current_price;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the current_price
	 */
	public ProductPriceInfoDTO getCurrent_price() {
		return current_price;
	}

	/**
	 * @param current_price
	 *            the current_price to set
	 */
	public void setCurrent_price(ProductPriceInfoDTO current_price) {
		this.current_price = current_price;
	}

}
