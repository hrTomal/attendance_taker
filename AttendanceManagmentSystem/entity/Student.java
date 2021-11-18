package entity;

import java.lang.*;

public class Student{
	private String studentId;
	private String name;
	private String class1,class2,class3,class4,class5,class6,class7,class8,class9,class10,class11,class12;
	
	public Student(){	}
	public Student(String studentId, String name){
		this.studentId = studentId;
		this.name = name;
	}
	public Student(String studentId, String name, String class1,String class2,String class3,String class4,String class5, String class6,
					String class7, String class8, String class9, String class10, String class11, String class12){
		this.studentId = studentId;
		this.name = name;
		this.class1 = class1;
		this.class2 = class2;
		this.class3 = class3;
		this.class4 = class4;
		this.class5 = class5;
		this.class6 = class6;
		this.class7 = class7;
		this.class8 = class8;
		this.class9 = class9;
		this.class10 = class10;
		this.class11 = class11;
		this.class12 = class12;
	}
	
	public void setStudentId(String studentId){this.studentId = studentId;}
	public void setName(String name){this.name = name;}
	public void setClass1(String class1){this.class1 = class1;}
	public void setClass2(String class2){this.class2 = class2;}
	public void setClass3(String class3){this.class3 = class3;}
	public void setClass4(String class4){this.class4 = class4;}
	public void setClass5(String class5){this.class5 = class5;}
	public void setClass6(String class6){this.class6 = class6;}
	public void setClass7(String class7){this.class7 = class7;}
	public void setClass8(String class8){this.class8 = class8;}
	public void setClass9(String class9){this.class9 = class9;}
	public void setClass10(String class10){this.class10 = class10;}
	public void setClass11(String class11){this.class11 = class11;}
	public void setClass12(String class12){this.class12 = class12;}

	
	public String getStudentId(){return studentId;}
	public String getName(){return name;}
	public String getClass1(){return class1;}
	public String getClass2(){return class2;}
	public String getClass3(){return class3;}
	public String getClass4(){return class4;}
	public String getClass5(){return class5;}
	public String getClass6(){return class6;}
	public String getClass7(){return class7;}
	public String getClass8(){return class8;}
	public String getClass9(){return class9;}
	public String getClass10(){return class10;}
	public String getClass11(){return class11;}
	public String getClass12(){return class12;}
	

	
}