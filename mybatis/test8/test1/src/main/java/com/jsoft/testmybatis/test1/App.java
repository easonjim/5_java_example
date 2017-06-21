package com.jsoft.testmybatis.test1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jsoft.testmybatis.inter.IUserOperation;
import com.jsoft.testmybatis.models.Article;
import com.jsoft.testmybatis.models.User;

public class App {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("Configuration.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			
			try {
				//if
				Article inArticle = new Article();
				inArticle.setTitle("test_title");
				Article outArticle = userOperation.dynamicIfTest(inArticle);
				System.out.println("id:"+outArticle.getId()+" title:"+outArticle.getTitle()+" content:"+outArticle.getContent());
				
				//choose
				Article outArticle2 = userOperation.dynamicChooseTest("test_title",null);
				System.out.println("id:"+outArticle2.getId()+" title:"+outArticle2.getTitle()+" content:"+outArticle2.getContent());
				
				//trim
				Article inArticle3 = new Article();
				inArticle3.setContent("test_content");
				Article outArticle3 = userOperation.dynamicTrimTest(inArticle3);
				System.out.println("id:"+outArticle3.getId()+" title:"+outArticle3.getTitle()+" content:"+outArticle3.getContent());
				
				//where
				Article inArticle4 = new Article();
				inArticle4.setContent("test_content");
				Article outArticle4 = userOperation.dynamicWhereTest(inArticle4);
				System.out.println("id:"+outArticle4.getId()+" title:"+outArticle4.getTitle()+" content:"+outArticle4.getContent());
				
				//set
				Article inArticle5 = new Article();
				inArticle5.setContent("test_content");
				inArticle5.setId(1);
				int updateRetCout = userOperation.dynamicSetTest(inArticle5);
				session.commit();//更新必须提交事务，不然不会写入数据库
				System.out.println("更新受影响的行数："+updateRetCout);
				
				//list
				List<Integer> ids = new ArrayList<Integer>();
				ids.add(1);
				ids.add(3);
				ids.add(6);
				List<Article> articless = userOperation.dynamicForeachTest(ids);
				for (Article articleTemp : articless)
					System.out.println("id:"+articleTemp.getId()+" title:"+articleTemp.getTitle()+" content:"+articleTemp.getContent());
				
				//array
				int[] ids2 = {1,3,6};				
				List<Article> articless2 = userOperation.dynamicForeach2Test(ids2);
				for (Article articleTemp : articless2)
					System.out.println("id:"+articleTemp.getId()+" title:"+articleTemp.getTitle()+" content:"+articleTemp.getContent());
				
				//map
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("title", "title");
				map.put("ids", new int[]{1,3,6});				
				List<Article> articless3 = userOperation.dynamicForeach3Test(map);
				for (Article articleTemp : articless3)
					System.out.println("id:"+articleTemp.getId()+" title:"+articleTemp.getTitle()+" content:"+articleTemp.getContent());
				
			} catch (Exception e) {
				// TODO: handle exception
				session.rollback();//有异常时回滚数据
				e.printStackTrace();
			}
			
		} finally {
			session.close();
		}
	}
}
