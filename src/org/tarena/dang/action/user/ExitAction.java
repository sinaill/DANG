package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;

public class ExitAction extends BaseAction {
	/*
	 * �˳���¼ ���session
	 */
	public String execute(){
		session.remove("user");
		return "success";
	}

}
