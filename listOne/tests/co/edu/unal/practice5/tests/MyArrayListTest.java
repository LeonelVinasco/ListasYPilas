package co.edu.unal.practice5.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import co.edu.unal.practice5.MyArrayList;

public class MyArrayListTest {
private MyArrayList<Character> vowels;
private MyArrayList<Integer> digits;



	@Before
	public void setUp() throws Exception {
	vowels=new MyArrayList<Character>();
	digits = new MyArrayList<Integer>();
	vowels.add('a');
	vowels.add('e');
	vowels.add('i');
	}

	@Ignore 
	public void testMyArrayList() {
		fail("Not yet implemented");
	}

	@Ignore 
	public void testEnsureCapacity() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
	
		assertEquals("Bad Result --Size()", 3, vowels.size());
		assertEquals("Bad Result --Size()", 0, digits.size());
		
	}

	@Test
	public void testAdd() {
		vowels.add('o');
		digits.add(1);
		assertEquals("Result", 4, vowels.size());
		assertEquals("Result", 1, digits.size());
		
	}

	@Test
     public void testGet(){
    	 
		digits.add(3);
vowels.add('u');
	 
	
      assertEquals("Result",(Integer) 3, digits.get(0)); 
        
      assertEquals("Result", (Character) 'u' , vowels.get(3));
       
        
        
        
     }
     



}
