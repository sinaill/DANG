package org.tarena.dang.entity;

import java.io.Serializable;

import org.tarena.dang.entity.Product;

public class CartItem implements Serializable{
	private Product product;
	private int qty = 1;
	private boolean buy = true;
	public CartItem(){
		
	}
	public CartItem(Product product, int qty, boolean buy) {
		super();
		this.product = product;
		this.qty = qty;
		this.buy = buy;
	}
	public boolean isBuy() {
		return buy;
	}


	public void setBuy(boolean buy) {
		this.buy = buy;
	}


	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	

}
