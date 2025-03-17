public class Coupure{
        Date date_deb;
        Secteur s;
        Date date_fin;

        Coupure(Secteur s,Date db,Maison[] lm,int taille_lm){
            this.s=new Secteur(null);
            this.s=s;
            this.date_deb=db;
            this.date_fin=null  ;
            
            Maison[] my_list=s.filtrer_maison(lm,taille_lm);
            for(int i=0;my_list[i]!=null;i++){
                   my_list[i].is_coupe=true;       
            }
 
        }
        Date Duree_coup(){
            Date retour=new Date(0,0,0,0,0,0);
            retour=this.date_deb.duree(this.date_fin);
            return retour;
        }
        // impl --->#[Debug]
        void afficher(Maison[] lm,int taille){
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
}