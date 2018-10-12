
import java.util.Scanner;

class Node
{
	int data;
	Node Next;
	Node(int data)
	{
		this.data=data;
	}
}
class LList
{
	Node head;
	public void pushFront(int data)
	{
		Node n=new Node(data);
		
		if(head==null)
		{
			head=n;
		}
		else
		{	
			n.Next=head;
		    head=n;
		}
		
	}
	public int popFront()
	{
		int x;
		if(head==null)
		{
			//System.out.println("stequeue is empty");
			return -1;
		}
		else
		{
			Node temp=head;
			head =head.Next;
			return temp.data;
			}
	}
	public void pushEnd(int a)
	{
		Node n=new Node(a);
	
		if(head==null)
		{
			head=n;
			
		}
		else
		{	
			Node temp =head;
		    while(temp.Next!=null)
		{
			temp=temp.Next;
		}
		
		temp.Next=n;
		
		}
		
	}
	public void display() {
		Node temp=head;
		if(head==null)
		{
			System.out.println("steque is empty.");
		}
		else
		{
			while(temp!=null)
			{
				System.out.print(temp.data);
				temp=temp.Next;
				if(temp!=null)
				System.out.print(",");
			}
			System.out.println();
		}
	}
}
public class Solution {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s1[]=new String[2];
		String s=null;
		int i;
		for(i=0;i<=n;i++)
		{
		LList l=new LList();
		do
		{
			s=sc.nextLine();
			s1=s.split(" ");
			switch(s1[0])
			{
			case "push":
				l.pushFront(Integer.parseInt(s1[1]));
				l.display();
				break;
			case "enqueue":
				l.pushEnd(Integer.parseInt(s1[1]));
				l.display();
				break;
			case "pop":
				l.popFront();
			    l.display();
			    break;
			}
	}while(sc.hasNext() && s.length()!=0);
		if(i!=0)
		{
		System.out.println();
		}
		}
}
}
