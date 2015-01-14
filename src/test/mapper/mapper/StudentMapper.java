package test.mapper.mapper;

import org.apache.ibatis.annotations.Param;

import test.mapper.entity.Student;

public interface StudentMapper {
	Student getStudent(@Param("id") int id,@Param("name") String name);
	
	Student getStudentByName(String name);
	
	int addStudent(Student student);
}
