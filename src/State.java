import java.util.ArrayList;
import java.util.Comparator;


public class State  {
	
	public int MissionariesAtLeft;
	public int CannibalsAtLeft;
	public int MissionariesAtRight;
	public int CannibalsAtRight;
	public BoatPlacement Boat;
	public State parent;
	public ArrayList<State> children;
	
	public State(int misL,int canL,int misR,int canR,BoatPlacement boat){
		MissionariesAtLeft = misL;
		MissionariesAtRight = misR;
		CannibalsAtLeft = canL;
		CannibalsAtRight = canR;
		Boat = boat;
	}
	/* Copy constructor */
	public State(State clone){
		this.MissionariesAtLeft=clone.MissionariesAtLeft;
		this.MissionariesAtRight=clone.MissionariesAtRight;
		this.CannibalsAtLeft=clone.CannibalsAtLeft;
		this.CannibalsAtRight=clone.CannibalsAtRight;
		this.Boat=clone.Boat;
	}
	
	
	public boolean Valid(){
		return (noMinus()&&notOver()&&noLoops()&&isValid());
	}
	
	private boolean isValid(){
		boolean leftSide = true;
		boolean rightSide = true;
		if (this.MissionariesAtLeft>0)
			leftSide = this.MissionariesAtLeft-this.CannibalsAtLeft>=0;
		if (this.MissionariesAtRight>0)
			rightSide = this.MissionariesAtRight-this.CannibalsAtRight>=0;
			return leftSide && rightSide;
	}
	
	private boolean noMinus(){
		return (this.MissionariesAtLeft>=0 && this.MissionariesAtRight>=0 && 
				this.CannibalsAtLeft>=0 && this.CannibalsAtRight>=0);
	}
	
	private boolean notOver(){
		return (this.MissionariesAtLeft<4 && this.MissionariesAtRight<4 && 
				this.CannibalsAtLeft<4 && this.CannibalsAtRight<4);
	}
	
	private boolean noLoops(){
		return !((this.compare( this.parent.parent)==0));
	}
	
	
	
	public void MoveBoat(State node){
		if (node.Boat==BoatPlacement.left)
		{
			node.Boat=BoatPlacement.right;
		}
		else
			node.Boat=BoatPlacement.left;
	}
	

	private void PrintPath(State node) {
		while (node.parent!=null)
		{
			System.out.println(node.CannibalsAtLeft+","+node.MissionariesAtLeft+","+node.Boat.toString());
			node=node.parent;
		}
		System.out.println(node.CannibalsAtLeft+","+node.MissionariesAtLeft+","+node.Boat.toString());
		System.out.println("------------------");
		
	}
	
	public void MoveCannibals(int number,BoatPlacement direction){
		if (direction==BoatPlacement.left){
			this.CannibalsAtLeft-=number;
			this.CannibalsAtRight+=number;
		}
		else{
			this.CannibalsAtLeft+=number;
			this.CannibalsAtRight-=number;
		}
	}
	
	public void MoveMissionaries(int number,BoatPlacement direction){
		if (direction==BoatPlacement.left){
			this.MissionariesAtLeft-=number;
			this.MissionariesAtRight+=number;
		}
		else{
			this.MissionariesAtLeft+=number;
			this.MissionariesAtRight-=number;
		}	
	}
	
	public void MoveBoat(){
		if (this.Boat==BoatPlacement.left){
			this.Boat=BoatPlacement.right;
		}
		else{
			this.Boat=BoatPlacement.left;
		}
	}
	
	public String toString()
	{
		if (this.Boat==BoatPlacement.left)
		return " Missionaries :"+this.MissionariesAtLeft+" "+"Cannibals :"+this.CannibalsAtLeft+" \\__/ "
				+" |||||| "+" Missionaries :"+this.MissionariesAtRight+" "+"Cannibals :"+this.CannibalsAtRight;
		else
			return " Missionaries :"+this.MissionariesAtLeft+" "+"Cannibals :"+this.CannibalsAtLeft
			+" |||||| "+" Missionaries :"+this.MissionariesAtRight+" "+"Cannibals :"+this.CannibalsAtRight+" \\__/ ";
	}

	public int compare(State o2) 
	{
		// TODO Auto-generated method stub
		if (this==null || o2==null)
		{
			return -1;
		}
		return equal(this,o2) ? 0 : -1;
	}
	
	private boolean equal(State o1,State o2)
	{
		return ((o1.CannibalsAtLeft==o2.CannibalsAtLeft
				&& o1.CannibalsAtRight==o2.CannibalsAtRight
				&& o1.MissionariesAtLeft==o2.MissionariesAtLeft
				&& o1.MissionariesAtRight==o2.MissionariesAtRight
				&& o1.Boat==o2.Boat));
	}
	 
}
