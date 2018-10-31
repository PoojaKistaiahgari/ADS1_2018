import java.util.*;
public class Solution
{ 
    public static void sort(int arr[],int l) 
    { 
        int n =l; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
  /* public static double findMedian(int a[], int l) 
    { 
        // First we sort the array 
       // Arrays.sort(a);
	   if(l==1)
	   {
		   
	  return a[0];
	   }
   
	 
	 //  sort(a,l);
  
        // check for even case 
	   else if (l!=1 && l% 2 != 0) 
	   {
        return (double)a[l/2]; 
	   }
	   else
        return (double)(a[(l- 1) / 2] + a[l / 2]) / 2.0; 
    }*/
  
    // Driver program 
    public static void main(String args[]) 
    {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		//for(int j=0;j<n;j++){
		//String ss=sc.next();
		//String st[]=ss.split(" ");
		int [] a=new int[n];
		int l=0;
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			l=i+1;
			//HeapSort ob = new HeapSort(); 
        sort(a,l); 
  
      //  System.out.println("Sorted array is"); 
       //for (int k=0; k<l; k++) 
           // System.out.print(a[k]+" "); 
      //  System.out.println(); 
        if(l==1)
 	   {
 		   
 	 System.out.println(a[0]);
 	   }
    
 	 
 	 //  sort(a,l);
   
         // check for even case 
 	   else if (l!=1 && l% 2 != 0) 
 	   {
         System.out.println( (double)a[l/2]); 
 	   }
 	   else
         System.out.println( (double)(a[(l- 1) / 2] + a[l / 2]) / 2.0); 
     
      //System.out.println("Median = " + findMedian(a, n));  
		}
		//System.out.println("Median = " + findMedian(a, n)); 
    
		}
        

} 