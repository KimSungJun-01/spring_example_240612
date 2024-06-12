package com.example.lesson02.domain;

import java.time.LocalDateTime;

// 일반 자바 bean
// DTO, model, domain, Entity
public class UsedGoods {
	private int id;
	private int sellerId;
	private String title;
	private String description;
	private int price;
	private String pictureUrl;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	// getter
	public int getId() {
		return id;
	}
	public int getSellerId() {
		return sellerId;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public int getPrice() {
		return price;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	// setter
	public void setId(int id) {
		this.id = id;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
