package com.avro.model;

public class UserCustom {

	private String name;
	private Integer favoriteNumber;
	private String favoriteColor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFavoriteNumber() {
		return favoriteNumber;
	}
	public void setFavoriteNumber(Integer favoriteNumber) {
		this.favoriteNumber = favoriteNumber;
	}
	public String getFavoriteColor() {
		return favoriteColor;
	}
	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}
	@Override
	public String toString() {
		return "UserCustom [name=" + name + ", favoriteNumber=" + favoriteNumber + ", favoriteColor=" + favoriteColor
				+ "]";
	}

	
	

}
