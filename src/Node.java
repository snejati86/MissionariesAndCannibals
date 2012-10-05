
import java.util.Stack;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
// We import these functions to use later.
public class Node {
	int lm;
	int rm;
	int lc;
	int rc;
	String boat;
	long time; //This is for calculating the time it took for the program to complete. We read system time for that.
	Node parent;
	Vector <Node> expanded=new Vector<Node>();
	
//Creating the Node class , A node is an state in missionaries and cannibals problem	
	public Node()
	{}
public Node(int leftM, int leftC,int rightM,int rightC, String boat, Node parent){  
	time=System.currentTimeMillis();
	this.lm=leftM;
	this.rm=leftC;
	this.lc=rightM;
	this.rc=rightC;
	this.boat=boat;
	this.parent=parent;}
//Constructor
public String validate (Node node){
	if (node.rm==3 && node.rc==3)	
	{
		//Checking for goal state
		String output;
		output="";
		
		output=findpath(node,output);
		time=(System.currentTimeMillis()-time);
		output=output+"\n "+time+" miliseconds to do that";
		//JFrame and JOption are for printing out the outputs to a window.
		JFrame farame=new JFrame();
		JOptionPane.showMessageDialog(farame, output);
		System.exit(0);
		return "Goal";}
	else if (
			node.lm<0 || node.lm>3 || node.lc<0 || node.lc>3 ||
			node.rm<0 || node.rm>3 || node.rc<0 || node.rc>3 ||
			(node.lc>node.lm && node.lm>0)	||
			(node.rc>node.rm && node.rm>0)  || (check(node,expanded))//Checking for repeated states
			)
	//Checking for in valid state
	{
		return "Invalid";}
	else {
		
	return "Valid";} 
}

public boolean check (Node node1,Vector <Node> ArrayList0)
{	for (int i=0;i<ArrayList0.size();i++)
	{
		if (
		(node1.lm==ArrayList0.elementAt(i).lm) &
		 (node1.rm==ArrayList0.elementAt(i).rm) &
		 (node1.lc==ArrayList0.elementAt(i).lc) &
		 (node1.rc==ArrayList0.elementAt(i).rc)&
		 (node1.boat==ArrayList0.elementAt(i).boat) )
		{
			return true;
		}
		
	}//Check for a node. We use this for checking repeated states.
return false;
	
}
	
public void expand (Node node)
{
	
		Node candid=new Node();
	
		int i=0;
		int j=0;
	for (i=0;i<=2;i++) 
			for (j=0;i+j<=2;j++) //These two create states with moving at most 2 cannibal or/and missioanries
			{
				if (i+j==0){ // Someone has to row!
					continue;}
			if(node.boat=="Left")
				{
					candid = new Node(node.lm-i,node.rm+i,node.lc-j,node.rc+j,candid.boat="Right",candid.parent=node);
					if(validate(candid).equals("Valid"))
					{
						expanded.add(candid); //Add node to expanded vector.
						continue;
					}
			
				}
				if(node.boat=="Right")
				{
						candid = new Node(node.lm+i,node.rm-i,node.lc+j,node.rc-j,candid.boat="Left",candid.parent=node);
						if(validate(candid).equals("Valid"))
						{
							
						expanded.add(candid);
						}
				}
			}

	
	}
	
public void search()
{
	//Recursivly call expand on the nodes we stored in array.
	for(int i=0;i<expanded.size();i++)
	{
		expand(expanded.elementAt(i));		
	}
	
	search();
	}

public String findpath (Node node,String output)
{
	
	int x=0;
	Stack<Node> path = new Stack<Node>();
//We define an FILO stack to print out the path nodes in correct order.
	
	while (node.parent!=null)
	{
		
		path.push(node);
		node=node.parent;
		x++;	
	}
	path.push(node); //Pushing the initial node because it's not in the expanded vector.
	while (!path.empty())
	{
		node=path.pop();
		output=output+"\n cannibals:"+node.lc+" "+"missionaries:"+node.lm+"|~~~~|"+" "+"cannibals:"+node.rc+" "+"missionaries:"+node.rm+" "+"   Boat position: "+node.boat+" ";
		//We save outputs for printing into a window.
	}	
	output=output+"\n "+x+" Moves were required";
	return output;
}
	
}
	




