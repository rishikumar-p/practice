/*
 * Counting Minimum Number of bit flips to convert  OR of two positive integers  to another positive integer (a OR b ==c)
 *  
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * 
 *   Input: a = 2, b = 6, c = 5
 *   Output: 3 //minimum number of bit flips
 * 
 * Test case 1:
 *   Input: a =15 , b = 0, c = 3
 * 	 Output: 2
 * 
 * Test case 2:
 *    Input: a = 2, b = 6, c = 5
 * 	 Output: 3
 *  
 * Test case 3:
 *   Input: a = 15, b = 15, c = 1
 *   Output: 6
 * 
 * Test case 4:
 *   Input: a = 7, b = 7, c = 0
 *   Output: 6
 *   
 * Test case 5:
 *   Input: a = 0 , b = 0, c = 7
 *   Output: 3
 * 
 * 
 */
package suntekassignments;

import java.util.Scanner;

public class problem2 {

	public static int countNoOfFlips(int a,int b,int c)
	{
		int count=0;
		int abit,bbit,cbit;
		while(a>0||b>0||c>0)
		{
			abit=a&1; //calculating last bit of a
			bbit=b&1; //calculating last bit of b
			cbit=c&1; //calculating last bit of c
			if((abit | bbit) != cbit)
			{
				if((abit|bbit)==0)
					count++;
				else 
					if((abit&bbit)==0)
						count++;
					else 
						count+=2;
			}
			a=a>>1; //right shifting a
			b=b>>1; //right shifting a
			c=c>>1; //right shifting a
		}
		return count;
	}
	public static void main(String[] args) {
		int a,b,c;
		System.out.print("Entetr a, b, c values :");
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		System.out.println(countNoOfFlips(a, b, c));
		
		sc.close();

	}

}
