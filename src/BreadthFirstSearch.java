import java.util.ArrayList;
import java.util.Stack;


public class BreadthFirstSearch implements Search<State> {
	
	private State goal;
	private State init;
	private Stack<State> path;
	public boolean found;
	private int nodesExapnded;
	private long startTime;
	@Override
	public void SetGoal(State goalState) throws StateException {
		if (goalState==null){
			throw new StateException("Bad State");
		}
		goal = goalState;
	}
	
	private boolean isGoal(State node){
		return (node.compare(goal)==0);
	}
	
	public void printPath() throws StateException{
		if (path==null){
			throw new StateException("No Paths found");
		}
		System.out.println(" The search took :"+(System.nanoTime()-startTime));
		System.out.println(" Nodes expanded :"+nodesExapnded);
		System.out.println(" Number of moves: "+path.size());
		while (!path.isEmpty()){
			System.out.println(path.pop().toString());
		}
		
	}
	
	public void BeginSearch() throws StateException{
		startTime = System.nanoTime();
		Search(init);
	}
	
	private void Search(State node) throws StateException{
		if (!found){
		expandChildren(node);
		for (int i = 0 ; i < node.children.size();  ++i){
			Search(node.children.get(i));
			}
		}
	}
	
	private void expandChildren(State node) throws StateException{
		node.children = new ArrayList<State>();
		for ( int i = 0 ; i < 3 ; ++i){
			for ( int j = 0 ; i+j < 3 ; ++j){
				if (i+j==0){continue;}
				State temp = new State(node);
				temp.parent=node;
				temp.MoveCannibals(j, temp.Boat);
				temp.MoveMissionaries(i, temp.Boat);
				temp.MoveBoat();
				if (temp.Valid())
				{
					nodesExapnded++;
					node.children.add(temp);
					if (isGoal(temp))
					{
						found = GoalStateFound(temp);
						printPath();
						return ;
					}
				}
			
			}
		}
		
	}

	private boolean GoalStateFound(State temp) {
		path = new Stack<State>();
		while (temp!=null){
			path.add(temp);
			temp=temp.parent;
		}
		return true;
		
	}

	@Override
	public void SetStart(State initState) {
		// TODO Auto-generated method stub
		init = initState;
	}

	@Override
	public Stack<State> GetPath() {
		// TODO Auto-generated method stub
		return path;
	}

}
