
public class Stat{
    Date min;
    Date max;
    Date moyenne;
    Secteur s;
    Date first_into_list(Secteur s,Coupure[] lc){
        Date first=new Date(0,0,0,0,0,0);
        for(int i=0;lc[i]!=null;i++){
            if(lc[i].s.equal(s) && lc[i].date_fin!=null){
                first=lc[i].Duree_coup();
                break;
            }
        }
        return first;
    }
    Date chercher_min(Secteur s,Coupure[] lc){
        Date min=first_into_list(s, lc);
        for(int i=0;lc[i]!=null;i++){
            if(  lc[i].date_fin!=null && lc[i].s.equal(s)){
                       min=lc[i].Duree_coup();
            }
        }
        return min;
    } 
    Date chercher_max(Secteur s,Coupure[] lc){
        Date max=first_into_list(s, lc);
        for(int i=0;lc[i]!=null;i++){
            if(lc[i].date_fin!=null && lc[i].s.equal(s) && lc[i].Duree_coup().into_sec()>max.into_sec() ){
                       max=lc[i].Duree_coup();
            }
        }
        return max;
    }
    int somme_duree_coup(Secteur s,Coupure[] lc){
        int retour=0;
        for(int i=0;lc[i]!=null;i++){
            if(lc[i].s.equal(s) && lc[i].date_fin!=null){
                retour+=lc[i].Duree_coup().into_sec();
            }
        }

        return retour;
    }
    int nb_coupure(Secteur s,Coupure[] lc){
        int retour=0;
        for(int i=0;lc[i]!=null;i++){
            if( lc[i].date_fin!=null && lc[i].s.equal(s) ){
                retour+=1;
            }
        }
        return retour;
    }
    Date moyenne(Secteur s,Coupure[] lc){
        int sum=somme_duree_coup(s, lc);
        int diviseur=nb_coupure(s, lc);
        if(diviseur==0){
            return new Date(0,0,0,0,0,0);
        }else{
            int  a=(sum/diviseur);
            Date retour= new Date(0,0,0,0,0,0);
            return retour.from_sec(a);
        }
    }
    Stat(Secteur s,Coupure[] lc){
     this.min=chercher_min(s, lc);
     this.max=chercher_max(s, lc);
     this.moyenne=moyenne(s, lc);
     this.s=s;
    }
     // impl --->#[Debug]
     void afficher(){
        System.out.println("Secteur: "+this.s.nom);
        System.out.println("min--> "+this.min.into_string());
        System.out.println("max--> "+this.max.into_string());
        System.out.println("moyenne--> "+this.moyenne.into_string()+"\n");
     }
     Stat min_moyenne(Stat[] list_stat){
        Stat retour=list_stat[0];
        for(int i=0;list_stat[i]!=null;i++){
            if(retour.moyenne.into_sec()>=list_stat[i].moyenne.into_sec()){
                retour=list_stat[i];
            }
        }
        return  retour;
     }
     Stat min_max(Stat[] list_stat){
        Stat retour=list_stat[0];
        for(int i=0;list_stat[i]!=null;i++){
            if(retour.max.into_sec()>=list_stat[i].max.into_sec()){
                retour=list_stat[i];
            }
        }
        return retour;
     }
     Stat min_min(Stat[] list_stat){
        Stat retour=list_stat[0];
        for(int i=0;list_stat[i]!=null;i++){
            if(retour.min.into_sec()>=list_stat[i].min.into_sec()){
                retour=list_stat[i];
            }
        }
        return  retour;
     }
   Secteur min_min_sec(Stat[] list_stat){
        Secteur retour=min_min(list_stat).s;
        return retour;
   }

   Secteur min_moyenne_sec(Stat[] list_stat){
    Secteur retour=min_moyenne(list_stat).s;
    return retour;
  }

  Secteur min_max_sec(Stat[] list_stat){
    Secteur retour=min_max(list_stat).s;
    return retour;
  }
}
