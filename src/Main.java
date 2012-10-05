public class Main {
	
	public static void main( String[] args)
	{
		
		Node initialStateNode= new Node(3,0,3,0,"Left",null);
		initialStateNode.expand(initialStateNode);
		initialStateNode.search();	
		
	}

}
