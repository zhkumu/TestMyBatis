package test.typehandler;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.typehandler.entity.Student;
import test.typehandler.mapper.StudentMapper;



public class Test {

	public static void main(String[] args) throws IOException {
		InputStream stream=Resources.getResourceAsStream("test/typehandler/mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
		SqlSession session= factory.openSession();
		StudentMapper studentMapper= session.getMapper(StudentMapper.class);
		Student student= studentMapper.getStudent(1);
		System.out.println(student);
		stream.close();
	}

}
