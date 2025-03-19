package jirama; 
import geo.*;
import jirama.*;
import vivant.*; 

public class Stat{
    Date min;
    Date max;
    Date moyenne;
    Secteur s;
    // {
    public Date first_into_list(Secteur s,Coupure[] lc){
        Date first=new Date(0,0,0,0,0,0);
        for(int i=0;lc[i]!=null;i++){
            if(lc[i].get_Secteur().equal(s) && lc[i].get_Date_fin()!=null){
                first=lc[i].Duree_coup();
                break;
            }
        }
        return first;
    }
    public int somme_duree_coup(Secteur s,Coupure[] lc){
        int retour=0;
        for(int i=0;lc[i]!=null;i++){
            if(lc[i].get_Secteur().equal(s) && lc[i].get_Date_fin()!=null){
                retour+=lc[i].Duree_coup().into_sec();
            }
        }

        return retour;
    }
    public int nb_coupure(Secteur s,Coupure[] lc){
        int retour=0;
        for(int i=0;lc[i]!=null;i++){
            if( lc[i].get_Date_fin()!=null && lc[i].get_Secteur().equal(s) ){
                retour+=1;
            }
        }
        return retour;
    }
    // }

    // Main function to find:[min,max,moyenne] {
    public Date chercher_min(Secteur s,Coupure[] lc){
        Date min=first_into_list(s, lc);
        for(int i=0;lc[i]!=null;i++){
            if(  lc[i].get_Date_fin()!=null && lc[i].get_Secteur().equal(s)){
                       min=lc[i].Duree_coup();
            }
        }
        return min;
    } 
    public Date chercher_max(Secteur s,Coupure[] lc){
        Date max=first_into_list(s, lc);
        for(int i=0;lc[i]!=null;i++){
            if(lc[i].get_Date_fin()!=null && lc[i].get_Secteur().equal(s) && lc[i].Duree_coup().into_sec()>max.into_sec() ){
                       max=lc[i].Duree_coup();
            }
        }
        return max;
    }   
    public Date chercher_moyenne(Secteur s,Coupure[] lc){
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
    // }

    //impl --->#[constructor]{
    public Stat(Secteur s,Coupure[] lc){
     this.min=chercher_min(s, lc);
     this.max=chercher_max(s, lc);
     this.moyenne=chercher_moyenne(s, lc);
     this.s=s;
    }
    // }

     // impl --->#[Debug] {
     public void afficher(){
        System.out.println("Secteur: "+this.s.get_nom());
        System.out.println("min--> "+this.min.into_string());
        System.out.println("max--> "+this.max.into_string());
        System.out.println("moyenne--> "+this.moyenne.into_string()+"\n");
     }
     // }

     //My private functions about Hashmap[]-->{
     My_hashmap min_tabVHash(My_hashmap [] tab){
        My_hashmap min=tab[0];
        if(tab==null){
            System.out.println("tab est vide { class:Stat && function:min_tab }");
        }
        for(int i=0;tab[i]!=null;i++){
            if(min.get_duration()>=tab[i].get_duration()){
                min=tab[i];
            }
        }
        return min;
     }
     // -->}

    // inseration{
    void insert_moyenne_into_Hashmap(My_hashmap[] tab,Stat[]list_stat){
        for(int i=0;list_stat[i]!=null;i++){
            My_hashmap h=new My_hashmap(list_stat[i].moyenne.into_sec(),list_stat[i].s);
            h.insert_into_VHash(tab);
        }
    }
    void insert_min_into_Hashmap(My_hashmap[] tab,Stat[] list_stat){
        for(int i=0;list_stat[i]!=null;i++){
            My_hashmap h=new My_hashmap(list_stat[i].min.into_sec(),list_stat[i].s);
            h.insert_into_VHash(tab);
        }
    }
    void insert_max_into_Hashmap(My_hashmap[] tab,Stat[] list_stat){
          for(int i=0;list_stat[i]!=null;i++){
            My_hashmap h=new My_hashmap(list_stat[i].max.into_sec(),list_stat[i].s);
            h.insert_into_VHash(tab);
        }
    }
    // }

    // identification{
    

    //}

    //  {
    public Secteur min_min(Stat[] ls){
        My_hashmap[] tab=new My_hashmap[100];
        insert_min_into_Hashmap(tab,ls);
        My_hashmap min=min_tabVHash(tab);
        return min.get_s();
    }
    public Secteur min_max(Stat[] ls){
         My_hashmap[] tab=new My_hashmap[100];
        insert_max_into_Hashmap(tab,ls);
        My_hashmap min=min_tabVHash(tab);
        return min.get_s();
    }
    public Secteur min_moyenne(Stat[] ls){
        My_hashmap[] tab=new My_hashmap[100];
        insert_moyenne_into_Hashmap(tab,ls);
        My_hashmap min=min_tabVHash(tab);
        return min.get_s();
    }

    // } 
    

   //impl --> #[inserable] {
    public void insert_into(Stat[] ld){
        int i=0;
        while (true) {
            if(ld[i]==null){
                break;
            }
            i++;
        }
        ld[i]=this;
    }

    public void replace_into(Stat[] ld,int index){
        ld[index]=this;
    }
    
    // }
}
