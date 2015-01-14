package test.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.config.entity.Student;
import test.config.mapper.StudentMapper;



public class Test {

	public static void main(String[] args) throws IOException {
		//insert();
		getStudent();
	}
	
	public static void insert() throws IOException{
		InputStream stream=Resources.getResourceAsStream("test/config/mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
		SqlSession session= factory.openSession(true);
		StudentMapper studentMapper= session.getMapper(StudentMapper.class);
		Student student=new Student();
		student.setName("中文4");
		student.setBirthday(new Date());
		student.setRemark("testapi");
		int result= studentMapper.addStudent(student);
		session.commit(true);
		System.out.println(result);
		stream.close();
		session.close();
	}
	
	public static Student getStudent() throws IOException{
		InputStream stream=Resources.getResourceAsStream("test/config/mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
		SqlSession session= factory.openSession();
		Student student=session.getMapper(StudentMapper.class).getStudent(0);
		System.out.println(student);
		stream.close();
		session.close();
		return student;
	}
	
}
