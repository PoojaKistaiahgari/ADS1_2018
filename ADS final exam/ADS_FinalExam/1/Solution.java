

import java.util.Scanner;

class Student
{
	int roll_number;
	String student_name;
	double total_mark;
	public Student(int roll_number, String student_name, double total_mark) {
		super();
		this.roll_number = roll_number;
		this.student_name = student_name;
		this.total_mark = total_mark;
	}
	@Override
	public String toString() {
		return "Student [roll_number=" + roll_number + ", student_name=" + student_name + ", total_mark=" + total_mark
				+ "]";
	}
	
}
class Hash
{
	public int get(int i)
	{
		int sum=0;
		Student[] s=new Student[20];
		for(int i1=1;i1<=i;i1++)
		{
		sum=sum+i1*(i1-1);
		}
		sum=sum%100;
		return sum;
	}
}
public class Solution {
	public static void main(String args[])
	{
		Student[] st=new Student[100];
		Hash my=new Hash();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int j=0;j<n;j++)
		{
			String s=sc.nextLine();
			String []a=s.split(",");	
			//System.out.println(a[0]);
			
			st[j]=new Student(Integer.parseInt(a[0]),a[1],Integer.parseInt(a[2]));
		}
		sc.nextLine();
		int n1=sc.nextInt();
		for(int i=0;i<n1;i++)
		{
			String s1=sc.nextLine();
			String []a1=s1.split(" ");
			//System.out.println(a1[0]);
			my.get(Integer.parseInt(a1[0]));
			System.out.println(" ");
		}
	}

}
