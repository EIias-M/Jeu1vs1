import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

public class TresorTest {
	@Test
	//Test si PO est bien egale au int donné
	void testPO(){
		//Given
		Tresor t1=new Tresor("T1",50);
		//Then
		assertEquals(t1.PO,50);

	}
}
