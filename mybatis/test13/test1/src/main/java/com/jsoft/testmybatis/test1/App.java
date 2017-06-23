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
				System.out.println("第一次查询开始");
				//List
				List<User> users = userOperation.selectUsers("j");
				for (User tempUser : users) {
					System.out.println(tempUser.getUserAddress());
					System.out.println(tempUser.getUserName());
				}
				System.out.println("第一次查询结束");
				
				System.out.println("第二次查询开始");
				//List
				List<User> users2 = userOperation.selectUsers("j");
				for (User tempUser : users2) {
					System.out.println(tempUser.getUserAddress());
					System.out.println(tempUser.getUserName());
				}
				System.out.println("第二次查询结束");
				
				System.out.println("加入数据开始开始");
				//Add
				User addUser = new User();
				addUser.setUserAddress("guangdong,guangzhou");
				addUser.setUserName("eason");
				addUser.setUserAge("80");
				int addRetCount = userOperation.addUser(addUser);
				session.commit();//必须提交事务，否则不会写入到数据库。如果session不commit，那么，数据就不会放入cache中。所以，只有commit后，才能取得。
				System.out.println("增加数据影响的行数：" + addRetCount);
				if (addUser.getId() > 0) {
					System.out.println("增加数据成功，新增的id为：" + addUser.getId());
				}
				System.out.println("加入数据开始结束");
				
				System.out.println("第三次查询开始");
				//List
				List<User> users3 = userOperation.selectUsers("j");
				for (User tempUser : users3) {
					System.out.println(tempUser.getUserAddress());
					System.out.println(tempUser.getUserName());
				}
				System.out.println("第三次查询结束");
				
				//强制刷新缓存
				session.clearCache();
				
				System.out.println("第四次查询开始");
				//List
				List<User> users4 = userOperation.selectUsers("j");
				for (User tempUser : users4) {
					System.out.println(tempUser.getUserAddress());
					System.out.println(tempUser.getUserName());
				}
				System.out.println("第四次查询结束");
				
				
			} catch (Exception e) {
				// TODO: handle exception
				session.rollback();//有异常时回滚数据
				e.printStackTrace();
			}
			
		} finally {
			session.close();//close之后缓存清空
		}
	}
}
