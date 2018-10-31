// -----------------------------------------------------
// COMP 352
// Assignment #1
// Question 4 a)
// Written by: Olivier D'Angelo #26729916
// -----------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("\n Enter n for fib thingy:");
		int n = in.nextInt();
				
		int result = Fib(n);
		System.out.println("\n The Fibonacci of " + n + " is:" + result);
	}
	public static int Fib(int n, int x0, int x1) {
			if (n == 1) return 1;
			else if (n == 2) return 1;
			else return Fib(n-1)+Fib(n-2);
	}
}
