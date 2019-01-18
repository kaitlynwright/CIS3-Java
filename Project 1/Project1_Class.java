import java.util.Scanner;

public class Project1_Class {
	
	public static void main(String[] args) {
		int sum = 0;
				
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a positive integer (-3 to print, -2 to reset, -1 to quit): ");
		
		int number = input.nextInt();
		
		while (number != -1) {
	
			if (number > 0) {
				sum = sum + number;
				System.out.println("Enter a positive integer (-3 to print, -2 to reset, -1 to quit): ");
				number = input.nextInt();
			}
			
			if (number == -3) {
				System.out.println("Sum: " + sum);
				System.out.println("Enter a positive integer (-3 to print, -2 to reset, -1 to quit): ");
				number = input.nextInt();
			}
		
			if (number == -2) {
				sum = 0;
				System.out.println("Enter a positive integer (-3 to print, -2 to reset, -1 to quit): ");
				number = input.nextInt();
			}
			
			if (number == 0 || number < -3) {
				System.out.println("Enter a positive integer (-3 to print, -2 to reset, -1 to quit): ");
				number = input.nextInt();	
			}
		}
		
		if (number == -1) {
			System.out.println("Sum: " + sum);
			System.out.println("Application terminated.");
		}
	}
}
		
