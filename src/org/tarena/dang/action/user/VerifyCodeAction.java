package org.tarena.dang.action.user;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;
import org.tarena.dang.action.BaseAction;
import org.tarena.dang.util.ImageUtil;
/*
 * ���ͼƬ��֤��
 */
public class VerifyCodeAction extends BaseAction {
	private InputStream input;
	public String execute() throws Exception{
		Map<String, BufferedImage> map = 
			 ImageUtil.createImage();
		String code = map.keySet().iterator().next();
		session.put("code", code);
		BufferedImage image = map.get(code);
		input = ImageUtil.getInputStream(image);
		input.close();
		return "success";
	}
	
	public InputStream getInput() {
		return input;
	}
	public void setInput(InputStream input) {
		this.input = input;
	}
	
	
     
}
