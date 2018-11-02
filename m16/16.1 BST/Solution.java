
import java.util.Scanner;
class Book
{
	String bookn;
	String authorn;
	float p;
	Book(String bookn,String authorn,float p)
	{
		this.bookn=bookn;
		this.authorn=authorn;
		this.p=p;
	}
	@Override
	public String toString() {
		return "Book [Name=" + bookn + ", Author=" + authorn + ", Price=" + p + "]";
	}
}

class Node
{
	public Book key;
	public int val;
	public Node left,right;//root
	Node(Book key,int val)
	{
		this.key=key;
		this.val=val;
	}
}
class BS
{
	Node root;

int get(Book key)
{
	Node x=root;
	while(x!=null)
	{
		//int cmp=compare(key,x.key);
		if(key.bookn.compareTo(x.key.bookn)<0)
		{
			x=x.left;
		}
		else if(key.bookn.compareTo(x.key.bookn)>0)
		{
			x=x.right;
		}
		else
		return x.val;
	}
	return 0;
}
void put(Book key,int val)
{
	root=put(root,key,val);
}
public Node put(Node x,Book key,int val)
{
	if(x==null)
	return new Node(key,val);
		//int cmp=compare(key,x.key);
		if(key.bookn.compareTo(x.key.bookn)<0)
		{
			x.left=put(x.left,key,val);
		}
		else if(key.bookn.compareTo(x.key.bookn)>0)
		{
			x.right=put(x.right,key,val);
		}
		else if(key.bookn.compareTo(x.key.bookn)==0)
		{
			x.val=val;
		}
		return x;
	}
	
public void disp(Node temp)
{
	if(temp!=null)
	{
		disp(temp.left);
		System.out.println(temp.key+""+temp.val);
		disp(temp.right);
	}
}

/*public int compare(Book key1,Book key2) {
	// TODO Auto-generated method stub
	if(key1.authorn.compareTo(key2.authorn)>0)
	{
		return 1;
	}
	else if(key1.authorn.compareTo(key2.authorn)<0)
	return -1;
	else 
		return 0;
}*/

}
public class Solution {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		BS b=new BS();
		while(sc.hasNext())
		{
			String s=sc.nextLine();
		    String s1[]=s.split(",");
		    String O=s1[0];
		    Book book=new Book(s1[1],s1[2],Float.parseFloat(s1[3]));
		    switch(O)
		    {
		    case "put": 
		    	//BS b=new BS();
		    	b.put(book,Integer.parseInt(s1[4]));
		    	
		    	break;
		    case "get":
		    	if(b.get(book)!=0)
		    		System.out.println(b.get(book));
		    	else
		    		System.out.println("null");
		    	break;
		    
		    }
		}
	}

}
