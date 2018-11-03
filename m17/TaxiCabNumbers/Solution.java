import java.util.Scanner;
class Solution { 
      
    public static void Taxicab(int n,int m) 
    { 
        // Starting from 1, check every number if 
        // it is Taxicab until count reaches N. 
        int i = 1, c= 0; 
        while (c< n)  
        { 
           int c1= 0; 
           	
           // Try all possible pairs (j, k) whose   
           // cube sums can be i. 
           for (int j = 1; j <= Math.pow(i, 1.0/3); j++)  
              for (int k = j + 1; k <= Math.pow(i, 1.0/3); 
                                                   k++)  
                  if (j * j * j + k * k * k == i) 
                      c1++; 
              
           // Taxicab(2) found 
           if (c1== m)  
           { 
              c++; 
             // System.out.println(i);   
           } 
       
           i++; 
        } 
        System.out.println(i-1);
    } 
      
    public static void main(String[] args)  
    { 
        Scanner s=new Scanner(System.in);
        String s1=s.nextLine();
        String []s2=s1.split(" ");
        
        Taxicab(Integer.parseInt(s2[0]),Integer.parseInt(s2[1])); 
        
          
    } 
}