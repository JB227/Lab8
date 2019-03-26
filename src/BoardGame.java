import java.util.*;

public class BoardGame {
	
	protected LinkedHashMap<String, GamePiece> playerPieces;
	protected LinkedHashMap<String, Location> playerLocations;
	
	public BoardGame() {
		playerPieces = new LinkedHashMap<String, GamePiece>();
		playerLocations = new LinkedHashMap<String, Location>();
	}
	
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation) {
		for(String player: playerPieces.keySet()) {
			if(playerPieces.get(player).equals(gamePiece)) {
				return false;
			}
		}
		playerPieces.put(playerName, gamePiece);
		playerLocations.put(playerName, initialLocation);
		return true;
	}
	
	public GamePiece getPlayerGamePiece(String playerName) {
		return playerPieces.get(playerName);
	}
	
	public String getPlayerWithGamePiece(GamePiece gamePiece) {
		String playerPiece = null;
		for(String player: playerPieces.keySet()) {
			if(playerPieces.get(player).equals(gamePiece)) {
				playerPiece = player;
			}
		}
		return playerPiece;
	}
	
	public void movePlayer(String playerName, Location newLocation) {
		playerLocations.replace(playerName, newLocation);
	}
	
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations) {
		String[] priorities = new String[2];
		
		GamePiece priorityPiece = GamePiece.movesFirst(playerPieces.get(playerNames[0]), playerPieces.get(playerNames[1]));
		
		if(getPlayerWithGamePiece(priorityPiece).equals(playerNames[0])) {
			playerLocations.replace(playerNames[0], newLocations[0]);
			playerLocations.replace(playerNames[1], newLocations[1]);
			priorities[0] = playerNames[0];
			priorities[1] = playerNames[1];
		}
		else {
			playerLocations.replace(playerNames[1], newLocations[1]);
			playerLocations.replace(playerNames[0], newLocations[0]);
			priorities[1] = playerNames[1];
			priorities[0] = playerNames[0];
		}
		return priorities;
	}
	
	public Location getPlayersLocation(String player) {
		return playerLocations.get(player);
	}
	
	public ArrayList<String> getPlayersAtLocation(Location loc){
		ArrayList<String> players = new ArrayList<String>();
		for(String player: playerPieces.keySet()) {
			if(getPlayersLocation(player) == loc) {
				players.add(player);
			}
		}
		return players;
	}
	
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc){
		ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
		for(String gamer: getPlayersAtLocation(loc)) {
			pieces.add(playerPieces.get(gamer));
		}
		return pieces;
	}
	
	public Set<String> getPlayers(){
		Set<String> players = new HashSet<>();
		for(String player: playerPieces.keySet()) {
			players.add(player);
		}
		return players;
	}
	
	public Set<Location> getPlayerLocations(){
		Set<String> players = getPlayers();
		Set<Location> locs = new HashSet<>();
		for(String player: players) {
			locs.add(playerLocations.get(player));
		}
		return locs;
	}
	
	public Set<GamePiece> getPlayerPieces(){
		Set<String> players = getPlayers();
		Set<GamePiece> pieces= new HashSet<>();
		for(String player: players) {
			pieces.add(playerPieces.get(player));
		}
		return pieces;
	}
}
