package sdbms;

//3.)MainClass
import java.util.Scanner;

import customexception.InvaildChoiceException;
public class Solution {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Welcome to the Student data base");
		System.out.println("-----------------------------------");

		//1.sacnner
		//2.sms = smsimpl()-->upcasting-->abstraction
		//3.infinite loop -->while(true)
		//4.menu drive prg-->display-->1:addStudent 2:.....11:exit
		//5.switch-->case1:............case:11: default:


		//upcasting for achiveing abstraction
		StudentManagementSystem sms = new StudentManagementSystemImpl();

		//infinite loop
		while(true) {

			//menu drive program
			System.out.println("1:addStudent");
			System.out.println("2:displayStudent");
			System.out.println("3:displayAllStuden");
			System.out.println("4:removeStudent");
			System.out.println("5:removeAllStudent");
			System.out.println("6:updateStudent");
			System.out.println("7:countStudent");
			System.out.println("8:sortStudent");
			System.out.println("9:findStudentWithHighestMarks");
			System.out.println("10:findStudentWithLowestMarks");
			System.out.println("11:Exit\nEnter choice");

			int choice = ip.nextInt();
			switch(choice) {

			case 1:
				sms.addStudent();
				break;

			case 2:
				sms.displayStudent();
				break;

			case 3:
				sms.displayAllStudent();
				break;

			case 4:
				sms.removeStudent();
				break;

			case 5:
				sms.removeAllStudent();
				break;

			case 6:
				sms.updateStudent();
				break;

			case 7:
				sms.countStudent();
				break;

			case 8:
				sms.sortStudent();
				break;

			case 9:
				sms.findStudentWithHighestMarks();
				break;

			case 10:
				sms.findStudentWithLowestMarks();
				break;

			case 11:
				System.out.println("Thank you!");
				System.exit(0);


			default:
				try {
					String message="Invaild Choice,Enter vaild choice";
					throw new InvaildChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());

				}

			}// end of switch
			System.out.println("--------------------------");
		}//end of while loop

	}//end of mainMethod

}

//auto generating id
