package com.jsoft.testmybatis.inter;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jsoft.testmybatis.models.Article;
import com.jsoft.testmybatis.models.User;
import com.jsoft.testmybatis.util.PageInfo;

public interface IUserOperation {
	
	public User selectUserByID(int id);
	
	public List<User> selectUsers(String userName);
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(int id);

	public List<Article> getUserArticles(int id);
	
	public List<Article> getUserArticlesByLimit(int id,int start,int limit);
	
	public List<Article> selectArticleListPage(
			@Param("page") 
			PageInfo page,
			@Param("userid") 
			int userid);
}
