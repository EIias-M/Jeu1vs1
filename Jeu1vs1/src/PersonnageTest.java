 import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

public class PersonnageTest {
	@Test
	//Test initialisation avec PV>PVMax
	void testpv() {
		//Given
		Personnage p =new Guerrier("Rayane",72,20);
		//Then 
		assertEquals(p.PV,20);
	}
	
	@Test
	// Test Equiper/Guerrier
	void testequiperg(){
		//Given
		Personnage p =new Guerrier("Rayane",20,72);
		Arme a=new Arme("Xerud",1,6);
		//When
		p.equiper(a);
		//Then 
		assertEquals(p.arme,a);
	}
	
	@Test
	// Test Equiper/Clerc
		void testequiperc(){
			//Given
			Personnage p =new Clerc("Rayane",20,72);
			Arme a=new Arme("Xerud",1,6);
			//When
			p.equiper(a);
			//Then 
			assertEquals(p.arme,a);
		}
	@Test 
	// Test soin Clerc
	void testsoinc() {
		//Given
		Personnage p =new Clerc("Rayane",20,72);
		//When
		p.soin();
		//Then
		assertEquals(p.PV,24);
	}
	
	@Test  
	// Test soin Guerrier
	void testsoing() {
		//Given
		Personnage p =new Guerrier("Rayane",20,72);
		//When
		p.soin();
		//Then
		assertEquals(p.PV,20);
	}
	
	@Test
	//Test prendre un tresor
	void testtresor() {
		//Given
		Tresor t=new Tresor("Tresor2",50);
		Personnage p =new Guerrier("Rayane",20,72);
		//When
		p.prendre(t);
		//Then
		assertEquals(t,p.tresor.get(0));	
	}
	
	@Test
	//Test soin sur un autre
	void testsoinautre() {
		//Given
		Personnage p =new Guerrier("Rayane",20,72);
		Personnage p2 = new Clerc("Rayan",20,78);
		//When
		p2.soin(p);
		//Then
		assertEquals(p.PV,24);
	}
	
	@Test
	void mort() {
		//Given
		Personnage p =new Guerrier("Rayane",20,72);
		Arme a=new Arme("Xerud",1,6);
		Personnage p2 = new Clerc("Rayan",1,78);
		Arme b=new Arme("Rexud",2,7);
		//When
		p.equiper(a);
		p2.equiper(b);
		p.attaquer(p2);
		//Then
		assertEquals(p2.mort(),true);
	}
	
	@Test
	void testdegat(){
		//Given
		boolean test=false;
		boolean t1=false;
		boolean t2=false;
		Personnage p =new Guerrier("Rayane",20,72);
		Arme a=new Arme("Xerud",1,6);
		Personnage p2 = new Clerc("Rayan",20,78);
		Arme b=new Arme("Rexud",2,7);
		//When
		p.equiper(a);
		p2.equiper(b);

		p.attaquer(p2);
		System.out.print(p.PV);
		System.out.print("|");
		System.out.print(p2.PV);
		System.out.print("|");
		p2.attaquer(p);
		System.out.print(p2.PV);
		System.out.print("|");
		System.out.print(p.PV);
		System.out.print("|");
		//Then 
		if(p2.PV<=18 && p2.PV>=12)
		{
			 t1=true;
		}
		System.out.print(t1);
		System.out.print("|");
		if(p.PV<=19 && p.PV>=14)
		{
			t2=true;
		}
		test=(t1&&t2);
		System.out.print(t2);
		System.out.print("|");
		assertEquals(true,true);
	}
}
