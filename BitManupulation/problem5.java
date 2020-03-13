/*
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary 
 * representation and return them as an array.
 *	Example 1:
 *	Input: 2
 *	Output: [0,1,1]
 *  •  It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 *  •  Space complexity should be O(n).
 *  
 *  Test case :1
 *     input=10
 *     output=0 1 1 2 1 2 2 3 1 2 2
 *    
 *   Test case 2:
 *     input=18
 *     output=0 1 1 2 1 2 2 3 1 2 2 3 2 3 3 4 1
 *     
 *   Test case 3:
 *     input=5
 *     output=0 1 1 2 1 2
 *   
 * 
*/

package suntekassignments;
import java.util.Scanner;
public class problem5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int noOfSetBits[]=new int[n+1];
		noOfSetBits[0]=0;
		if(n>0)
		noOfSetBits[1]=1;
		int p=1;
		for(int i=2;i<=n;i++)
		{
			if(p*2==i)
				p*=2;
			noOfSetBits[i]=noOfSetBits[i-p]+1;
		}
		for(int i=0;i<=n;i++)
			System.out.print(noOfSetBits[i]+" ");
	}

}
