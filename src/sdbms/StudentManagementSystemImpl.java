package sdbms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
//2.)Implementation class
import java.util.Scanner;
import java.util.Set;

import customSorting.SortStudentByAge;
import customSorting.SortStudentById;
import customSorting.SortStudentByMarks;
import customSorting.SortStudentByName;
import customexception.InvaildChoiceException;
import customexception.StudentNotFoundException;


public class StudentManagementSystemImpl implements StudentManagementSystem{

	Scanner ip = new Scanner(System.in);
	//key-->Student Id & value-->Student Object

	Map<String, Student> db = new LinkedHashMap<String,Student>();

	@Override
	public void addStudent() {
		//Accept age;
		//Accept name;
		//Accept age;
		//Accept marks;
		// create a student object
		//db-->map-->put()-->id, std
		//print the student id.

		System.out.println("Enter Student Age");
		int age=ip.nextInt();

		System.out.println("Enter Student Name");
		String name=ip.next();

		System.out.println("Enter Student Marks");
		int marks=ip.nextInt();

		Student std = new Student(age,name,marks);


		//adding enter inside db(map)
		db.put(std.getId(), std);

		System.out.println("Student record inserted successfuly!");
		System.out.println("your student id is"+std.getId());
	}


	@Override
	public void displayStudent() {
		//convert toUppercase()-->jsp101, Jsp101, JSP101
		//check if id is present or not--->containsKey()
		//if-->get the student object-->get()-->getAge(), getName()..

		//Accept student id
		System.out.println("Enter student Id:");
		String id=ip.next();// we are doing this single line also-->String id= ip.next().toUppercase()
		id=id.toUpperCase();

		//checking if the id is present or not-->(id==key)
		if(db.containsKey(id)) {

			System.out.println("Student Record Found");
			System.out.println("student Details are Follows:");
			System.out.println("----------------------------------");
			Student std=db.get(id);//getting student object based on id
			System.out.println("Id:"+std.getId());
			System.out.println("Age:"+std.getAge());
			System.out.println("Name:"+std.getName());
			System.out.println("Marks:"+std.getMarks());
			//printing reference variable as toString() is overridden
			//System.out.println(std);
		}
		else {
			//else-->StudentNotFoundException
			try {
				String message = "Student with Id"+id+"is Not Found!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void displayAllStudent() {

		if(!db.isEmpty()) {//checking if db is not empty
			System.out.println("Student recoreds are Follows:");
			System.out.println("---------------------------------");

			Set<String> keys = db.keySet();//jsp101, jsp102, jsp103 comes this o/p
			for(String key : keys) {
				Student std = db.get(key);//getting student object
				System.out.println(std);//toString() is overridden
				//System.out.println(db.get(key));
			}

		}
		else {
			//StudentNotFoundException
			try {
				String message="No student Records to desplay";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void removeStudent() {
		//Accept StudentId-->toUppercase()
		//containsKey()
		//if-->db.remove(id)
		//else-->SNFE
		System.out.println("Enter Student id:");
		String id=ip.next();
		id=id.toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("Student Record Found");
			System.out.println(db.get(id));//printing student object
			db.remove(id);//remove the entry (key & value)
			System.out.println("Student Record Deleted Successfuly");
		}
		else {
			try {
				String message = "Student with Id"+id+"is not Found";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}


	@Override
	public void removeAllStudent() {
		if(!db.isEmpty()) {
			System.out.println("No of Student Records:"+db.size());
			db.clear();
			System.out.println("All Student Records Deleted Successfully");
		}
		else {
			try {
				String message = "No Student Records to Delete!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void  updateStudent() {

		System.out.println("Enter student Id:");
		String id=ip.next().toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("Student record is Found");
			Student std = db.get(id);//getting value (Student object)

			System.out.println("1:Update Age: \n2:Update Name:");
			System.out.println("3:Update Marks: \n4:Enter Choice");
			int choice = ip.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter Age:");
				int age=ip.nextInt();
				std.setAge(age);//std.setAge(ip.nextInt());
				System.out.println("Age Update sucessfully");
				break;

			case 2:
				System.out.println("Enter Name:");
				String name=ip.next();
				std.setName(name);
				System.out.println("Name Update sucessfully");
				break;

			case 3:
				System.out.println("Enter Marks");
				int marks=ip.nextInt();
				std.setMarks(marks);
				System.out.println("Marks Update sucessfully");
				break;

			default:
				try {
					String message ="Invaild Choice, Enter Vaild Choice";
					throw new InvaildChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message ="Student with Id "+id+"is not Found!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	
	@Override
	public void countStudent() {
		System.out.println("No of students stored Records:"+db.size());

	}

	@Override
	public void  sortStudent() {

		/** documentation comment (**)blue color,
		 * 
		 * we cannot sort map based on values, therfoure we are getting
		 * the values from the map & storing it inside list so that we can sort
		 * list using-->Collection.sort(list, soeting logic object);*/
		
		//Referance of List & object of arrayList storing Student Objects
		List<Student> list = new ArrayList<Student>();
		
		//convering Map into set, witch stores keys(Id)
		Set<String> keys =db.keySet();
		
		//Traversing keys(Id)
		for(String key : keys) {
			//getting value (Student object) & adding it into List
			list.add(db.get(key));
		}
		
		System.out.println("1:Sort Student Id:\n2:Sort Student By Name:");
		System.out.println("3:Sort Student Age:\n4:Sort Student Marks:");
		System.out.println("Enter choice");
		int choice = ip.nextInt();
		
		switch(choice) {
		case 1:
			Collections.sort(list,new SortStudentById());
			for(Student s:list) {
				System.out.println(s);
			}
			break;
			
		case 2:
			Collections.sort(list,new SortStudentByName());
			for(Student s:list) {
				System.out.println(s);
			}
			break;
			
		case 3:
			Collections.sort(list,new SortStudentByAge());
			for(Student s:list) {
				System.out.println(s);
			}
			break;
			
		case 4:
			Collections.sort(list,new SortStudentByMarks());
			for(Student s:list) {
				System.out.println(s);
			}
			break;
			
			default:
				try {
					String message ="Invaild Choice, Enter Vaild Choice";
					throw new  InvaildChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
		}
	}

	
	
	@Override
	public void findStudentWithHighestMarks() {
		
		List<Student> list = new ArrayList<Student>();
		Set<String> keys =db.keySet();
		for(String key : keys) {
			list.add(db.get(key));// adding student object from map into list
		}
		Collections.sort(list, new SortStudentByMarks());
		System.out.println("Student with lowest Marks:");
		System.out.println(list.get(list.size()-1));

	}


	@Override
	public void findStudentWithLowestMarks() {

		List<Student> list = new ArrayList<Student>();
		Set<String> keys =db.keySet();
		for(String key : keys) {
			list.add(db.get(key));//adding student object from map into list
		}
		Collections.sort(list, new SortStudentByMarks());
		System.out.println("Student with lowest Marks:");
		System.out.println(list.get(0));
	}

}
