package buisness;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Bahnhof;

class BahnhoefTest {
	
	private Bahnhof bahnhof;
	private String[]zugarten = {"Bochum,RB,S"};
	@BeforeEach
	void setUp() {
		
		bahnhof = new Bahnhof("Bochum","Langendreer",2,1980,zugarten);
		
		
	}
	@AfterEach
	void tearDown() throws Exception {
		bahnhof = null;
	} 

	@Test
	void test() {
		assertTrue(()->bahnhof.getName().equals("Bochum"),()->"Der Test war erfolgreich!");
	}
	
	
	void test2() {
		
		Throwable exc = assertThrows(IllegalArgumentException.class,()->{new Bahnhof(null,"Langendreer",2,1980,zugarten);});
		assertEquals("Artikelnummer darf nicht null sein", exc.getMessage());
	}

}




//Bochum, Langendreer ,Bochum ,2 ,1980,RB,S 













































