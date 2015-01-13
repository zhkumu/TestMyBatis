package test.sql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import test.sql.entity.Student;


public interface StudentMapper {
	int addStudent(Student student);
	
	Student getStudent(@Param("id") int id);
	
	List<Student> getStudents(int[] ids);
	
	Student getStudentByName(@Param("name") String name);
}
