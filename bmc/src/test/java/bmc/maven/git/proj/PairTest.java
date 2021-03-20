package bmc.maven.git.proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;



class PairTest {
	@Test
	void testSettersGetters() {
		Pair<Integer, String> obj = Pair.of(1,"Shay");
		assertTrue(obj.getKey() == 1);
		assertTrue(obj.getValue() == "Shay");
		
		Pair<String, Integer> obj2 = Pair.of("Shay", 1);
		assertTrue(obj2.getKey() == "Shay");
		assertTrue(obj2.getValue() == 1);
		
		assertTrue(1 == obj.setKey(2));
		assertTrue("Shay" == obj2.setKey("Melinda"));
		assertTrue(obj.getKey() == 2);
		assertTrue(obj2.getKey() == "Melinda");
		
		assertTrue("Shay" == obj.setValue("3"));
		assertTrue(1 == obj2.setValue(3));
		assertTrue(obj.getValue() == "3");
		assertTrue(obj2.getValue() == 3);
		
	}
	@Test
	void testSwap() {
		Pair<Integer, String> obj = Pair.of(1,"Shay");
		Pair<String, Integer> swappedObj = Pair.swap(obj);
		assertTrue("Shay" == swappedObj.getKey());
		assertTrue(1 == swappedObj.getValue());
		
		Pair<String, String> strPair = Pair.swap(Pair.of("Shay", "Ginat"));
		assertTrue("Shay" == strPair.getValue());
		assertTrue("Ginat" == strPair.getKey());
	}
	
	@Test
	void testHashCode() {
		Pair<Integer, String> obj = Pair.of(1,"Shay");
		Pair<Integer, String> obj2 = Pair.of(1,"Melinda");
		assertTrue(obj.hashCode() == obj2.hashCode());
		obj2.setKey(3);
		assertFalse(obj.hashCode() == obj2.hashCode());
		
	}
	@Test
	void testEquals() {
		Pair<Integer, String> obj = Pair.of(3, "hello");
		Pair<Integer, String> obj2 = Pair.of(3, "hello");
		
		assertTrue(obj.equals(obj2));
		
		Pair<String, Integer> obj3 = Pair.of("yes", 323);
		Pair<String, Integer> obj4 = Pair.of("yes", 3);
		assertTrue(obj3.equals(obj4));
		
		obj4.setKey("no");
		assertFalse(obj3.equals(obj4));
		assertFalse(obj3.equals(3));
	}
	
	@Test
	void testMinMaxComperable(){
		Integer[] arr = {1,8,-9,3,7};
		Integer[] arr2 = {1,8,-9,3,33,-16};
		Pair<Integer,Integer> minmaxPair1 = Pair.minMax(arr);
        assertEquals(minmaxPair1.getKey(),-9);
        assertEquals(minmaxPair1.getValue(),8);
        
        Pair<Integer,Integer> minmaxPair2 = Pair.minMax(arr2);
        assertEquals(minmaxPair2.getKey(),-16);
        assertEquals(minmaxPair2.getValue(),33);
		
	}
	
	@Test
	void testMinMaxComperator(){
		
		 Comparator<Integer> comperator = new Comparator<Integer>() {
	            @Override 
	            public int compare(Integer num1, Integer num2) {
	                return num1.compareTo(num2); 
	            } 
	        };
		
		Integer[] arr = {1,8,-9,3,7};
		Integer[] arr2 = {1,8,-9,3,33,-16};
		Pair<Integer,Integer> minmaxPair1 = Pair.minMax(arr, comperator);
        assertEquals(minmaxPair1.getKey(),-9);
        assertEquals(minmaxPair1.getValue(),8);
        
        Pair<Integer,Integer> minmaxPair2 = Pair.minMax(arr2, comperator);
        assertEquals(minmaxPair2.getKey(),-16);
        assertEquals(minmaxPair2.getValue(),33);
		
	}

}

