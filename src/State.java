
public class State {

	private int _missionariesAtLeft;
	private int _cannibalsAtLeft;
	private int _missionariesAtRight;
	private int _cannibalsAtRight;
	public BoatPlacement _boat;
	
	public State(int canLeft,int missLeft,BoatPlacement boat)
	{
		set_missionariesAtLeft(missLeft);
		set_cannibalsAtLeft(canLeft);
		_boat = boat;
	}

	public int get_missionariesAtLeft() {
		return _missionariesAtLeft;
	}

	public void set_missionariesAtLeft(int _missionariesAtLeft) {
		this._missionariesAtLeft = _missionariesAtLeft;
		this._missionariesAtRight = 6 - this._missionariesAtLeft;
	}

	public int get_cannibalsAtLeft() {
		return _cannibalsAtLeft;
	}

	public void set_cannibalsAtLeft(int _cannibalsAtLeft) {
		this._cannibalsAtLeft = _cannibalsAtLeft;
		this._cannibalsAtRight = 6 - this._cannibalsAtLeft;
	}

}
