import java.util.*;

public class Clerc extends Personnage{

	Clerc(String s, int pm, int p) {
		super(s, pm, p);
		// TODO Auto-generated constructor stub
	}

	public void attaquer (Personnage p) {
		int degat=0;
		if(this.armev==true) {
			degat+=1;
		}else {
			degat+=this.arme.degat();
		}
		degat-=1;
		if(degat==0) {
			degat=1;
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
		}else { 
			System.out.println("");
			System.out.println("Le joueur "+this.nom+" a attaquer son adversaire "+p.nom+ " qui a subit "+ degat+ " points de degats");
		}
	}

	public void soin(Personnage p) {
		if((p.PVMax-p.PV)>=4) {
			p.PV+=4;
		}else {
			p.PV=p.PVMax;
		}
		System.out.println("");
		System.out.println("Le joueur "+this.nom+" a soigner "+p.nom);
	}
	
	public void soin() {
		if((this.PVMax-this.PV)>=4) {
			this.PV+=4;
		}else {
			this.PV=this.PVMax;
		}
		System.out.println("");
		System.out.println("Le joueur "+this.nom+" s'est soigner ");
	}

}


