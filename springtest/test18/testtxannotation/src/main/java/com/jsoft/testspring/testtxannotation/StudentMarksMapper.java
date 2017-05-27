package com.jsoft.testspring.testtxannotation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMarksMapper implements RowMapper<StudentMarks> {

	@Override
	public StudentMarks mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		StudentMarks student = new StudentMarks();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		
		student.setSid(rs.getInt("sid"));
		student.setMarks(rs.getInt("marks"));
		student.setYear(rs.getInt("year"));
		
		return student;
	}

}
