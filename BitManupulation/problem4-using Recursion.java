/*  MINIMUM NUMBER OF OPERATIONS TO CONVERT GIVEN NUMBER TO 1
 * 
 *  Given a positive integer n and you can do operations as follow:
 *  
 *	1.	If n is even, replace n with n/2.
 *	2.	If n is odd, you can replace n with either n + 1 or n - 1.
 *
 *	What is the minimum number of replacements needed for n to become 1?
 *
 *	Test case 1:
 *	   Input:8
 *	   Output:3
 *
 *  Test case 2:
 *	   Input:62
 *	   Output:7
 *
 *  Test case 3:
 *	   Input:15
 *	   Output:5
 *
 *	Test case 4:
 *	   Input: 24
 *	   Output:5
 *
 */
package suntekassignments;

import java.util.Scanner;

public class problem4 {
	public static int convertToOne(int k)
	{
		if(k==1)
			return 0;
		if(k%2==0)
			return convertToOne(k/2)+1;
		else 
			return Integer.min(convertToOne(k-1),convertToOne(k+1))+1;
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(convertToOne(n));
		
	}

}
