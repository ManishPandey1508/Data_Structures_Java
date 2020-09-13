package Stacks;

import java.util.*;


public class Student
{
    private String name;
    private int age;
	private String admissionDate;
	private double courseFee;

    public Student(String name, int age,String admissionDate,double courseFee)
    {
        this.name = name;
        this.age = age;
		this.admissionDate = admissionDate;
		this.courseFee = courseFee;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

	public String getAdmissionDate() {
		return admissionDate;
	}

	public double getCourseFee() {
		return courseFee;
	}

    public String toString()
    {
        String s = "Name:\t" + name + "Age:\t" + age + "\t" + "Course Fee: " + courseFee + "\t" + "Admission Date:" + admissionDate + "\n";
        return s;
    }
    
    public void display() {
    	System.out.println(toString());
    }
}

public static String getTotalStudentDebt(List<String> studCourseFeeListtemp) {
		double totalDebt = 0.0;
		for (String fees : studCourseFeeListtemp) {
			totalDebt += Double.parseDouble(fees);
		}
		return String.valueOf(totalDebt);
}

public static List<String> studentList = new ArrayList<String>();
public static List<String> studCourseFeeList = new ArrayList<String>();
On Input Row
  
//Student student =new Student(stud_name,Integer.parseInt(stud_age),stud_admission_date,Double.parseDouble(stud_course_fee));
//student.display();
if(!isNull("stud_age")){
  if(Integer.parseInt(stud_age) >= 25)
  {
    logError("The student is well beyond entrance age!!!");
    incrementErrorCount(1);
  }else {
  	String details = stud_name + " " + stud_age + " " + stud_admission_date + " " + stud_course_fee;
    studentList.add(details);
    studCourseFeeList.add(stud_course_fee);
    logInfo("Student details: "+ details);
  }
} else{
  setNull("stud_age");
}	

System.out.println("The Row type is: " + getInRowType());
logInfo("The Row type is: " + getInRowType());

At End Of Data

for(String str: studentList) {
	logInfo("calling generateRow");
	stud_details_out = str;
	generateRow();
	generateRow();
}
logInfo("Total Student Dept is: "+getTotalStudentDebt(studCourseFeeList));