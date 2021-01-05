package pig.gui;
/*
/**
 * @author kshitija
 *
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import pig.model.Die;
import pig.model.Game;
import pig.model.Player;

class PigTest {

	@Test
	void testPart1() {
		Die d1 = new Die(6, 1);

		assertEquals(6, d1.getSides());
		assertEquals(1, d1.getTop());
	}

	@Test
	public void testPart2() {
		Die d1 = new Die(6, 1);
		Die d2 = new Die(6, 1);

		assertEquals(d1.getSides(), d2.getSides());
		assertEquals(d1.getTop(), d2.getTop());
		d1.roll();
		d2.roll();
		assertEquals(d1.getSides(), d2.getSides());
	}

	@Test
	public void testPart3() {
		Player p1 = new Player("Mark");
		Player p2 = new Player("Molly");

		assertEquals("Mark", p1.getName());
		assertEquals("Molly", p2.getName());

	}

	@Test
	public void testPart4() {
		Game pig = new Game("Kevin", "Raymond");

		assertEquals("Kevin", pig.getPlayer1().getName());
		assertEquals("Raymond", pig.getPlayer2().getName());

	}

	@Test
	public void testPart5() {
		Game pig = new Game("Kevin", "Raymond");
		assertEquals(0, pig.getPlayer1().getTotalScore());
		assertEquals(0, pig.getPlayer2().getTotalScore());
	}

	@Test
	public void testPart6() {
		Game pig = new Game("Kevin", "Raymond");

		assertEquals(0, pig.getPlayer1().getTurnScore());
		assertEquals(0, pig.getPlayer2().getTurnScore());

	}

	@Test
	public void testPart7() {
		Game pig = new Game("Kevin", "Raymond");

		assertEquals(6, pig.getDie1().getSides());
		assertEquals(6, pig.getDie2().getSides());
	}

	@Test
	public void testPart8() {
		Game pig = new Game("Kevin", "Raymond");

		assertEquals(0, pig.getDie1().getTop());
		assertEquals(0, pig.getDie2().getTop());
	}

	@Test
	public void testPart9() {
		PigData.pig = new Game("Kevin", "Raymond");
		assertTrue(PigData.pig.isP1Turn());
		PigData.pig.switchTurnOfPlayers();
		assertFalse(PigData.pig.isP1Turn());

	}

	@Test
	public void testPart10() {
		PigData.pig = new Game("Kevin", "Raymond");

		PigData.pig.rollDie();
		if (PigData.pig.getDie1().getTop() != 1 || PigData.pig.getDie2().getTop() != 1) {
			assertTrue(PigData.pig.isP1Turn());
		} else {
			assertFalse(PigData.pig.isP1Turn());
		}
	}

	@Test
	public void testPart11() {
		Game pig = new Game("Kevin", "Raymond");

		assertFalse(pig.gameOver());
	}

	@Test
	public void testPart12() {
		Game pig = new Game("Kevin", "Raymond");

		pig.setTargetScore(50);
		assertEquals(50, pig.getTargetScore());
	}

	@Test
	public void testPart13() {
		Game pig = new Game("Kevin", "Raymond");

		pig.setTargetScore(100);
		assertEquals(100, pig.getTargetScore());
	}

	@Test
	public void testPart14() {
		Game pig = new Game("Kevin", "Raymond");
		assertTrue(pig.isP1Turn());
		pig.switchTurnOfPlayers();
		assertFalse(pig.isP1Turn());
	}

	@Test
	public void testPart15() {
		Player p1 = new Player("Mark");
		Player p2 = new Player("Molly");

		assertEquals(0, p1.getTotalScore());
		assertEquals(0, p1.getTurnScore());

		assertEquals(0, p2.getTotalScore());
		assertEquals(0, p2.getTurnScore());
	}

	@Test
	public void testPart16() {
		Game pig = new Game("Kevin", "Raymond");
		pig.getCurrent().setTurnScore(10);
		assertEquals(10, pig.getCurrent().getTurnScore());
	}

	@Test
	public void testPart17() {
		Game pig = new Game("Kevin", "Raymond");
		pig.getCurrent().setTurnScore(10);
		pig.getCurrent().saveScore();
		assertEquals(10, pig.getCurrent().getTotalScore());
	}

	@Test
	public void testPart18() {
		Game pig = new Game("Kevin", "Raymond");
		pig.getCurrent().setTurnScore(10);
		pig.getCurrent().saveScore();
		assertEquals(10, pig.getCurrent().getTotalScore());
	}

	@Test
	public void testPart19() {
		Player p1 = new Player("Mark");
		Player p2 = new Player("Molly");

		p1.setTurnScore(10);
		p1.setTotalScore(10);
		assertEquals(10, p1.getTotalScore());
		assertEquals(10, p1.getTurnScore());
		p1.resetTotalScore();
		p1.resetTurnScore();
		assertEquals(0, p1.getTotalScore());
		assertEquals(0, p1.getTurnScore());
	}

	@Test
	public void testPart20() {
		PigData.pig = new Game("Kevin", "Raymond");
		Game pig = PigData.pig;
		PigData.pig.rollDie();
		if (PigData.pig.getDie1().getTop() != 1 || PigData.pig.getDie2().getTop() != 1) {
			assertTrue(PigData.pig.isP1Turn());
		} else {
			assertFalse(PigData.pig.isP1Turn());
		}
		int sum1 = 0;
		int sum2 = 0;
		assertTrue(pig.isP1Turn());
		pig.rollDie();
		sum1 = pig.getPlayer1().getTurnScore();
		if (pig.getDie1().getTop() != 1 || pig.getDie2().getTop() != 1) {
			assertTrue(pig.isP1Turn());
			sum1 = pig.getPlayer1().getTurnScore();
			pig.holdDie();
		} else {
			assertFalse(pig.isP1Turn());
			pig.rollDie();
			if (pig.getDie1().getTop() != 1 || pig.getDie2().getTop() != 1) {
				sum2 = pig.getPlayer2().getTurnScore();
				pig.holdDie();
			}

		}

		assertEquals(sum1, pig.getPlayer1().getTotalScore());

		assertEquals(sum2, pig.getPlayer2().getTotalScore());

	}

}
