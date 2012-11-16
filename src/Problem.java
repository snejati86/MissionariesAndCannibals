
public class Problem {

	public static void main (String[] args) throws CloneNotSupportedException, StateException
	{
		State init = new State(3,3,0,0,BoatPlacement.left);
		State goal = new State(0,3,3,0,BoatPlacement.right);
		Search BS = new BreadthFirstSearch();
		BS.SetStart(init);
		BS.SetGoal(goal);
		BS.BeginSearch();
	}
}
