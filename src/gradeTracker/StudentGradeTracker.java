package gradeTracker;

import java.util.Scanner;
import java.util.ArrayList;

public class StudentGradeTracker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Double> list = new ArrayList<>();
        
		System.out.println("-----------------------------");
		System.out.println("Simple Student Grade Tracker");
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("Enter a number of grades you want to enter: ");
        int n=sc.nextInt();
       
        System.out.println("Enter "+n+ " grades: ");
        
		for(int i=0;i<n;i++) {
			double grd=sc.nextDouble();
			list.add(grd);
		}

		if(list.isEmpty()) {
			System.out.println("Grade is not entered.");
		}
		else {
			double sum = 0;
			double highest = list.get(0);
			double  lowest = list.get(0);


			for(double grade : list) {
				sum =sum+grade;

				if(grade>highest) {
					highest = grade;
				}
				if(grade<lowest) {
					lowest = grade;
				}

			}
			System.out.println("-----------------------------");

			double average = sum / list.size();

			System.out.println("Average grade: " + average);
			System.out.println();
			System.out.println("Highest grade: " + highest);
			System.out.println();
			System.out.println("Lowest grade: " + lowest);
			
		}
		
		sc.close();
		
	}
}




