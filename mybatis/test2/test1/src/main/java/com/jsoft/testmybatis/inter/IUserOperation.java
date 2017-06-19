package com.jsoft.testmybatis.inter;

import com.jsoft.testmybatis.models.User;

public interface IUserOperation {
	public User selectUserByID(int id);

}
