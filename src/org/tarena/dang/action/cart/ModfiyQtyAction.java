package org.tarena.dang.action.cart;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.service.CartFactory;
import org.tarena.dang.service.CartService;
import org.tarena.dang.util.Constant;
import org.tarena.dang.util.CookieUtil;

public class ModfiyQtyAction extends BaseAction{
	private int pid;
	private String qty;
	private String error=null;
	private ProductDAO productDAO;
	public String execute() throws Exception{
		CartService cart = CartFactory.getInstance(session,productDAO);
		String reg="^[0-9]+$";
		if(!qty.trim().matches(reg)){
			error="输入数字";
		}else{
			int num = Integer.parseInt(qty.trim());
			cart.modify(pid, num);
		}
		CookieUtil.addCookie(Constant.CART, cart.store(), response);
	    return "success";	
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
    

	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
   public static void main(String[] args) {
	String a = "  12";
	System.out.println(a.trim());
}
public void setProductDAO(ProductDAO productDAO) {
	this.productDAO = productDAO;
}
	
}
