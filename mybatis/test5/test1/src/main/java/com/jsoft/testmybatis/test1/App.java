package com.jsoft.testmybatis.test1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsoft.testmybatis.inter.IUserOperation;
import com.jsoft.testmybatis.models.Article;
import com.jsoft.testmybatis.models.User;

public class App {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		IUserOperation mapper = (IUserOperation) ctx.getBean("userMapper");
		// 测试id=1的用户查询，根据数据库中的情况，可以改成你自己的.
		System.out.println("得到用户id=1的用户信息");
		User user = mapper.selectUserByID(1);
		System.out.println(user.getUserAddress());

		// 得到文章列表测试
		System.out.println("得到用户id为1的所有文章列表");
		List<Article> articles = mapper.getUserArticles(1);

		for (Article article : articles) {
			System.out.println(article.getContent() + "--" + article.getTitle());
		}
	}
}
