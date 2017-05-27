package org.tarena.dang.dao;

import org.tarena.dang.entity.User;

public interface UserDAO {
	public void save(User user) throws Exception;
	public User findByEmail(String email)throws Exception;
	public void modfiy_is_email_verify(User user) throws Exception;
	public void modfiyTimeIp(User user)throws Exception;

}
