package Game;
public class PlayerInfo
{
	private String PlayerName;
	private int CurrentLevel;
	private int Score;
	public PlayerInfo() 
	{
	}
	public PlayerInfo(PlayerInfo p) 
	{
		this.PlayerName=p.getPlayerName();
		this.CurrentLevel=p.getCurrentLevel();
		this.Score=p.getScore();
	}
	public String getPlayerName() {
		return PlayerName;
	}
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	public int getCurrentLevel() {
		return CurrentLevel;
	}
	public void setCurrentLevel(int currentLevel) {
		CurrentLevel = currentLevel;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}

}//end of class PlayeraIfno
