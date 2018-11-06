import java.util.*;
import java.io.*;
class Team
{
	String tm;
	int wins,losses,draws;
	public Team(String t,int w,int l,int d)
	{
		this.tm=t;
		this.wins=w;
		this.losses=l;
		this.draws=d;
	}
}
class Solution
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<Team> al=new ArrayList<Team>();
		while(sc.hasNext())
		{
			String a=sc.nextLine();
			String []b=a.split(",");
			Team t=new Team(b[0],Integer.parseInt(b[1]),Integer.parseInt(b[2]),Integer.parseInt(b[3]));
			al.add(t);
		}

			   for (int i = 0; i < al.size()-1; i++)
			   {
			      int min = i;
			      for (int j = i+1; j < al.size(); j++)
			    	  if (compare(al.get(j),al.get(min))) min = j;
			      Team temp = al.get(i);
			      al.set(i, al.get(min));
			      al.set(min, temp);
			      }
			   Iterator itr1=al.iterator();
			   while(itr1.hasNext())
			   {
				   Team t=(Team) itr1.next();
				   System.out.print(t.tm+",");
			   }
			   
	}
	 public static boolean  compare(Object a,Object b)
	   {
		 Team t1=(Team)a;
		 Team t2=(Team)b;
		   if(t1.wins==t2.wins)
		   {
			   if(t1.losses==t2.losses)
			   {
				   if(t1.draws>t2.draws)
				   {
					   return true;
				   }
				   else 
					   return false;
				   
			   }
			   else if(t1.losses<t2.losses)
			   {
				   return true;
			   }
			   else
				   return false;
		   }
		    if(t1.wins>t2.wins)
		   {
			   return true;
		   }
		   else
			   return false;
	   }
}