import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArmeTest {
	@Test
	// Test Degat PD != PDmax
	void testdegat(){
		//Given
		Arme a =new Arme("BRK",1555,56556);
		boolean i=false;
		int j=a.getPD();
		//When
		int v=a.degat();

		while(i==false && j<=a.getPDmax()) {
			if(j==v) {
			
				i=true;
			}
			j++;	
		}
		//Then 
		System.out.print(v);
		assertEquals(true,i);
	}

	@Test
	// Test Degat PD == PDmax
	void testdegat2(){
		//Given
		Arme a =new Arme("BRK",1555,1555);
		boolean i=false;
		int j=a.getPD();
		//When
		int v=a.degat();

		while(i==false && j<=a.getPDmax()) {
			if(j==v) {
			
				i=true;
			}
			j++;	
		}
		//Then 
		System.out.print(v);
		assertEquals(true,i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
