package com.jsoft.testmybatis.test1;

import java.io.IOException;
import java.io.InputStream;
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
				List<Article> articles = userOperation.getUserArticles(1);
				for (Article article : articles) {
					System.out.println( article.getTitle() + ":" + article.getContent() + 
							":作者是:" + article.getUser().getUserName() + 
							":地址:" + article.getUser().getUserAddress());
				}
				
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
