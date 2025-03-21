package geo;
import geo.*;
import jirama.*;
import vivant.*; 
public class Secteur{
    private Point[] form;
    private String nom;

    //impl ---> #[constructor] {
    public Secteur(String nom){
        this.form=new Point[4];
        this.nom=nom;
    }     
    // }
   
    public void init_form(Point p1,Point p2,Point p3,Point p4){
        this.form[0]=p1;
        this.form[1]=p2;
        this.form[2]=p3;
        this.form[3]=p4;
    }
    public  Point min_p(){
        Point minimum=new Point(0,0);
        minimum=this.form[0];
        for(int i=0;i<4;i++){
            if(minimum.get_x()>=this.form[i].get_x() && minimum.get_y()>=this.form[i].get_y()){
                minimum=this.form[i];
            }
        }
        return minimum;
    }
    public Point max_p(){
        Point maximum=new Point(0,0);
        maximum=this.form[0];
        for(int i=0;i<4;i++){
            if(maximum.get_x()<=this.form[i].get_x() && maximum.get_y()<=this.form[i].get_y()){
                maximum=this.form[i];
            }
        }
        return maximum;
    }
 
    public Point[] get_borne(){
      Point[] retour=new Point[2];
      retour[0]=this.min_p();
      retour[1]=this.max_p();
      return retour;
    }

    //impl -->#[PartialEq] {
    public boolean equal(Secteur autre){
        return autre.min_p().equal(this.min_p()) && autre.max_p().equal(this.max_p());
        
    }
    // }

    //impl -->#[filter]{
   public Maison [] filtrer_maison(Maison[] lm,int taille){
     Maison [] retour=new Maison[100];
     Point [] born=this.get_borne();
     int index=0;
     for(int i=0;i<taille;i++){
                 if(lm[i].get_position().appartient_sec(born[0],born[1])==true){
                        retour[index]=lm[i];
                        index+=1;
                 }
             }
        return retour;
    }

    public Coupure[] filtrer_coupure(Coupure[] lc,int taille){
        Coupure[] retour=new Coupure[100];
        int index=0;
        for(int i=0;i<taille;i++){
            if(lc[i].get_Secteur().equal(this)){
                retour[index]=lc[i];
                index+=1;
            }
        }
        return retour;
    }
    // }
    
    // impl --->#[Debug] {
    public void afficher_maison_sec(Maison[] lm,int taille){
        System.out.println("nom du secteur: "+this.nom);
        Maison[] lm_filtre=this.filtrer_maison(lm, taille);
            for(int i=0;lm_filtre[i]!=null;i++){
                lm_filtre[i].afficher();
            }
    }
    public void afficher(){
        System.out.println(this.nom);
    }
    // }

    //impl ---> #[get_field] {
    public String get_nom(){
        return this.nom;
    }
    public Point[] get_form(){
        return this.form;
    }
    // }

     //impl ---> #[mut_field] {
    public void set_nom(String nom){
        this.nom=nom;
    }
    public void set_form(Point[] form){
        this.form=form;
    }
    // }
    //impl --> #[inserable] {
        public void insert_into(Secteur[] ld){
            int i=0;
            while (true) {
                if(ld[i]==null){
                    break;
                }
                i++;
            }
            ld[i]=this;
        }
    
        public void replace_into(Secteur[] ld,int index){
            ld[index]=this;
        }
        
    // }
}