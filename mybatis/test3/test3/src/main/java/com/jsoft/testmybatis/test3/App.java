package com.jsoft.testmybatis.test3;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jsoft.testmybatis.inter.IUserOperation;
import com.jsoft.testmybatis.models.User;

public class App {
	public static void main(String[] args) throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("Configuration.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			
			try {
				System.out.println("单个实体：");
				User user = userOperation.selectUserByID(1);
				System.out.println(user.getUserAddress());
				System.out.println(user.getUserName());
				
				System.out.println("List：");
				List<User> users = userOperation.selectUsers("%");
				for (User tempUser : users) {
					System.out.println(tempUser.getUserAddress());
					System.out.println(tempUser.getUserName());
				}
				
				System.out.println("Add：");
				User addUser = new User();
				addUser.setUserAddress("guangdong,guangzhou");
				addUser.setUserName("eason");
				addUser.setUserAge("80");
				int addRetCount = userOperation.addUser(addUser);
				session.commit();//必须提交事务，否则不会写入到数据库。
				System.out.println("增加数据影响的行数：" + addRetCount);
				if (addUser.getId() > 0) {
					System.out.println("增加数据成功，新增的id为：" + addUser.getId());
				}
				
				System.out.println("Update：");
				User updateUser = userOperation.selectUserByID(1);
				updateUser.setUserAddress("beijin,beijin");
				int updateRetCount = userOperation.updateUser(updateUser);
				session.commit();//必须提交事务，否则不会写入到数据库。
				System.out.println("更新数据影响的行数：" + updateRetCount);
				
				System.out.println("Delete：");
				int deleteRetCount = userOperation.deleteUser(6);
				session.commit();//必须提交事务，否则不会写入到数据库。
				System.out.println("删除数据影响的行数：" + deleteRetCount);
				
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
