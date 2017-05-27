package org.tarena.dang.action.order;

import java.util.List;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.CartItem;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;

public class OrderConfirmAction extends BaseAction {
	private  double total;
	private ProductDAO productDAO;
	private List<CartItem> items;
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
	public String execute() throws Exception{
		CartService cartService =  CartFactory.getInstance(session, productDAO);
		items = cartService.getPros();
		for(CartItem item:items){
			total += item.getProduct().getDangPrice()*item.getQty();
		}
		return "success";
	}


	public List<CartItem> getItems() {
		return items;
	}


	public void setItems(List<CartItem> items) {
		this.items = items;
	}


	public ProductDAO getProductDAO() {
		return productDAO;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
}
