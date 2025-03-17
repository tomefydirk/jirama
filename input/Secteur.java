public class Secteur{
    Point[] form;
    String nom;
    Secteur(String nom){
        this.form=new Point[4];
        this.nom=nom;
    }     
   
    void init_form(Point p1,Point p2,Point p3,Point p4){
        this.form[0]=p1;
        this.form[1]=p2;
        this.form[2]=p3;
        this.form[3]=p4;
    }
     Point min_p(){
        Point minimum=new Point(0,0);
        minimum=this.form[0];
        for(int i=0;i<4;i++){
            if(minimum.x>=this.form[i].x && minimum.y>=this.form[i].y){
                minimum=this.form[i];
            }
        }
        return minimum;
    }
    Point max_p(){
        Point maximum=new Point(0,0);
        maximum=this.form[0];
        for(int i=0;i<4;i++){
            if(maximum.x<=this.form[i].x && maximum.y<=this.form[i].y){
                maximum=this.form[i];
            }
        }
        return maximum;
    }
 
    Point[] get_borne(){
      Point[] retour=new Point[2];
      retour[0]=this.min_p();
      retour[1]=this.max_p();
      return retour;
    }

    Maison [] filtrer_maison(Maison[] lm,int taille){
     Maison [] retour=new Maison[100];
     Point [] born=this.get_borne();
     int index=0;
     for(int i=0;i<taille;i++){
                 if(lm[i].position.appartient_sec(born[0],born[1])==true){
                        retour[index]=lm[i];
                        index+=1;
                 }
             }
        return retour;
    }

    boolean equal(Secteur autre){
        return autre.min_p().equal(this.min_p()) && autre.max_p().equal(this.max_p());
        
    }
    Coupure[] filtrer_coupure(Coupure[] lc,int taille){
        Coupure[] retour=new Coupure[100];
        int index=0;
        for(int i=0;i<taille;i++){
            if(lc[i].s.equal(this)){
                retour[index]=lc[i];
                index+=1;
            }
        }
        return retour;
    }

    // impl --->#[Debug]
    void afficher_maison_sec(Maison[] lm,int taille){
        System.out.println("nom du secteur: "+this.nom);
        Maison[] lm_filtre=this.filtrer_maison(lm, taille);
            for(int i=0;lm_filtre[i]!=null;i++){
                lm_filtre[i].afficher();
            }
    }
   
}