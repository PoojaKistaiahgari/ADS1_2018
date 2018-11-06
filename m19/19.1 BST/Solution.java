
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Book
{
	String Name;
	String Author;
	double Price;
	Book(String Name,String Author,double Price)
		{
		this.Name=Name;
		this.Author=Author;
		this.Price=Price;
		}
	@Override
	public String toString() {
		return Name+","+" "+Author+","+" "+Price;
	}
	
}
class Node
{
	public Book key;
	public int value;
	Node left;
	public Node right;
	public Node(Book key,int value)
	{
		this.key=key;
		this.value=value;
	}
}
public class Solution {
	Node root;
	public void put(Book key,int val)
	{
		root=put(root,key,val);
	}
	public Node put(Node node,Book Key,int val)
	{
		if(node==null)
			return new Node(Key,val);
		if(Key.Name.compareTo(node.key.Name)<0)
			node.left=put(node.left,Key,val);
		if(Key.Name.compareTo(node.key.Name)>0)
			node.right=put(node.right,Key,val);
		if(Key.Name.compareTo(node.key.Name)==0)
			node.value=val;
		//root.
		return node;
		
	}
	public int get(Book Key)
	{
		Node node=root;
		while(node!=null)
		{
			if(Key.Name.compareTo(node.key.Name)<0)
				node=node.left;
			else if(Key.Name.compareTo(node.key.Name)>0)
				node=node.right;
			else
				return node.value;
			
		}
		return 0;
	}
	public Book min()
	{
		
	    return min(root).key;
	}
	private Node min(Node current) { 
	    if (current.left == null) return current; 
	    else
	    	return min(current.left); 
	}
	public Book max() {
	    
	    return max(root).key;
	} 
	
	private Node max(Node current) {
	    if (current.right == null) return current; 
	    else                       
	    	return max(current.right); 
	}
	public  Book floor(Book key)
	{
		Node x = floor(root, key);
	    if (x == null) return null;   // if empty, return null
	    else           return x.key;
	}
	private Node floor(Node current, Book key) {
	    if (current == null) return null;
	    if(key.Name.compareTo(current.key.Name)==0)
	    	return current;
	    if(key.Name.compareTo(current.key.Name)<0)
	    	return floor(current.left,key);
	    
	    
	    Node t = floor(current.right, key); 
	    if (t != null) return t;
	    else           return current;
	}
	public Book ceiling(Book key) {
	  
	    Node x = ceiling(root, key);
	    if (x == null) return null;   // if empty, return null
	    else return x.key;
	}
	
	private Node ceiling(Node current, Book key) {
	    if (current == null) return null;
	    if(key.Name.compareTo(current.key.Name)==0)
	    {
	    	//System.out.println("*****");
	    	return current;}
	    if(key.Name.compareTo(current.key.Name)<0)
	    {
	    	Node t = ceiling(current.left, key); 
			    if (t != null) return t;
			    else           
			    	return current;
	    }
	    return ceiling(current.right,key);
	}
	void select(int k)
	{
	ArrayList<Book> al=new ArrayList<Book>();
		select(root,al);
		for(int i=0;i<al.size()&&i<=k;i++)
			if(i==k)
				System.out.println(al.get(i));
		//System.out.println(j);
		
	}
	
	
	void select(Node a,ArrayList al)
	{
		if(a!=null)
		{
			select(a.left,al);
			al.add(a.key);
			select(a.right,al);
		}
		
		
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Solution sol=new Solution();	
		while(sc.hasNext())
		{
			String s = sc.nextLine();
			String [] array = s.split(",");
			String O = array[0];
			switch (O)
			{
			case "put" :Book book = new Book(array[1],array[2],Double.parseDouble(array[3]));
							sol.put(book,Integer.parseInt(array[4]));
						break;
			case "get" :Book b1 = new Book(array[1],array[2],Double.parseDouble(array[3]));
							if(sol.get(b1)!=0)
							System.out.println(sol.get(b1));
						else
							System.out.println("null");
						break;
			case "min":System.out.println(sol.min());
						break;
			case "max":System.out.println(sol.max());
						break;
			case "floor":Book book1 = new Book(array[1],array[2],Double.parseDouble(array[3]));
							System.out.println(sol.floor(book1));
						break;
			case "ceiling":Book b11 = new Book(array[1],array[2],Double.parseDouble(array[3]));
			System.out.println(sol.ceiling(b11));
						break;
			case "select":sol.select(Integer.parseInt(array[1]));
						break;
			}
		}
	}

}

