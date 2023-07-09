package sdbms;

import java.util.Scanner;

import customException.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		
	System.out.println("welcome to Student management System");
	System.out.println("------------------------------------");
	Scanner scan=new Scanner(System.in);
	StudentManagementSystem s1=new StudentManagementSystemImp2();
	while(true)
	{
		System.out.println("1.Add student\n2.Display Student\n3.displayAllStudent\n4.removeStudent\n5.removeAllStudents\n6.updateStudent\n7.countStudent\n8.sortStudent\n9.exit\n10.getStudentWithHighestMarks\n11.getStudentWithLowestMarks");
		System.out.println("display the choice");
		int choice=scan.nextInt();
	switch(choice)
	{
	case 1:
		s1.addStudent();
		break;
	case 2:
		s1.displayStudent();
		break;
	case 3:
		s1.displayAllStudent();
		break;
	case 4:
		s1.removeStudent();
		break;
	case 5:
		s1.removeAllStudents();
		break;
	case 6:
		s1.updateStudent();
		break;
	case 7:
		s1.countStudent();
		break;
	case 8:
		s1.sortStudent();
		break;
	case 9:
		System.out.println("Thank you");
		System.exit(0);
		break;
	case 10:
		s1.getStudentWithHighestMarks();
		break;
	case 11:
		s1.getStudentWithLowestMarks();
		break;
		default:
			try {
				throw new InvalidChoiceException("Kindly enter valid choice");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	}
	System.out.println("--------------------------");
	}
	}
}