package test.sql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.sql.entity.Student;
import test.sql.mapper.StudentMapper;





public class Test {

	public static void main(String[] args) throws IOException {
		//insert();
		//getStudents();
		getStudentByName();
	}
	
	public static void insert() throws IOException{
		InputStream stream=Resources.getResourceAsStream("test/sql/mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
		SqlSession session= factory.openSession(true);
		StudentMapper studentMapper= session.getMapper(StudentMapper.class);
		Student student=new Student();
		student.setName("中文5");
		student.setBirthday(new Date());
		student.setRemark("testapi");
		int result= studentMapper.addStudent(student);
		session.commit(true);
		System.out.println(result);
		stream.close();
		session.close();
	}
	
	public static Student getStudent() throws IOException{
		InputStream stream=Resources.getResourceAsStream("test/sql/mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
		SqlSession session= factory.openSession();
		Student student=session.getMapper(StudentMapper.class).getStudent(3);
		System.out.println(student);
		stream.close();
		session.close();
		return student;
	}
	
	public static void getStudents() throws IOException{
		InputStream stream=Resources.getResourceAsStream("test/sql/mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
		SqlSession session= factory.openSession();
		int[] ids={1,2,3};
		List<Student> list=session.getMapper(StudentMapper.class).getStudents(ids);
		System.out.println(list);
		stream.close();
		session.close();
	}
	
	public static void getStudentByName() throws IOException{
		InputStream stream=Resources.getResourceAsStream("test/sql/mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
		SqlSession session= factory.openSession();
		Student student=session.getMapper(StudentMapper.class).getStudentByName("mu");
		System.out.println(student);
		stream.close();
		session.close();

	}
	
}
