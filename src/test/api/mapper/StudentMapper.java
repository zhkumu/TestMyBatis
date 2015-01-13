package test.api.mapper;

import test.api.entity.Student;

public interface StudentMapper {
	int addStudent(Student student);
	
	Student getStudent(int id);
}
