package geo;
import geo.*;
public class Pays{ 
    private String nom;
    private Point[] extremite;

    //impl --->#[constructor]{
    public Pays(String nom){
        this.nom=nom;
        this.extremite=new Point[4];
    }
    // }

    //impl --->#[get_field]{
    public String get_nom(){
        return this.nom;
    }
    public Point[] get_extremite(){
        return this.extremite;
    }
    // }

    //impl --->#[mut_field]{
    public void set_nom(String nom){
        this.nom=nom;
    }
    public void set_extremite(Point[] extremite){
        this.extremite=extremite;
    }
    // }

    //impl -->#[init]{
    public void init_form(Point p1,Point p2,Point p3,Point p4){

        this.extremite[0]=p1;
        this.extremite[1]=p2;
        this.extremite[2]=p3;
        this.extremite[3]=p4;
    }
    // }
    public Secteur into_seteur(){
        Secteur s=new Secteur(null);
        s.set_form(this.extremite);
        return s;
    }

    public boolean indicator_in(Secteur s){
        Secteur this_s=this.into_seteur();
        Point[] borne_s=s.get_borne();
        return borne_s[0].appartient_secV2(this_s) && borne_s[1].appartient_secV2(this_s);
    }
}
