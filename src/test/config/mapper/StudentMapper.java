package test.config.mapper;

import test.config.entity.Student;



public interface StudentMapper {
	int addStudent(Student student);
	
	Student getStudent(int id);
}
