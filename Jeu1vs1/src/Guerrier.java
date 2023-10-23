import java.util.*;
public class Guerrier extends Personnage {

	Guerrier(String s, int pm, int p) {
		super(s, pm, p);
		// TODO Auto-generated constructor stub
	}
	
	public void attaquer (Personnage p) {
		int degat=1;
		if(this.armev==true) {
			degat+=1;
		}else {
			degat+=this.arme.degat();
			}
			p.PV-=degat; 
			if(p.PV==0) {
				if(tresorv==false) {
					for(int i=0;i<p.tresor.size();i++) {
						this.tresor.add(p.tresor.get(i));
						}
					System.out.println("");
					System.out.println("Le joueur "+p.nom+" est mort sous les coups de son adversaire "+this.nom+ " qui a pris tous ses tresors");
					}
				} else {
					System.out.println("");
					System.out.println("Le joueur "+this.nom+" a attaquer son adversaire "+p.nom+ " qui a subit "+ degat+ " points de degats");
				}
	}
	
	public void soin(Personnage p) {
		System.out.println("");
		System.out.println(this.nom+" fait des incantations dans le vide");
	}
	
	public void soin() {
		System.out.println("");
		System.out.println(this.nom+" fait des incantations dans le vide");
	}

}
