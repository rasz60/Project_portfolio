package com.edt.dynamic.dto;

import java.sql.Timestamp;

public class ProductDTO {
	private String pId, pBrand, pCollection, pEname, pKname, pImage, pGender;
	private int pSize, pPrice, pStock, pHit;
	private Timestamp pDate;
	
	public ProductDTO() {}
	
	public ProductDTO(String pId, String pBrand, String pCollection, String pEname, String pKname, String pImage,
					  String pGender, int pSize, int pPrice, int pStock, int pHit, Timestamp pDate) {
		this.pId = pId;
		this.pBrand = pBrand;
		this.pCollection = pCollection;
		this.pEname = pEname;
		this.pKname = pKname;
		this.pImage = pImage;
		this.pGender = pGender;
		this.pSize = pSize;
		this.pPrice = pPrice;
		this.pStock = pStock;
		this.pHit = pHit;
		this.pDate = pDate;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getpCollection() {
		return pCollection;
	}

	public void setpCollection(String pCollection) {
		this.pCollection = pCollection;
	}

	public String getpEname() {
		return pEname;
	}

	public void setpEname(String pEname) {
		this.pEname = pEname;
	}

	public String getpKname() {
		return pKname;
	}

	public void setpKname(String pKname) {
		this.pKname = pKname;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public String getpGender() {
		return pGender;
	}

	public void setpGender(String pGender) {
		this.pGender = pGender;
	}

	public int getpSize() {
		return pSize;
	}

	public void setpSize(int pSize) {
		this.pSize = pSize;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpStock() {
		return pStock;
	}

	public void setpStock(int pStock) {
		this.pStock = pStock;
	}

	public int getpHit() {
		return pHit;
	}

	public void setpHit(int pHit) {
		this.pHit = pHit;
	}

	public Timestamp getpDate() {
		return pDate;
	}

	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}
	
	
	
}
