package com.jsoft.testmybatis.inter;

import java.util.List;

import com.jsoft.testmybatis.models.Article;
import com.jsoft.testmybatis.models.User;

public interface IUserOperation {
	
	public User selectUserByID(int id);
	
	public List<User> selectUsers(String userName);
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(int id);

	public List<Article> getUserArticles(int id);
}
