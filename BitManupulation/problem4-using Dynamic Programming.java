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
	public static void convertToOne(int value,int[] minSteps)
	{
		
		for(int i=3;i<=value;i++)
		{
			if(i%2==0)
				minSteps[i]=minSteps[i/2]+1;
			else {
				minSteps[i]=Integer.min(minSteps[i-1],minSteps[(i+1)/2]+1)+1;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int minSteps[]=new int[number+1];
		minSteps[1]=0;
		minSteps[2]=1;
		convertToOne(number,minSteps);
		System.out.println(minSteps[number]);
		sc.close();
	}

}
