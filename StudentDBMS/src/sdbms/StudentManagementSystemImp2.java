package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customException.StudentNotFoundException;
import customSorting.SortStudentByAge;
import customSorting.SortStudentById;
import customSorting.SortStudentByMarks;
import customSorting.SortStudentByName;

public class StudentManagementSystemImp2 implements StudentManagementSystem {
	Scanner scan=new Scanner(System.in);
	Map<String,Student2> db=new LinkedHashMap<String,Student2>();
	
	@Override
	public void addStudent()
	{	
		System.out.println("enter the age");
		int age=scan.nextInt();
		System.out.println("enter the name");
		String name=scan.next();
		System.out.println("enter the marks");
		int marks=scan.nextInt();
		Student2 std=new Student2(age, name, marks);
		db.put(std.getId(),std);
		System.out.println("Student Record Inserted Sucessfully");
		System.out.println("Student id is "+std.getId());
		
	}
	@Override
	public void displayStudent()
	{
	System.out.println("enter student id:");
	String id=scan.next();
	id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Student2 s=db.get(id);
			System.out.println(id);
			System.out.println("id:"+s.getId());
			System.out.println("Age"+s.getAge());
			System.out.println("Name:"+s.getName());
			System.out.println("Marks:"+s.getMarks());
			
		}
		else {
			try
			{
				throw new StudentNotFoundException("kindaly with"+id+" is not found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	}
	@Override
	public void displayAllStudent()
	{
		System.out.println("student details are follws:");
		System.out.println("---------------------");
		Set<String> keys=db.keySet();
		for(String key:keys)
		{
			Student2 obj=db.get(key);
			System.out.println(obj);//System.out.println(db.get(key);
			
		}
		
	}
	@Override
	public void removeStudent()
	{
		System.out.println("enter student id:");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Student record found!");
			System.out.println(db.get(id));//getting student object & printing it
			db.remove(id);
			System.out.println("Student record Deleted Sucessfully");
		}
		else
		{
				try
				{
					throw new StudentNotFoundException(" Student with id "+id+" is not found");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		
		
	@Override
	public void removeAllStudents()
	{
		if(db.size()!=0)
		{
			System.out.println("Available student Records:"+db.size());
		db.clear();
		System.out.println("All the student deleted sucessfully");
	}
		else
		{
			try {
				throw new StudentNotFoundException("No Student Records do Delete");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateStudent()
	{
		System.out.println("enter student id:");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
		 Student2 std=db.get(id);
		 System.out.println("1.update age\n2.Update name\n3:Upates Marks");
		 System.out.println("Enter choice:");
		int choice=scan.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("enter the student age");
		 int age=scan.nextInt();
		 std.setAge(age);
		 System.out.println("Age upated Sucessfully");
		break;
		case 2:
			System.out.println("enter the student age");
			 String name=scan.next();
			 std.setName(name);//std.setName(scan.nextInt());
			 System.out.println("name upated Sucessfully");
			break;
		case 3:
			System.out.println("enter the student age");
			 int marks=scan.nextInt();
			 std.setMarks(marks);
			 System.out.println("marks upated Sucessfully");
			
			break;
			default:
				try {
					throw new StudentNotFoundException("kindly enter valid choice!");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
		}
		}
		else
		{
			try
			{
				throw new StudentNotFoundException("Student with id"+id+" is not found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
}
	@Override
	public void countStudent()
	{
		System.out.println("no of students"+db.size());
	}
	@Override
	public void sortStudent()
	{
	Set<String> keys=db.keySet();
	List<Student2> list=new ArrayList<Student2>();
	for(String key:keys)
	{
		Student2 s=db.get(key);
		list.add(s);//list.add(db.get(key));
	}
	System.out.println("1:sort by id\n2:sort by age\n3:Sort by name");
	System.out.println("4:sort by marks\nenter choice:" );
	int choice=scan.nextInt();
	switch(choice)
	{
	case 1:
		Collections.sort(list,new SortStudentById());
		display(list);
		break;
	case 2:
		Collections.sort(list,new SortStudentByAge());
		display(list);
		
		break;
	case 3:
		Collections.sort(list,new SortStudentByName());
		display(list);
		break;
	case 4:
		Collections.sort(list,new SortStudentByMarks());
		display(list);
		break;
		default:
			try {
				throw new StudentNotFoundException("No Student Records do Delete");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	}
	}
			private static void display(List<Student2> list)
			{
				for(Student2 s:list)
				{
					System.out.println(s);
				}
			}
			@Override
			public void getStudentWithHighestMarks() {
			 Set<String> keys=db.keySet();
			 List<Student2>list=new ArrayList<Student2>();
			 for(String key:keys)
			 {

				 list.add(db.get(key));
			 }
			 Collections.sort(list,new SortStudentByMarks());
			 System.out.println("Student Details with Highest Marks:");
			 System.out.println(list.get(list.size()-1));
				
			}
			@Override
			public void getStudentWithLowestMarks() {
				
				Set<String> keys=db.keySet();
				 List<Student2>list=new ArrayList<Student2>();
				 for(String key:keys)
				 {

					 list.add(db.get(key));
				 }
				 Collections.sort(list,new SortStudentByMarks());
				 System.out.println("Student Details with Lowest Marks:");
				 System.out.println(list.get(0));
				
			}
			
	}
		