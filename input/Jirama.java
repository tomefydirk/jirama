public class Jirama{
    Maison[] lm;
    Coupure[] lc;
    Jirama(){
      this.lm=new Maison[100];
      this.lc=new Coupure[100];
    }
    int taille_lm(){
        int i=0;
      while(true){
        if(this.lm[i]==null){
            break;
        }
        i+=1;
      }
      return i;

    }
    int taille_lc(){
        int i=0;
      while(true){
        if(this.lc[i]==null){
            break;
        }
        i+=1;
      }
      return i;
        
    }
 
    void chek_maison_false(Secteur[] ls,int taille_ls){
         int t=this.taille_lm();
        for(int i=0;i<taille_ls;i++){
                Maison[] my_tab=ls[i].filtrer_maison(this.lm,t);
                int nb_maison=ls[i].taille_filtrer_maison(this.lm,t);
                for(int j=0;j<nb_maison;j++){
                       my_tab[j].is_coupe=false; 
                }
         } 
    }
    void push_date_fin_coupure(Secteur[] ls,Date fin,int taille_ls){
        int t=this.taille_lc();
          for(int i=0;i<taille_ls;i++){
                Coupure[] my_tab=ls[i].filtrer_coupure(this.lc,t);
                int nb_coupure=ls[i].taille_filtrer_coupure(this.lc,t);
                for(int j=0;j<nb_coupure;j++){
                      if(my_tab[j].date_fin==null){
                        my_tab[j].date_fin=fin; 
                      }
                     
                }
         } 
    }
    void Couper(Secteur[] ls,Date date_deb,int taille_ls){
      for(int i=0;i<taille_ls;i++){
       this.lc[this.taille_lc()]=new Coupure(ls[i],date_deb,this.lm,this.taille_lm());     
       }
     
   }
    void Retablir(Secteur[] ls,Date fin,int taille_ls){
       this.chek_maison_false(ls,taille_ls);
       this.push_date_fin_coupure(ls,fin,taille_ls);
    }
}