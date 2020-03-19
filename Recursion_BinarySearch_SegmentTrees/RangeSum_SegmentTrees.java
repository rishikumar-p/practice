/*
 * Creation ,Updation and Finding RangeSum using SEGMENT TREE DataStructure
 *  
 */
public class rangeSum {
	static void buildSegmentTree(int[] array,int[] tree,int start,int end,int treeNode)
	{
		
		if(start==end)
		{
			tree[treeNode]=array[start];
			return;
		}
		int mid=(start+end)/2;
		buildSegmentTree(array,tree,start,mid,2*treeNode);
		buildSegmentTree(array,tree,mid+1,end,2*treeNode+1);
		tree[treeNode]=tree[2*treeNode]+tree[2*treeNode+1];
	}
	static void updateSegmentTree(int array[],int[] tree,int start,int end,int treeNode,int val,int index)
	{
		
		int temp=0;
		if(start==end)
		{
			if(start==index)
			{
			temp=tree[treeNode];
			tree[treeNode]=val;
			array[index]=val;
			}
			return;
		}
		int mid=(start+end)/2;
		if(index>=start&&index<=mid)
			updateSegmentTree(array,tree,start,mid,2*treeNode,val,index);
		if(index>=mid&&index<=end)
			updateSegmentTree(array,tree,mid+1,end,2*treeNode+1,val,index);
		tree[treeNode]=tree[2*treeNode]+tree[2*treeNode+1];
		
	}
	static void print(int []tree)
	{
		int l=tree.length;
		for(int i=1;i<l;i++)
			System.out.print(tree[i]+" ");
		System.out.println();
		return;
	}
	static int  queryRangeSum(int []tree,int segStart,int segEnd,int qLeft,int qRight,int treeNode)
	{
		if(segEnd<qLeft||segStart>qRight)
			return 0;
		if(segStart>=qLeft&&segEnd<=qRight)
			return tree[treeNode];
		int mid=(segStart+segEnd)/2;
		return queryRangeSum(tree, segStart, mid, qLeft, qRight,2*treeNode)+queryRangeSum(tree, mid+1,segEnd, qLeft, qRight,2*treeNode+1);
		
	}
	
	
	
	public static void main(String[] args) {
		int array[]= {1,2,3,4,5,6,7,8,9,10,11};
		int arraylenth=array.length;
		int l=4*arraylenth;
		int tree[]=new int[l];
		buildSegmentTree(array,tree,0,arraylenth-1,1);
		System.out.print("Array : ");
		print(array);
		System.out.print("Segment tree : ");
		print(tree);
		int qLeft,qRight;
		qLeft=2;
		qRight=7;
		
		System.out.println("Before Updating the array");
		int querySum=queryRangeSum(tree,0,arraylenth-1,qLeft,qRight,1);
		System.out.println("Sum of array elements from "+ qLeft +" to "+ qRight+" is: "+querySum);
		
		updateSegmentTree(array, tree,0,arraylenth-1,1,10,2);
		
		System.out.println("After Updating the array");
		 querySum=queryRangeSum(tree,0,arraylenth-1,qLeft,qRight,1);
		System.out.print("Sum of array elements from "+ qLeft +" to "+ qRight+" is: "+querySum);
		
		System.out.println();
		System.out.print("Array : ");
		print(array);
		System.out.print("Segment tree : ");
		print(tree);
		
	}

}
