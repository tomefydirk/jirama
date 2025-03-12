public class Maison{
    Personne[] qui_vive;
    Point position;
    boolean is_coupe ;

    int indice_personne;
    Maison(){
    this.qui_vive=new Personne[100];
    this.position=new Point(0,0);
    this.is_coupe=false;
    this.indice_personne=0;
    }
    
}

