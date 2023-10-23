import java.util.*;
import java.io.IOException;
import java.io.Console;
public class Duel {
	private boolean fini;
	private Personnage winner;

	Duel(){
		fini=false;
	}
	public void attaquer(Personnage p) {
		this.attaquer(p);
	}


	public void soigner (Personnage p) {
		this.soigner(p);
	}
	public void fuir(){
		fini=true;
	}
	
	// Choix de l'action a faire en fct du chiffre ecrit par l'utilisateur
	public int choixActe() {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("Voici toutes les actions possibles");
			this.sp();
			System.out.println("1) Attaquer");
			System.out.println("2) Se Soigner");
			System.out.println("3) Soigner l'ennemi (Si le combat est trop facile)");
			System.out.println("4) Fuir en implorant le pardon de son adversaire");
			this.sp();
			System.out.println("Ecrivez votre choix ci dessous:");
			int n = s.nextInt();
			if(n<5 && n>0) {
				return n;
			}
			throw new Exception();
		}
		catch(Exception e) {
			System.out.println("Recommencez et cette fois il vous faut mettre un chiffre");
			choixActe();
			return 0;
		}
	}
	
	// Choix de l'action de L'ia a l'aide d'un nombre random de 0 a 20
	public int choixActeIa() {
		int m=(int) (Math.random() * (21-0) + 0);
		System.out.println(m);
		switch(m) {
		case 0: return 3; 
		case 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15: return 1; 
		case 16,17,18,19: return 2; 
		case 20: return 4; 
		}
		return 0;		
	}
	
	// Execution de l'action choisie en fonction du nombre retourner par les fonctions de choix d'action
	public void action(Personnage attaquant ,Personnage victime,int n){
		switch(n) {
		case 1: attaquant.attaquer(victime); break;
		case 2: attaquant.soin(); break;
		case 3: attaquant.soin(victime); break;
		case 4: System.out.println("Le joueur "+attaquant.nom+" a fui la queue entre les jambes tout en pleurant et implorant son adversaire (BOUUUUHHHH!!!!!) ");
		this.fuir(); break;
		}

	}
	// Fonction pour espacer
	public void sp(){
		System.out.println("");
	}
	
	// Fonction pour espacer les tours
	public void sb(){
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------");
	}

	public void main(Personnage P,Personnage P2,Boolean BotOuHumain) {
		System.out.println("Bonjour,Le joueur qui a initier le duel doit choisir sa  premiere action");
		if(BotOuHumain) {
			// Humain vs Humain
			while(true) {
				// 1 er tour 
				this.sp();
				
				// Choix de l'action a effecuter
				int s=choixActe();
				this.action(P,P2,s);
				this.sp();
				System.out.println("Il reste "+P.PV+" PV a "+P.nom+ " et "+P2.PV+ " PV a "+P2.nom);
				
				// Verification si le jour a fui ou est mort
				if(fini==true) {
					winner=P2;
					break;
				}else if(P2.mort()) {
					winner=P;
					break;
				}
				this.sb();
				
				//2 éme tour
				System.out.println("C'est maintenant au tour du deuxiéme joueur de jouer" );
				this.sp();
				
				// Choix de l'action a effecuter
				s=choixActe();
				this.action(P2,P,s);
				
				// Verification si le jour a fui ou est mort
				if(fini==true) {
					winner=P;
					break;
				}else if(P.mort()) {
					winner=P2;
					break;
				}
				this.sp();
				System.out.println("Il reste "+P.PV+" PV a "+P.nom+ " et "+P2.PV+ " PV a "+P2.nom);
				this.sb();
				System.out.println("Le premier joueur rejoue ");
			}
			
			// Fin de jeu
			this.sp();
			System.out.println("Le joueur "+winner.nom+" a gagné,il lui restait "+winner.PV+" PV");
			this.sp();
			//presentation des tresors du gagnant
			System.out.println("Voici l'ensemble de vos tresors:");
			this.sp();
			for(int i=0;i<winner.tresor.size();i++) {
				this.sb();
				System.out.println(winner.tresor.get(i).toString());
			}
			this.sb();
			
		}else{
			//Humain vs IA
			while (true) {
				this.sp();
				
				// Choix de l'action a effecuter
				int s=choixActe();
				this.action(P,P2,s);
				this.sp();
				System.out.println("Il reste "+P.PV+" PV a "+P.nom+ " et "+P2.PV+ " PV a "+P2.nom);
				
				// Verification si le jour a fui ou est mort
				if(fini==true) {
					winner=P2;
					break;
				}else if(P2.mort()) {
					winner=P;
					break;
				}
				this.sb();
				
				//2 éme tour (tour de L'IA)
				System.out.println("C'est maintenant au tour de l'ordinateur de jouer" );
				
				// Choix de l'action a effecuter
				s=choixActeIa();
				this.action(P2,P,s);
				
				// Verification si le jour a fui ou est mort
				if(fini==true) {
					winner=P;
					break;
				}else if(P.mort()) {
					winner=P2;
					break;
				}
				this.sp();
				System.out.println("Il reste "+P.PV+" PV a "+P.nom+ " et "+P2.PV+ " PV a "+P2.nom);
				this.sb();
				System.out.println("Le premier joueur rejoue ");
			}
			
			// Fin de jeu
			this.sp();
			System.out.println("Le joueur "+winner.nom+" a gagné,il lui restait "+winner.PV+" PV");
			this.sp();
			//presentation des tresors du gagnant
			System.out.println("Voici l'ensemble de vos tresors:");
			this.sp();
			for(int i=0;i<winner.tresor.size();i++) {
				this.sb();
				System.out.println(winner.tresor.get(i).toString());
			}
			this.sb();
			}
		}

	@Override
	public String toString() {
		return "Duel [fini=" + fini + ", winner=" + winner + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(fini, winner);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Duel other = (Duel) obj;
		return fini == other.fini && Objects.equals(winner, other.winner);
	}
	
	public static void main(String[] args) {
		Duel D=new Duel();
		Personnage p =new Guerrier("Mathis",20,72);
		Arme a=new Arme("Xerud",1,6);
		Personnage p2 = new Clerc("Artan",20,78);
		Arme b=new Arme("Rexud",2,7);
		Tresor t1=new Tresor("TresorR",50);
		Tresor t2=new Tresor("TresorR2",50);
		p.equiper(a);
		p2.equiper(b);
		p.prendre(t1);
		p2.prendre(t2);
		D.main(p,p2,true); // test humain vs humain
		// D.main(p,p2,false); test humain vs Ia
		// TODO Auto-generated method stub

	}
}
