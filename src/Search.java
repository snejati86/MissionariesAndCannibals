import java.util.ArrayList;
import java.util.Stack;


public interface Search<T> {
	
	public void SetGoal(T goalState) throws StateException;
	
	public Stack<State> GetPath();
	
	public void SetStart(T initState) throws StateException;
	
	public void BeginSearch() throws StateException;

}
