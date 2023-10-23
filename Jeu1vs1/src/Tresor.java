import java.util.Objects;

public class Tresor {
	protected String desc;
	protected int PO;
	@Override
	public String toString() {
		return "Tresor [desc=" + desc + ", PO=" + PO + "]";
	}
	
	
	Tresor(String d,int p){
		desc=d;
		PO=p;
	}
	@Override
	public int hashCode() {
		return Objects.hash(PO, desc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tresor other = (Tresor) obj;
		return PO == other.PO && Objects.equals(desc, other.desc);
	}


}
