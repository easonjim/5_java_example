package com.jsoft.testmybatis.dao;

import java.util.List;
import com.jsoft.testmybatis.models.Article;

public interface UserDAO {
	public List<Article> getUserArticles(int userid);
}
