package test;

import org.junit.Assert;
import org.junit.Test;

import main.HangedBoard;

public class TestHangedBoard {
	
	@Test
	public void testHasLetterInWordSecret(){
		HangedBoard board = new HangedBoard();
		
		board.startGame("PERRO", 2);
		Assert.assertTrue(board.hasLetterInWordSecret('O'));
		
		Assert.assertFalse(board.hasLetterInWordSecret('I'));
		
	}
	
	@Test
	public void testHasLetterInWordPlayer(){
		HangedBoard board = new HangedBoard();
		
		board.startGame("PERRO", 2);
		board.addLetterToWordPlayer('R');
		Assert.assertTrue(board.hasLetterInWordPlayer('R'));
		
		Assert.assertFalse(board.hasLetterInWordPlayer('O'));
		
		
	}
	
	@Test
	public void testAddLetterToWordPlayer(){
		
		HangedBoard board = new HangedBoard();
		
		board.startGame("PERRO", 2);
		
		int[] results = board.addLetterToWordPlayer('R');
		int[] expected = new int[]{2,3};
		
		char[] charResults = board.getWordPlayer();
		char[] charExpected = "--RR-".toCharArray();
		
		Assert.assertArrayEquals(expected, results);
		
		Assert.assertArrayEquals(charExpected, charResults);
		
		
	}
	
	@Test
	public void testIsWinner(){
		HangedBoard board= new HangedBoard();
		
		board.startGame("PERRO", 2);
		board.addLetterToWordPlayer('P');
		board.addLetterToWordPlayer('E');
		board.addLetterToWordPlayer('R');
		Assert.assertFalse(board.isWinner());
		
		board.addLetterToWordPlayer('O');		
		Assert.assertTrue(board.isWinner());
		
		
	}
	
	
	@Test
	public void testIsGameOver(){
		HangedBoard board= new HangedBoard();
		
		board.startGame("PERRO", 2);
		board.addLetterToWordPlayer('P');
		Assert.assertFalse(board.isGameOver());
		board.addLetterToWordPlayer('A');
		board.addLetterToWordPlayer('I');
		Assert.assertTrue(board.isGameOver());
		
	}
}
