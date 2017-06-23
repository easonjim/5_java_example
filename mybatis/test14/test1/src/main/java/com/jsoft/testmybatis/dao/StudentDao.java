package com.jsoft.testmybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jsoft.testmybatis.bean.Student;

public interface StudentDao {

	// sql语句 改
	final String UPDATE = "update student set name = #{name,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER}";

	// sql语句 根据id查一条
	final String RETRIEVEBYPRIMARYKEY = "select s.id as s_id, s.name as s_name, k.id as k_id, k.name as k_name from student as s, klass as k where s.k_id = k.id and s.id = #{id,jdbcType=INTEGER}";

	// sql语句 分页查询
	final String RETRIEVEBYPAGE = "select s.id as s_id, s.name as s_name, k.id as k_id, k.name as k_name from student as s, klass as k where s.k_id = k.id and s.name like concat('%',#{student.name},'%') limit #{start}, #{size}";

	// sql语句 使用分页查询同样的条件 查询总条数
	final String RETRIEVECOUNT = "select count(*) from student as s, klass as k where s.k_id = k.id and s.name like concat('%',#{student.name},'%')";

	// 增
	@Insert("insert into student(name,k_id) values(#{name,jdbcType=VARCHAR},#{klass.id,jdbcType=INTEGER})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(Student student);

	// 删
	@Delete("delete from student where id = #{id,jdbcType=INTEGER}")
	int delete(Integer id);

	// 改
	@Update(UPDATE)
	int update(Student student);

	/**
	 * 此处如果不写result 列名--字段名 对应的话 会自动找名字相同的 此处我写了连接查询 只要将查询 返回的列名和类中的字段对应上就可以了
	 * 
	 * @param id
	 * @return
	 */
	// 根据id查一条
	@Select(RETRIEVEBYPRIMARYKEY)
	@Results(value = { @Result(property = "id", column = "s_id"), @Result(property = "name", column = "s_name"), @Result(property = "klass.id", column = "k_id"), @Result(property = "klass.name", column = "k_name") })
	Student retrieveByPrimaryKey(Integer id);

	// 分页+条件查询
	@Select(RETRIEVEBYPAGE)
	@Results(value = { @Result(property = "id", column = "s_id"), @Result(property = "name", column = "s_name"), @Result(property = "klass.id", column = "k_id"), @Result(property = "klass.name", column = "k_name") })
	List<Student> retrieveByPage(Map<String, Object> map);

	// 使用分页查询同样的条件 查询总条数
	@Select(RETRIEVECOUNT)
	int retrieveCount(Map<String, Object> map);

}
