package jirama; 
import geo.*;
import jirama.*;
import vivant.*; 
public class Coupure{
        Date date_deb;
        Secteur s;
        Date date_fin;

        public Coupure(Secteur s,Date db,Maison[] lm,int taille_lm){ 
            this.s=new Secteur(null);
            this.s=s;
            this.date_deb=db;
            this.date_fin=null  ;
            
            Maison[] my_list=s.filtrer_maison(lm,taille_lm);
            for(int i=0;my_list[i]!=null;i++){
                   my_list[i].set_is_coupe(true);       
            }
 
        }
        public Date Duree_coup(){
            Date retour=new Date(0,0,0,0,0,0);
            retour=this.date_deb.duree(this.date_fin);
            return retour;
        }

        // impl --->#[Debug]
        public void afficher(Maison[] lm,int taille){
            System.out.println("\n{");
            this.s.afficher_maison_sec(lm,taille);
            System.out.println("\n");
            System.out.print("date debut---> ");
            this.date_deb.afficher();
           
            System.out.print("date fin---> ");
            if(this.date_fin==null){
            System.out.println("nothing");
            }else{
                this.date_fin.afficher();
            }
            System.out.println("}\n");
        }

         //impl ---> #[get_field]
         public Date get_Date_deb(){
            return this.date_deb;
         }
         public Date get_Date_fin(){
            return this.date_fin;
         }
         public Secteur get_Secteur(){
            return this.s;
         }

         //impl ---> #[mut_field]
         public void set_Date_deb(Date date_deb){
            this.date_deb=date_deb;
         }
         public void set_Date_fin(Date date_fin){
            if(this.date_deb.into_sec()<=this.date_fin.into_sec()){ //2°)
                 this.date_deb=date_fin;
            }else{
                System.out.println("Ereure de gestion de durée de coupure");
            }
         }
         public void set_secteur(Secteur s){
            this.s=s;
         }

          //impl --> #[inserable] {
    public void insert_into(Coupure[] ld){
        int i=0;
        while (true) {
            if(ld[i]==null){
                break;
            }
            i++;
        }
        ld[i]=this;
    }

    public void replace_into(Coupure[] ld,int index){
        ld[index]=this;
    }
    
    // }

   //2°) condition miteny fa sy maintsy lehibé ilay date fin
}