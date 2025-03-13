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
        void afficher(){
            System.out.println("\n{");
            System.out.println(this.s.nom);
            System.out.print("date debut---> ");
            this.date_deb.afficher();
           
            System.out.print("date fin---> ");
            this.date_fin.afficher();
            System.out.println("}\n");
        }
}