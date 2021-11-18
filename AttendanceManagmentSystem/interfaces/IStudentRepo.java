package interfaces;

import java.lang.*;

import entity.*;

public interface IStudentRepo
{
	Student searchStudent(String studentId);
	void insertStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(String studentId);
}