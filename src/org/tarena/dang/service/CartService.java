package org.tarena.dang.service;

import java.util.List;

import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.CartItem;

public interface CartService {
	public boolean buy(int id,ProductDAO productDAO) throws Exception;
	public List<CartItem> getBuyPros() throws Exception;
	public String store();
	public void delete(int pid) throws Exception;
	public void recovery(int pid) throws Exception;
	public void  modify(int pid,int qty) throws Exception;
	public double cost() throws Exception;
	/**
	 * ͳ�ơ�ȷ�Ϲ��򡱵���Ʒ��ʡ���
	 * @return
	 * @throws Exception
	 */
	public double sale() throws Exception;
	/**
	 * ��ȡȷ�Ϲ�����Ʒ��ʾ�б�
	 * @return
	 * @throws Exception
	 */
	public void load(String findCookie,ProductDAO productDAO);
	public List<CartItem> getPros() throws Exception;

}
