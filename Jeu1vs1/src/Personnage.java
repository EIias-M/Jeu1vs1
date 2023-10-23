import java.util.*;
public class Personnage {

	protected String nom;
	protected int PVMax;
	protected int PV;
	protected Arme arme;
	protected boolean armev;
	protected ArrayList<Tresor> tresor;
	protected boolean tresorv;

	Personnage(String s,int p,int pm){
		nom=s;
		armev=true;
		tresorv=true;
		tresor=new ArrayList() ;
		if(pm<p) {
		PVMax=p;
		PV=pm;
		}else { // Si PV depasse PVMax
		PVMax=pm;
		PV=p;
		}
	}
	public void equiper(Arme a) {
		this.arme=a;
		this.armev=false;
	}
	
	public boolean mort() {
		return(PV<=0);
	}

	public void prendre(Tresor t) {
		this.tresor.add(t);
		if (this.tresorv==true) {this.tresorv=false;}
	}

	public void attaquer(Personnage p) {

	}
	public void soin (Personnage p) {
	}
	public void soin() {

	}
	@Override
	public int hashCode() {
		return Objects.hash(PV, PVMax, arme, armev, nom, tresor, tresorv);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personnage other = (Personnage) obj;
		return PV == other.PV && PVMax == other.PVMax && Objects.equals(arme, other.arme) && armev == other.armev
				&& Objects.equals(nom, other.nom) && Objects.equals(tresor, other.tresor) && tresorv == other.tresorv;
	}
	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", PVMax=" + PVMax + ", PV=" + PV + ", arme=" + arme + ", armev=" + armev
				+ ", tresor=" + tresor + ", tresorv=" + tresorv + "]";
	}

}
