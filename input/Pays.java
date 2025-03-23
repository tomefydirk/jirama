package geo;
import geo.*;
public class Pays{ 
    private String nom;
    private Point[] form;

    //impl --->#[constructor]{
    public Pays(String nom){
        this.nom=nom;
        this.form=new Point[4];
    }
    // }

    //impl --->#[get_field]{
    public String get_nom(){
        return this.nom;
    }
    public Point[] get_form(){
        return this.form;
    }
    // }

    //impl --->#[mut_field]{
    public void set_nom(String nom){
        this.nom=nom;
    }
    public void set_form(Point[] form){
        this.form=form;
    }
    // }

    //impl -->#[init]{
    public void init_form(Point p1,Point p2,Point p3,Point p4){

        this.form[0]=p1;
        this.form[1]=p2;
        this.form[2]=p3;
        this.form[3]=p4;
    }
    // }
    public Secteur into_seteur(){
        Secteur s=new Secteur(null);
        s.set_form(this.form);
        return s;
    }

    public boolean indicator_in(Secteur s){
        Secteur this_s=this.into_seteur();
        Point[] borne_s=s.get_borne();
        return borne_s[0].appartient_secV2(this_s) && borne_s[1].appartient_secV2(this_s);
    }

    //impl --->#[Debug]{
    public void afficher_debug(){
        System.out.println("---> Nom du pays: "+this.nom+"\n");
        for(int i=0;i<4;i++){
           this.form[i].afficher();
        }
     
    }
    public void afficher(){
      System.out.println("\n---> Nom du pays: "+this.nom+"\n");
    }
    
    
    //}
}
