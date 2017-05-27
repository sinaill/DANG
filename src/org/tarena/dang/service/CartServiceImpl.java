package org.tarena.dang.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.CartItem;
import org.tarena.dang.entity.Product;
@Service("cartService")
@Scope("session")
public class CartServiceImpl extends BaseAction implements CartService,Serializable{
	
	List<CartItem> store = new ArrayList<CartItem>();

//	@Resource(name="productDAO")
//	private ProductDAO productDAO;
//	
//	public void setProductDAO(ProductDAO productDAO) {
//		this.productDAO = productDAO;
//	}
	
	public boolean buy(int id,ProductDAO productDAO) {
		for(CartItem item:store){
			if(item.getProduct().getId()==id){
				return false;
			}
		}
	
		Product pro = productDAO.findById(id);
		CartItem item = new CartItem();
		item.setProduct(pro);
		store.add(item);
		return true;
	}
    //�г�
	public List<CartItem> getBuyPros() throws Exception {	
		return store;
	}
	
	public String store(){
		StringBuffer sub = new StringBuffer();
		if(store.size()==0){
			sub.append("0");
		}else{
			for(int i=0;i<store.size();i++){
				CartItem item = store.get(i);
				sub.append(item.getProduct().getId()+","
						+item.getQty()+","+item.isBuy()+";");
			}
		}
//		if(sub.length()>1){
//			sub.deleteCharAt(sub.length()-1);
//		}
		return sub.toString();
	}

	public void load(String content,ProductDAO productDAO){//加载从cookie读取的内容
		if(content==null||content.equals("0")){
			return;
		}
		String[] pcs = content.split(";");
		for(int i=0;i<pcs.length;i++){
			String pc = pcs[i];
			String[] strs = pc.split(",");
			int id = Integer.parseInt(strs[0]);
			int qty = Integer.parseInt(strs[1]);
			boolean buy = Boolean.parseBoolean(strs[2]);
			try {
				Product pro = productDAO.findById(id);
				CartItem item = new CartItem();
				item.setProduct(pro);
				item.setQty(qty);
				item.setBuy(buy);
				store.add(item);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
    /*
     * 
     * ɾ����Ʒ
     */
	public void delete(int pid) throws Exception {
		for(CartItem item:store){
			if(item.getProduct().getId()==pid){
				item.setBuy(false);
			}
		}
		//CookieUtil.addCookie(Constant.CART, cart.store(), response);
	}
    /*
     * 
     * �ָ���Ʒ
     */
	public void recovery(int pid) throws Exception {
		for(CartItem item:store){
			if(item.getProduct().getId()==pid){
				item.setBuy(true);
			}
		}
		
	}
    /*
     * (�޸���Ʒ����
     * @see org.tarena.dang.service.CartService#modify(int, int)
     */
	public void modify(int pid, int qty) throws Exception {
		for(CartItem item:store){
			if(item.getProduct().getId()==pid){
				item.setQty(qty);
			}
		}
		
	}
    /*
     * ������Ʒ�ܽ��
     * 
     */
	public double cost() throws Exception {
		double total=0;
		for(CartItem item:store){
			if(item.isBuy()==true){
				total+=item.getProduct().getDangPrice()*item.getQty();
			}
			
		}
		return total;
	}
    /*
     * 
     * �����ʡ��Ǯ
     */
	public double sale() throws Exception {
		double save=0;
		for(CartItem item:store){
			if(item.isBuy()==true){
				save+=(item.getProduct().getFixedPrice()
						 -item.getProduct().getDangPrice())*item.getQty();
			}
		}
		return save;
	}
    
	public List<CartItem> getPros() throws Exception {
		List<CartItem> items = new ArrayList<CartItem>();
		for(CartItem item:store){
		    if(item.isBuy()){
		    	items.add(item);
		    }
		}
		return items;
	}

}
