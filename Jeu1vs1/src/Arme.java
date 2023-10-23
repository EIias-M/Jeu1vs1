import java.util.Objects;
public class Arme {
	private String nom;
	private int PD;
	private int PDmax;
	
	public Arme(String s, int i, int j) {
		nom=s;
		PD=i;
		PDmax=j;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPDmax() {
		return PDmax;
	}

	public void setPDmax(int pDmax) {
		PDmax = pDmax;
	}

	public int getPD() {
		return PD;
	}

	public void setPD(int pD) {
		PD = pD;
	}

	int random(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}

	public int degat() {
		int a=random(PD,PDmax);
		return a;	
	}

	
	public static void main (String[] args) {	
	}

	@Override
	public int hashCode() {
		return Objects.hash(PD, PDmax, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arme other = (Arme) obj;
		return PD == other.PD && PDmax == other.PDmax && Objects.equals(nom, other.nom);
	}

	@Override
	public String toString() {
		return "Arme [nom=" + nom + ", PD=" + PD + ", PDmax=" + PDmax + "]";
	}

}
