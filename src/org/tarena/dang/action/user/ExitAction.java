package org.tarena.dang.action.user;

import org.tarena.dang.action.BaseAction;

public class ExitAction extends BaseAction {
	/*
	 * ÍË³öµÇÂ¼ Çå³ýsession
	 */
	public String execute(){
		session.remove("user");
		return "success";
	}

}
