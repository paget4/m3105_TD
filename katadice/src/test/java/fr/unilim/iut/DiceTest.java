package fr.unilim.iut;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.util.Random;

import org.junit.Test;

import katadice.Dice;

public class DiceTest {
	Dice theDice;
	
	@Test
	public void rollReturnsAValue() {
		theDice = new Dice(new Random());
		for (int i = 0; i < 100; i++) {
			int result = theDice.roll();
			assertTrue(result >= 1);
			assertTrue(result <= 6);
		}
	}

	@Test(expected = RuntimeException.class)
 	public void identifyBadValuesGreaterThanNumberOfFaces() {
 		Random mockRandom = mock(Random.class);
 		when(mockRandom.nextInt(anyInt())).thenReturn(7);
 		theDice = new Dice(mockRandom);
 		theDice.roll();
 	} 
	
 	@Test(expected = RuntimeException.class)
 	public void identifyBadValuesLesserThanOne() {
		Random mockRandom = mock(Random.class);
 		when(mockRandom.nextInt()).thenReturn(0);
     	theDice = new Dice(mockRandom);
     	theDice.roll();
 	}
}
