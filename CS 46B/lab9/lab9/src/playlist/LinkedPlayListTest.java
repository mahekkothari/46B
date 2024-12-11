package playlist;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LinkedPlayListTest {
	
	static Song s1;
	static Song s2;
	static Song s3;
	static Song s4;
	static Song s5;
	
	LinkedPlayList empty = new LinkedPlayList();
	LinkedPlayList one = new LinkedPlayList();
	LinkedPlayList songs = new LinkedPlayList();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		s1 = new Song("Bad Habits","Ed Sheeran");
		s2 = new Song("Tides", "Ed Sheeran");
		s3 = new Song("Overpass Graffiti","Ed Sheeran");
		s4 = new Song("Heat Waves","Glass Animals");
		s5 = new Song("Ophelia","The Lumineers");
	}

	@Before
	public void setUp() throws Exception {
		one.insertAtHead(s1);
		songs.insertAtHead(s4);
		songs.insertAtHead(s3);
		songs.insertAtHead(s2);
		songs.insertAtHead(s1);
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void containsTrue() {
		assertTrue(songs.contains(s1));
		assertTrue(songs.contains(s2));
		assertTrue(songs.contains(s3));
		assertTrue(songs.contains(s4));
	}
	
	@Test
	public void containsFalse() {
		assertFalse(songs.contains(s5));
	}
	
	@Test
	public void append() {
		LinkedPlayList added = new LinkedPlayList();
		added.insertAtHead(s5);
		added.insertAtHead(s4);
		added.insertAtHead(s3);
		added.insertAtHead(s2);
		added.insertAtHead(s1);
		songs.append(s5);
		assertTrue(songs.equals(added));
	}
	
	@Test
	public void appendEmptyList() {
		//Fill this in.
	}
	
	@Test
	public void getHeadTest() {
		assertTrue(s1.equals(songs.get(0).getSong()));
	}
	
	@Test 
	public void getRandomTest() {
		assertTrue(s2.equals(songs.get(1).getSong()));
	}
	
	@Test 
	public void getLastTest() {
		assertTrue(s4.equals(songs.get(3).getSong()));
	}
	
	@Test 
	public void addInMiddle() {
		LinkedPlayList added = new LinkedPlayList();
		added.insertAtHead(s4);
		added.insertAtHead(s3);
		added.insertAtHead(s5);
		added.insertAtHead(s2);
		added.insertAtHead(s1);
		
		songs.add(2, s5);
		
		assertTrue(songs.equals(added));
	}
	
	@Test 
	public void removeHead() {
		LinkedPlayList added = new LinkedPlayList();
		added.insertAtHead(s4);
		added.insertAtHead(s3);
		added.insertAtHead(s2);
		
		assertTrue(songs.removeOne(s1));
		assertTrue(songs.equals(added));
		
	}
	
	@Test 
	public void removeMiddle() {
		LinkedPlayList added = new LinkedPlayList();
		added.insertAtHead(s4);
		added.insertAtHead(s2);
		added.insertAtHead(s1);
		
		assertTrue(songs.removeOne(s3));
		
		assertTrue(songs.equals(added));
	}
	

}
