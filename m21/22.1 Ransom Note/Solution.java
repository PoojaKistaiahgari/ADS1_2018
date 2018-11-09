package m21;

import java.util.Hashtable;
import java.util.Scanner;
class Hash1 {
int n;

	public Hash1(int n) {
	
	this.n = n;
}

	public int hashfunc(String s)
	{
		int nn = 1000;
		int sum=0;
		for(int i = 0;i<s.length();i++)
		{
			sum=sum+(s.charAt(i))*i;
		}
		sum=sum%n;
		return sum;
	}
}

public class Solution {
public static void main(String args[])
{
	Scanner s=new Scanner(System.in);
	int n1=s.nextInt();
	int n2=s.nextInt();
	String s3[]=new String[(n1)*5];
	int no[]=new int[n1];
	
	Hash1 h=new Hash1(n1*5);
	for(int i = 0;i<n1;i++)
	{
	String s4=s.next();
		s3[h.hashfunc(s4)]=s4;
		no[i]=h.hashfunc(s4);
	}
	int count=0;int c1;
	for(int i = 0;i<n2;i++)
	{String s4=s.next();
		int n=h.hashfunc(s4);c1=0;
		for(int j = 0;j<n1;j++)
		{
			if(n==no[j])
			{
				c1++;
				break;
			}
		}
		if(c1==0)
		{
			break;
		}
		else
		{
		if(s3[n].equals(s4))
		{
			s3[n]=s3[n]+"...";
			count++;
			
		}
		
	}
	}
	if(count==n2)
	{
		System.out.println("Yes");
	}
	else
	{
		System.out.println("No");
	}

}
}

