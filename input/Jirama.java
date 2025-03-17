public class Jirama{
    Maison[] lm;
    Coupure[] lc;
    Stat []j_stat;
    Jirama(){
      this.lm=new Maison[100];
      this.lc=new Coupure[100];
      this.j_stat=new Stat[100];
    }
    
    // impl --->#[Sized]
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
     // impl --->#[Sized]
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
      // impl --->#[Sized]
    int taille_stat(){
      int i=0;
      while(true){
        if(this.j_stat[i]==null){
            break;
        }
        i+=1;
      }
      return i;
    }
    void rajouter_stat(Secteur s){
      this.j_stat[this.taille_stat()]=new Stat(s, this.lc);
    }
    void chek_maison_false(Secteur[] ls){
         int t=this.taille_lm();
        for(int i=0;ls[i]!=null;i++){
                Maison[] my_tab=ls[i].filtrer_maison(this.lm,t);
                for(int j=0;my_tab[j]!=null;j++){
                       my_tab[j].is_coupe=false; 
                }
         } 
    }
    void push_date_fin_coupure(Secteur[] ls,Date fin){
        int t=this.taille_lc();
          for(int i=0;ls[i]!=null;i++){
                Coupure[] my_tab=ls[i].filtrer_coupure(this.lc,t);
                for(int j=0;my_tab[j]!=null;j++){
                      if(my_tab[j].date_fin==null){
                        my_tab[j].date_fin=fin; 
                      }
                     
                }
         } 
    }
    void Couper(Secteur[] ls,Date date_deb){
      for(int i=0;ls[i]!=null;i++){
       this.lc[this.taille_lc()]=new Coupure(ls[i],date_deb,this.lm,this.taille_lm());     
       }
     
   }
    void Retablir(Secteur[] ls,Date fin){
       this.chek_maison_false(ls);
       this.push_date_fin_coupure(ls,fin);
    }
    // impl --->#[Debug]
    void afficher_lc(){
        int t=this.taille_lc();
      for(int i=0;i<t;i++){
          System.out.println("|-------------------------------------------------------|");
          System.out.println("....Coupure "+(i+1)+"....");
          this.lc[i].afficher(this.lm,this.taille_lm());
          if(i==t-1){
            System.out.println("|-------------------------------------------------------|");
          }
          
      
      }
    }
    void afficher_lm(){
      for(int i=0;this.lm[i]!=null;i++){
            this.lm[i].afficher();
      }
    }
}