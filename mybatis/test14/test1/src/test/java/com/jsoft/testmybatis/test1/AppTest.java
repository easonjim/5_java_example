package com.jsoft.testmybatis.test1;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jsoft.testmybatis.bean.Klass;
import com.jsoft.testmybatis.bean.Student;
import com.jsoft.testmybatis.dao.StudentDao;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	/***************************** 以下方法为配置文件方法 ************************************/
	// 向 班级表 插入一条数据
	public void test1_1() throws IOException {
		Klass klass = new Klass();
		klass.setName("二年一班");
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		// 构建SqlSessionFactory 即session工厂, 用来产生session
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		// 从session工厂中获得session
		SqlSession sqlSession = factory.openSession();
		int k = sqlSession.insert("KlassMapper.insertSelective", klass);
		// 利用 返回数 来控制 进行 提交或者是回滚操作
		if (k == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		System.out.println(klass);
		// 关闭session
		sqlSession.close();
	}

	// 向 班级表 批量 插入数据
	public void test1_2() throws IOException {
		List<Klass> list = new ArrayList<Klass>();
		for (int i = 0; i < 10; i++) {
			Klass klass = new Klass();
			klass.setName("二年一班" + i);
			list.add(klass);
		}
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession(ExecutorType.BATCH);
		for (Klass k : list) {
			int i = sqlSession.insert("KlassMapper.insertSelective", k);
			sqlSession.commit();
			System.out.println(k);
		}
		sqlSession.close();
	}

	// 向 学生表中 插入一条数据 带班级信息
	public void test1_3() throws IOException {
		Student stu = new Student();
		stu.setName("hebe");
		// 设置班级, 注意看StudentMapper映射文件中的写法,如果数据库有外键关联的话, 此属性不能为空！
		stu.setKlass(new Klass(1));
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		int k = sqlSession.insert("StudentMapper.insertSelective", stu);
		sqlSession.commit();
		System.out.println(stu);
		sqlSession.close();
	}

	// 删除 班级表 一条数据
	public void test2_1() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		int i = sqlSession.delete("KlassMapper.deleteByPrimaryKey", 17);
		sqlSession.commit();
		System.out.println(i);
		sqlSession.close();
	}

	// 批量删除 班级表 数据
	public void test2_2() throws IOException {
		List<Integer> list = new ArrayList<Integer>();
		list.add(34);
		list.add(35);
		list.add(36);
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		int i = sqlSession.delete("KlassMapper.deleteByBatch", list);
		sqlSession.commit();
		System.out.println(i);
		sqlSession.close();
	}

	// 更新 班级表 一条数据 数据, 批量修改可以参照上面的批量删除
	public void test3_1() throws IOException {
		Klass klass = new Klass();
		klass.setId(16);
		klass.setName("四年五班");
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		int i = sqlSession.update("KlassMapper.updateByPrimaryKey", klass);
		sqlSession.commit();
		System.out.println(i);
		sqlSession.close();
	}

	// 查询 根据id查询 一个班级
	public void test4_1() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		Klass klass = sqlSession.selectOne("KlassMapper.retrieveByPrimaryKey", 16);
		System.out.println(klass);
		sqlSession.close();
	}

	// 分页查询① 使用自定义参数, 控制 起始索引和返回量
	public void test4_2() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", 0);
		map.put("size", 999);
		List<Klass> list = sqlSession.selectList("KlassMapper.retrieveByPage", map);
		System.out.println(list.size());
		sqlSession.close();
	}

	// 分页查询② 使用mybatis提供的参数, 控制 起始索引和返回量
	public void test4_3() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		// 起始索引, 返回量
		RowBounds row = new RowBounds(0, 20);
		List<Klass> list = sqlSession.selectList("KlassMapper.retrievePages", map, row);
		System.out.println(list.size());
		sqlSession.close();
	}

	// 级联查询 根据学生id查询 一个带班级信息的学生对象
	public void test4_4() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		Student stu = sqlSession.selectOne("StudentMapper.retrieveByPrimaryKey", 1);
		System.out.println(stu);
		sqlSession.close();
	}

	// 级联查询 根据班级id 查询 一个带学生列表的班级对象
	public void test4_5() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		Klass klass = sqlSession.selectOne("KlassMapper.retrieveKlassWithStudent", 1);
		System.out.println(klass.getStudents().size());
		for (Student s : klass.getStudents()) {
			System.out.println(s);
		}
		sqlSession.close();
	}

	// 级联查询 根据班级id 查询 一个带学生列表的班级对象,使用了foreach标签, 迭代多个参数
	public void test4_6() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int[] ids = new int[] { 1, 2 };
		map.put("list", ids);
		List<Student> stuList = sqlSession.selectList("StudentMapper.retrieveByMultiId", map);
		System.out.println(stuList.size());
		for (Student s : stuList) {
			System.out.println(s);
		}
		sqlSession.close();
	}

	// 级联查询 根据班级id 查询 一个带学生列表的班级对象,使用了bind标签, 绑定参数
	public void test4_7() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Student stu = new Student();
		stu.setName("m");
		map.put("student", stu);
		List<Student> stuList = sqlSession.selectList("StudentMapper.retrieveStudentLike", map);
		System.out.println(stuList.size());
		for (Student s : stuList) {
			System.out.println(s);
		}
		sqlSession.close();
	}

	/***************************** 以下方法为注解方法 ************************************/
	// 插入一条数据
	public void testA1_1() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		// 将接口 StudentMapper 加载到配置中, 如不加载, 则会报 找不到该接口的错
		Configuration config = factory.getConfiguration();
		config.addMapper(StudentDao.class);
		SqlSession sqlSession = factory.openSession();
		StudentDao stuMapper = sqlSession.getMapper(StudentDao.class);
		Student stu = new Student();
		stu.setName("ella");
		stu.setKlass(new Klass(2));
		int k = stuMapper.insert(stu);
		System.out.println("插入 : " + k + " 条!");
		if (k == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		System.out.println(stu);
	}

	// 删除一条数据
	public void testA2_1() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		Configuration config = factory.getConfiguration();
		config.addMapper(StudentDao.class);
		SqlSession sqlSession = factory.openSession();
		StudentDao stuMapper = sqlSession.getMapper(StudentDao.class);
		int k = stuMapper.delete(17);
		System.out.println("删除 : " + k + " 条!");
		if (k == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
	}

	// 更新一条数据
	public void testA3_1() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		Configuration config = factory.getConfiguration();
		config.addMapper(StudentDao.class);
		SqlSession sqlSession = factory.openSession();
		StudentDao stuMapper = sqlSession.getMapper(StudentDao.class);
		Student student = new Student(16);
		student.setName("eve");
		int k = stuMapper.update(student);
		System.out.println("更新 : " + k + " 条!");
		if (k == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
	}

	// 查 一条数据
	public void testA4_1() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		Configuration config = factory.getConfiguration();
		config.addMapper(StudentDao.class);
		SqlSession sqlSession = factory.openSession();
		StudentDao stuMapper = sqlSession.getMapper(StudentDao.class);
		Student stu = stuMapper.retrieveByPrimaryKey(2);
		System.out.println(stu);
		sqlSession.close();
	}

	// 查 分页查询
	public void testA4_2() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		Configuration config = factory.getConfiguration();
		config.addMapper(StudentDao.class);
		SqlSession sqlSession = factory.openSession();
		StudentDao stuMapper = sqlSession.getMapper(StudentDao.class);
		Student stu = new Student();
		stu.setName("m");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("student", stu);
		// 注意: 起始参数是指索引值, 从0开始, 注意页数和索引值得转换
		map.put("start", 0);
		// 返回量
		map.put("size", 10);
		List<Student> list = stuMapper.retrieveByPage(map);
		System.out.println("查询到  " + list.size() + " 条");
		for (Student s : list) {
			System.out.println(s);
		}
		sqlSession.close();
	}

	// 查 总页数
	public void testA4_3() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		Configuration config = factory.getConfiguration();
		config.addMapper(StudentDao.class);
		SqlSession sqlSession = factory.openSession();
		StudentDao stuMapper = sqlSession.getMapper(StudentDao.class);
		Student stu = new Student();
		stu.setName("m");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("student", stu);
		int page = stuMapper.retrieveCount(map);
		System.out.println("共查到  " + page + " 条数据");
		sqlSession.close();
	}
}
