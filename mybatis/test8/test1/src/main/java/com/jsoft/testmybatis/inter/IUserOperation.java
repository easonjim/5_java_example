package com.jsoft.testmybatis.inter;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jsoft.testmybatis.models.Article;
import com.jsoft.testmybatis.models.User;

public interface IUserOperation {
	
	public User selectUserByID(int id);
	
	public List<User> selectUsers(String userName);
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public int deleteUser(int id);

	public List<Article> getUserArticles(int id);
	
	public Article dynamicIfTest(Article article);
	
	public Article dynamicChooseTest(
			@Param("title")
			String title, 
			@Param("content")
			String content);
	
	public Article dynamicTrimTest(Article article);
	
	public Article dynamicWhereTest(Article article);
	
	public int dynamicSetTest(Article article);
	
	public List<Article> dynamicForeachTest(List<Integer> ids);
	
	public List<Article> dynamicForeach2Test(int[] ids);
	
	public List<Article> dynamicForeach3Test(Map<String, Object> params);
}
