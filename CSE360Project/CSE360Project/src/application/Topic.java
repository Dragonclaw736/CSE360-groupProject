package application;

/**
 * The DIFFICULTY enum represents the difficulty levels associated with a topic
 * It includes four levels: BEG (Beginner), INTER (Intermediate), ADV (Advanced), and EXP (Expert)
 */
enum DIFFICULTY {
    BEG,    // Beginner level
    INTER,  // Intermediate level
    ADV,    // Advanced level
    EXP     // Expert level
}

/**
 * The Topic class represents a topic with a name and difficulty level.
 * It provides getter and setter methods to manipulate the name and difficulty of the topic
 */
public class Topic {
	
	// Private field for storing the name of the topic
	private String _name;
	
	// Private field for storing the difficulty level of the topic
	private DIFFICULTY _diff;
	
	/**
	 * Retrieves the name of the topic.
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Sets the name of the topic.
	 */
	public void setName(String newName) {
		_name = newName;
	}
	
	/**
	 * Retrieves the difficulty level of the topic.
	 */
	public DIFFICULTY getDifficulty() {
		return _diff;
	}

	/**
	 * Sets the difficulty level of the topic.
	 */
	public void setUser(DIFFICULTY newDifficulty) {
		_diff = newDifficulty;
	}
}
