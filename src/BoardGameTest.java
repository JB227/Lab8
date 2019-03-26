import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class BoardGameTest {
	
	BoardGame Game = new BoardGame();

	@Test
	public void addPlayerTest() {
		 Game.addPlayer("Jack", GamePiece.RED_RACER, Location.STUDY);
		 
		 Assert.assertEquals(false, Game.addPlayer("Jack", GamePiece.RED_RACER, Location.STUDY));
		 Assert.assertEquals(true, Game.addPlayer("Jack", GamePiece.YELLOW_BOOT, Location.STUDY));
	}
	@Test
	public void getPlayersAtLocationTest() {
		 Game.addPlayer("Jack", GamePiece.RED_RACER, Location.STUDY);
		 Game.addPlayer("Ryan", GamePiece.MAGENTA_RACER, Location.KITCHEN);
		 Game.addPlayer("Augusto", GamePiece.BLUE_BOOT, Location.STUDY);
		 
		 ArrayList<String> playersAtLoc = new ArrayList<String>();
		 playersAtLoc.add("Jack");
		 playersAtLoc.add("Augusto");
		 
		 Assert.assertEquals(playersAtLoc, Game.getPlayersAtLocation(Location.STUDY));
	}
	@Test
	public void getPlayerGamePieceTest() {
		 Game.addPlayer("Jack", GamePiece.RED_RACER, Location.STUDY);
		 
		 Assert.assertEquals(GamePiece.RED_RACER, Game.getPlayerGamePiece("Jack"));
	}
	@Test
	public void getPlayerWithGamePieceTest() {
		 Game.addPlayer("Jack", GamePiece.RED_RACER, Location.STUDY);
		
		 Assert.assertEquals("Jack", Game.getPlayerWithGamePiece(GamePiece.RED_RACER));
	}
	@Test
	public void getPlayersLocationTest() {
		 Game.addPlayer("Jack", GamePiece.RED_RACER, Location.STUDY);
		 
		 Assert.assertEquals(Location.STUDY, Game.getPlayersLocation("Jack"));
	}
	@Test
	public void movePlayerTest() {
		 Game.addPlayer("Jack", GamePiece.RED_RACER, Location.STUDY);
		 
		 Game.movePlayer("Jack", Location.DINING_ROOM);
		 
		 Assert.assertEquals(Location.DINING_ROOM, Game.getPlayersLocation("Jack"));
	}
	@Test
	public void moveTwoPlayersTest() {
		 Game.addPlayer("Ryan", GamePiece.MAGENTA_RACER, Location.KITCHEN);
		 Game.addPlayer("Augusto", GamePiece.BLUE_BOOT, Location.STUDY);
		 
		 String[] playersToMove = new String[2];
		 playersToMove[0] = "Augusto";
		 playersToMove[1] = "Ryan";
		 
		 Location[] locationsToGo = new Location[2];
		 locationsToGo[0] = Location.LOUNGE;
		 locationsToGo[1] = Location.LOUNGE;
		 
		 Game.moveTwoPlayers(playersToMove, locationsToGo);
		 
		 Assert.assertEquals(Location.LOUNGE, Game.getPlayersLocation("Ryan"));
		 Assert.assertEquals(Location.LOUNGE, Game.getPlayersLocation("Augusto"));
	}
	@Test
	public void getGamePiecesAtLocationTest() {
		 Game.addPlayer("Ryan", GamePiece.MAGENTA_RACER, Location.LOUNGE);
		 Game.addPlayer("Augusto", GamePiece.BLUE_BOOT, Location.LOUNGE);
		 
		 ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
		 pieces.add(GamePiece.MAGENTA_RACER);
		 pieces.add(GamePiece.BLUE_BOOT);
		 
		 Assert.assertEquals(pieces, Game.getGamePiecesAtLocation(Location.LOUNGE));
	}
}
