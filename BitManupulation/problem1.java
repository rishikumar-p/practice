/* Problem 1
 * 
 * Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri], for each query
 *  i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ).
 *  Return an array containing the result for the given queries.
 *  
 * Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 
 * Output: [2,7,14,8] 
 * 
 * sizeOfArray = size of the input array
 * 
 * noOfQueries = number of the queries
 * 
 * arr[]= an array consisting the  elements
 * 
 * queries[][2]=a two dimensional array in which each row consisting Li(left index) and Ri(right index)
 */

import java.util.Scanner;

public class problem1 {

		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int sizeOfArray,noOfQueries;
			
			//taking the size and elements of the array
		        //System.out.println("Enter the size of the array ");
			sizeOfArray=sc.nextInt();
			int arr[]=new int[sizeOfArray+1];
			
			//System.out.println("Enter the elements of the array ");
			for(int i=1;i<=sizeOfArray;i++)
				arr[i]=sc.nextInt();
			
			//taking the number of queries and the query elements
			//System.out.println("Enter the number of the queries ");
			noOfQueries=sc.nextInt();
			int queries[][]=new int[noOfQueries][2];
			
			//System.out.println("Enter the query each containing Li Ri ");
			for(int i=0;i<sizeOfArray;i++)
			{
				queries[i][0]=sc.nextInt();
				queries[i][1]=sc.nextInt();
			}
			
			//generating the cumulative XOR  array
			arr[0]=0;
			for(int i=1;i<=sizeOfArray;i++)
				arr[i]=arr[i-1]^arr[i];
			
			//calculating the XORs from Li to Xi index for every query[i]
			for(int i=0 ;i<noOfQueries;i++)
				System.out.print((arr[queries[i][0]] ^ arr[queries[i][1]+1])+" ");
			
			

		}

}
