package repository;

import java.lang.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import entity.*;
import interfaces.*;

public class StudentRepo implements IStudentRepo{
	DatabaseConnection dbc;
	//ArrayList<Student> st = new ArrayList<Student>();
	
	public StudentRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public Student searchStudent(String studentId){
		Student student = null;
		String query = "SELECT `name`, `studentId` FROM `attendancesheet` WHERE `studentId`='"+studentId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String sname = dbc.result.getString("name");
				String id = dbc.result.getString("studentId");
				
				student = new Student();
				student.setStudentId(id);
				student.setName(sname);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return student;
	}
	public void insertStudent(Student student){
		String query = "INSERT INTO attendancesheet (studentId,name) VALUES ('"+student.getStudentId()+"','"+student.getName()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		
	}
	public void updateStudent(Student student){
		String query = "UPDATE attendancesheet SET name='"+student.getName()+"' WHERE studentId='"+student.getStudentId()+"'";
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteStudent(String studentId){
		String query = "DELETE from attendancesheet WHERE studentId='"+studentId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public String[][] getAllStudent(){
		ArrayList<Student> ar = new ArrayList<Student>();
		String query = "SELECT * FROM attendancesheet;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String studentId = dbc.result.getString("studentId");
				String name = dbc.result.getString("name");
				String class1 = dbc.result.getString("class1");
				String class2 = dbc.result.getString("class2");
				String class3 = dbc.result.getString("class3");
				String class4 = dbc.result.getString("class4");
				String class5 = dbc.result.getString("class5");
				String class6 = dbc.result.getString("class6");
				String class7 = dbc.result.getString("class7");
				String class8 = dbc.result.getString("class8");
				String class9 = dbc.result.getString("class9");
				String class10 = dbc.result.getString("class10");
				String class11 = dbc.result.getString("class11");
				String class12 = dbc.result.getString("class12");
				
				Student s = new Student(studentId,name,class1,class2,class3,class4,class5,class6,class7,class8,class9,class10,class11,class12);
				ar.add(s);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][14];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Student)obj[i]).getStudentId();
			data[i][1] = ((Student)obj[i]).getName();
			data[i][2] = ((Student)obj[i]).getClass1();
			data[i][3] = ((Student)obj[i]).getClass2();
			data[i][4] = ((Student)obj[i]).getClass3();
			data[i][5] = ((Student)obj[i]).getClass4();
			data[i][6] = ((Student)obj[i]).getClass5();
			data[i][7] = ((Student)obj[i]).getClass6();
			data[i][8] = ((Student)obj[i]).getClass7();
			data[i][9] = ((Student)obj[i]).getClass8();
			data[i][10] = ((Student)obj[i]).getClass9();
			data[i][11] = ((Student)obj[i]).getClass10();
			data[i][12] = ((Student)obj[i]).getClass11();
			data[i][13] = ((Student)obj[i]).getClass12();
			

		}
		return data;
	}
	
	public void updateTable(String sId,String cName){
			String query = "UPDATE attendancesheet SET "+cName+"='1' WHERE studentId='"+sId+"'";
			try
			{
				dbc.openConnection();
				dbc.st.executeUpdate(query);
				dbc.closeConnection();
			}
			catch(Exception ex){
				System.out.println(ex.getMessage());
			}
	}
	public void correctTable(String sId,String cName){
			String query = "UPDATE attendancesheet SET "+cName+"='0' WHERE studentId='"+sId+"'";
			try
			{
				dbc.openConnection();
				dbc.st.executeUpdate(query);
				dbc.closeConnection();
			}
			catch(Exception ex){
				System.out.println(ex.getMessage());
			}
	}
	
}
	