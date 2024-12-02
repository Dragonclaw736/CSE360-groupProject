package application;

enum DIFFICULTY {
BEG,
INTER,
ADV,
EXP
}


public class Topic {
	
	private String _name;
	private DIFFICULTY _diff;
	
	
	public String getName() {
		return _name;
	}
	public void setName(String newName) {
		_name = newName;
	}
	
	public DIFFICULTY getDifficulty() {
		return _diff;
	}
	public void setUser(DIFFICULTY newDifficulty) {
		_diff = newDifficulty;
	}
}