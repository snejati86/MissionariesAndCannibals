import java.util.ArrayList;


public class TreeNode {
	
	public State _state;
	public State _parent;
	public ArrayList<State> _children;
	
	public TreeNode(State state,State parent)
	{
		_state=state;
		_parent = parent;
		_children=null;
	}
	
	public void ExpandChildren(TreeNode node)
	{
		
	}
	
	private boolean ValidateState(State state)
	{
		return !(state.get_cannibalsAtLeft()>state.get_missionariesAtLeft() ||
				state.get_cannibalsAtLeft()<state.get_missionariesAtLeft()
				|| state.get_missionariesAtLeft()>3 || state.get_cannibalsAtLeft()>3
				|| 6-state.get_missionariesAtLeft()>3 || 6 - state.get_cannibalsAtLeft()>3)
				;
	}

}
