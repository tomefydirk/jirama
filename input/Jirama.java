package jirama; 
import geo.*;
import jirama.*;
import vivant.*; 

public class Jirama{
   private  Maison[] lm;
   private  Coupure[] lc;
   private  Stat []j_stat;
   private  Pays p;
    //impl -->#[constructor]{
    public Jirama(){
      this.lm=new Maison[100];
      this.lc=new Coupure[100];
      this.j_stat=new Stat[100];
    }
    // }

    void panicked_sec_size(String nom){
        System.out.println("Le secteur "+nom+" est plus grand que le pays");
    }    

    // impl --->#[Sized] {
    public int taille_lm(){
        int i=0;
      while(true){
        if(this.lm[i]==null){
            break;
        }
        i+=1;
      }
      return i;

    }

     public int taille_lc(){
        int i=0;
      while(true){
        if(this.lc[i]==null){
            break;
        }
        i+=1;
      }
      return i;
        
    }
   
    public int taille_stat(){
      int i=0;
      while(true){
        if(this.j_stat[i]==null){
            break;
        }
        i+=1;
      }
      return i;
    }
    // }

    public void rajouter_stat(Secteur s){
      this.j_stat[this.taille_stat()]=new Stat(s, this.lc);
    }
    public void chek_maison_false(Secteur[] ls){
         int t=this.taille_lm();
        for(int i=0;ls[i]!=null;i++){
         if( this.p.indicator_in(ls[i])){ // 1°)
             Maison[] my_tab=ls[i].filtrer_maison(this.lm,t);
                for(int j=0;my_tab[j]!=null;j++){
                       my_tab[j].set_is_coupe(false); 
                }
         } else{
          panicked_sec_size(ls[i].get_nom());
         }
         }
             
    }
    public void push_date_fin_coupure(Secteur[] ls,Date fin){
        int t=this.taille_lc();
          for(int i=0;ls[i]!=null;i++){
            if(this.p.indicator_in(ls[i])){ // 1°)

               Coupure[] my_tab=ls[i].filtrer_coupure(this.lc,t);
            
                for(int j=0;my_tab[j]!=null;j++){
                      if(my_tab[j].get_Date_fin()==null){
                        my_tab[j].set_Date_fin(fin); 
                      }
            }
         
         }else{
          panicked_sec_size(ls[i].get_nom());
         }
         } 
    }
    public void Couper(Secteur[] ls,Date date_deb){
      for(int i=0;ls[i]!=null;i++){
        if(this.p.indicator_in(ls[i])){ // 1°)
            this.lc[this.taille_lc()]=new Coupure(ls[i],date_deb,this.lm,this.taille_lm());     
        }else{
          panicked_sec_size(ls[i].get_nom());
        }
       }
     
   }
   public void Retablir(Secteur[] ls,Date fin){
       this.chek_maison_false(ls);
       this.push_date_fin_coupure(ls,fin);
    }
    // impl --->#[Debug] {
    public void afficher_lc(){
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

    public void afficher_lm(){
      for(int i=0;this.lm[i]!=null;i++){
            this.lm[i].afficher();
      }
    }
    // }
    
    //impl -->#[get_field] {
    public Maison[] get_lm(){
      return this.lm;
    }
    public Coupure[] get_lc(){
      return this.lc;
    }
    public Stat[] get_Stats(){
       return this.j_stat;
    }
    public Pays get_pays(){
      return this.p;
    }
    // }

    //impl ---> #[mut_field] {
    public void set_lm(Maison[] lm){
      this.lm=lm;
    }
    public void set_lc(Coupure[] lc){
      this.lc=lc;
    }
    public void set_Stats(Stat[] st){
      this.j_stat=st;
    }
    public void set_pays(Pays p){
      this.p=p;
    }
    // }

    /* impl --> #[mut_slice_field) { */
    
    //impl pushable{
    public void push_lm(Maison value){
      this.lm[taille_lm()]=value;
    }

    public void push_lc(Coupure value){
      this.lc[taille_lc()]=value;
    }
    public void push_j_stat(Stat value){
      this.j_stat[taille_stat()]=value;
    }
    //}

    //impl mutable index{
    public void replace_lm(Maison value,int index){
      this.lm[index]=value;
    }
    public void replace_lc(Coupure value,int index){
      this.lc[index]=value;
    }
    public void replace_stat(Stat value,int index){
      this.j_stat[index]=value;
    }
    //}

    /* } */

    // 1°) condition miteny hoé ao anatin'ilay pays ilay secteur
}