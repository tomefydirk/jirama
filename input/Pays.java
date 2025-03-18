package geo;
import geo.*;
public class Pays{ 
    Point[] extremite;

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
