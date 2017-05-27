package com.jsoft.testspring.testtx;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private PlatformTransactionManager transactionManager;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
	    try {
	         String SQL1 = "insert into Student (name, age) values (?, ?)";
	         jdbcTemplateObject.update( SQL1, name, age);
	         String SQL2 = "select max(id) from Student";
	         int sid = jdbcTemplateObject.queryForInt( SQL2 );
	         String SQL3 = "insert into Marks(sid, marks, year) values (?, ?, ?)";
	         jdbcTemplateObject.update( SQL3, sid, marks, year);
	         System.out.println("Created Name = " + name + ", Age = " + age);
	         transactionManager.commit(status);
	    } catch (DataAccessException e) {
	         System.out.println("Error in creating record, rolling back");
	         transactionManager.rollback(status);
	         throw e;
	    }
	    return;
	}

	@Override
	public StudentMarks getStudent(Integer id) {
		String SQL = "select * from Student,Marks where id = ? and Student.id=Marks.sid";
		StudentMarks student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new StudentMarksMapper());
		return student;
	}

	@Override
	public List<StudentMarks> listStudents() {
		String SQL = "select * from Student,Marks where Student.id = Marks.sid";
		List<StudentMarks> students = jdbcTemplateObject.query(SQL, new StudentMarksMapper());
		return students;
	}

	@Override
	public void delete(Integer id) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			String SQL1 = "delete from Student where id = ?";
			jdbcTemplateObject.update(SQL1, id);
			System.out.println("Deleted Record with ID = " + id);
			String SQL2 = "delete from Marks where sid = ?";
			jdbcTemplateObject.update(SQL2, id);
			System.out.println("Deleted Record with SID = " + id);
			transactionManager.commit(status);
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
			throw e;
		}
		return;
	}

	@Override
	public void update(Integer id, String name, Integer age, Integer marks, Integer year) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			String SQL1 = "update Student set age = ?,name = ? where id = ?";
			jdbcTemplateObject.update(SQL1, age,name, id);
			System.out.println("Updated Record with ID = " + id);
			String SQL2 = "update Marks set marks = ?,year = ? where sid = ?";
			jdbcTemplateObject.update(SQL2, marks,year, id);
			System.out.println("Updated Record with SID = " + id);
			transactionManager.commit(status);
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
			throw e;
		}
		return;
	}

}
