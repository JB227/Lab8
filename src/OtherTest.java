import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class OtherTest {
	
	BoardGame Game = new BoardGame();

	@Test
	public void getPlayersTest() {
		Game.addPlayer("Skylar", GamePiece.RED_RACER, Location.BALLROOM);
		Game.addPlayer("Jaycie", GamePiece.BLUE_BOOT, Location.BILLIARD_ROOM);
		Game.addPlayer("Hannah", GamePiece.GREEN_BOOT, Location.CONSERVATORY);
		
		Set<String> players = new HashSet<String>();
		players.add("Skylar");
		players.add("Jaycie");
		players.add("Hannah");
			
		Assert.assertEquals("Incorrect players in game", players, Game.getPlayers());
	}
	@Test
	public void getLocationsTest() {
		Game.addPlayer("Skylar", GamePiece.RED_RACER, Location.BALLROOM);
		Game.addPlayer("Jaycie", GamePiece.BLUE_BOOT, Location.BILLIARD_ROOM);
		Game.addPlayer("Hannah", GamePiece.GREEN_BOOT, Location.CONSERVATORY);
		
		Set<Location> locs = new HashSet<Location>();
		locs.add(Location.BALLROOM);
		locs.add(Location.BILLIARD_ROOM);
		locs.add(Location.CONSERVATORY);
			
		Assert.assertEquals("Incorrect locations", locs, Game.getPlayerLocations());
	}
	@Test
	public void getPiecesTest() {
		Game.addPlayer("Skylar", GamePiece.RED_RACER, Location.BALLROOM);
		Game.addPlayer("Jaycie", GamePiece.BLUE_BOOT, Location.BILLIARD_ROOM);
		Game.addPlayer("Hannah", GamePiece.GREEN_BOOT, Location.CONSERVATORY);
		
		Set<GamePiece> pieces = new HashSet<GamePiece>();
		pieces.add(GamePiece.RED_RACER);
		pieces.add(GamePiece.BLUE_BOOT);
		pieces.add(GamePiece.GREEN_BOOT);
		
		Assert.assertEquals("incorrect pieces", pieces, Game.getPlayerPieces());
	}
	@Test
	public void colorGetterTest() {
		Assert.assertEquals(255, Color.RED.getR());
		Assert.assertEquals(255, Color.GREEN.getG());
		Assert.assertEquals(255, Color.BLUE.getB());
	}
	@Test
	public void toStringTest() {
		Assert.assertEquals("RED_RACER: a RED RACECAR with priority 0", GamePiece.RED_RACER.toString());
	}

}
