package com.jsoft.testmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.jsoft.testmybatis.models.Article;

@Repository
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {
	
	@Autowired(required = false)
	@Qualifier("sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<Article> getUserArticles(int userid) {
		return this.getSqlSession().selectList("com.jsoft.testmybatis.inter.IUserOperation.getUserArticles", userid);
	}
}