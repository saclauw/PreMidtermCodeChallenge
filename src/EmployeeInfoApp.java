import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//
//Create a class named Employees with these variables:
//String name
//int age
//String favoriteFood
//Your goal: 
//Write an application that lets users add new employees with the associated fields. 
//Users should also be able to see a list of all employees 
//and retrieve data regarding their age and/or favorite food 
//if the employee is selected from the list. 

public class EmployeeInfoApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String empInfo = " ";
		String empData = " ";
		String empAge = " ";
		String name = "Steven";
		int age = 29;
		String favoriteFood = "Pizza";
		int commaPos = 0;
		int numOfEmployees = 0;
		int i = 0;
		Employees employee = new Employees(name, age, favoriteFood);
		ArrayList<String> employeeList = new ArrayList<String>();
		ArrayList<Employees> employeeData = new ArrayList<Employees>();
		
		MainApp.createFile("employeelist.txt");
		
		Employees employee1 = new Employees("John Jacob", 22, "Schnitzel");
		employeeData.add(employee1);
		employeeList.add("John Jacob");
		MainApp.writeToFile("employeelist.txt", "John Jacob");
		MainApp.writeToFile("employeeinfo.txt", employee1);
		Employees employee2 = new Employees("Isaiah Nickel", 26, "Cotton Candy");
		employeeData.add(employee2);
		employeeList.add("Isaiah Nickel");
		MainApp.writeToFile("employeelist.txt", "Isaiah Nickel");
		MainApp.writeToFile("employeeinfo.txt", employee2);
		Employees employee3 = new Employees("Richard Milhouse Nixon", 68, "Cottage Cheese and Ketchup");
		employeeData.add(employee3);
		employeeList.add("Richard Milhouse Nixon");
		MainApp.writeToFile("employeelist.txt", "Richard Milhouse Nixon");
		MainApp.writeToFile("employeeinfo.txt", employee3);
		Employees employee4 = new Employees("Amy Mann", 38, "Kale Chips");
		employeeData.add(employee4);
		employeeList.add("Amy Mann");
		MainApp.writeToFile("employeelist.txt", "Amy Mann");
		MainApp.writeToFile("employeeinfo.txt", employee4);
		Employees employee5 = new Employees("Joan Muir", 58, "Granola");
		employeeData.add(employee5);
		employeeList.add("Joan Muir");
		MainApp.writeToFile("employeelist.txt", "Joan Muir");
		MainApp.writeToFile("employeeinfo.txt", employee5);
		Employees employee6 = new Employees("Joe Gorazcyk", 31, "Moscow Mule");
		employeeData.add(employee6);
		employeeList.add("Joe Gorazjcyk");
		MainApp.writeToFile("employeelist.txt", "Joe Gorazjcyk");
		MainApp.writeToFile("employeeinfo.txt", employee6);

		System.out.println("Welcome to employee information portal!");

		numOfEmployees = Validator.getInt(scan, "\nHow many employees are you going to add?", 0, 100);
		if (numOfEmployees > 0) {
			for (i = 0; i < numOfEmployees; i++) {
				System.out.print(
						"\nPlease enter the following for each employee as follows: (Name, Age, Favorite Food) ");
				empInfo = scan.nextLine();
				commaPos = empInfo.indexOf(",");
				name = empInfo.substring(0, commaPos);
				empData = empInfo.substring((commaPos + 1), empInfo.length()).trim();
				empAge = empData.substring(0, (empData.indexOf(",")));
				age = Integer.parseInt(empAge);
				favoriteFood = empData.substring((empData.indexOf(",") + 1), empData.length());
				favoriteFood = favoriteFood.trim();
				employee = new Employees(name, age, favoriteFood);
				employeeData.add(employee);
				employeeList.add(name);
				MainApp.writeToFile("employeelist.txt", name);
				MainApp.writeToFile("employeeinfo.txt", employee);
			} // end for
		} // end if

		System.out.println("\nHere is a list of employees: ");
		System.out.println("----------------------------");
			for (i = 0; i < employeeList.size(); i++) {
				System.out.println("This output is from an arrayList:" + (i + 1) + ". " + employeeList.get(i).toString());
			} // end for
			
			MainApp.readFromFile("employeelist.txt");
			
			int userChoice = Validator.getInt(scan, "\nWhich employee would you like more information about? (Enter number): ", 1, (employeeList.size() + 1));
			userChoice = userChoice - 1;
			System.out.println("\nThis output is from the arrayList: " + employeeData.get(userChoice).toString());
			MainApp.readFromFile("employeeinfo.txt", userChoice);
			
			
		scan.close();

	}

}
