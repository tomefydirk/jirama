public class Main{
    public static void main(String[] args){
 
      /*----Maison----------*/
      Maison m1=new Maison("m1");
      m1.position=new Point(1, 1);

      Maison m2=new Maison("m2");
      m2.position=new Point(1, 2);

      Maison m3=new Maison("m3");
      m3.position=new Point(1, 3);

      Maison m4=new Maison("m4");
      m4.position=new Point(1, 6);

      Maison m5=new Maison("m5");
      m5.position=new Point(1, 7);

      Maison m6=new Maison("m6");
      m6.position=new Point(1, 8);

      Maison m7=new Maison("m7");
      m7.position=new Point(6, 1);

      Maison m8=new Maison("m8");
      m8.position=new Point(6, 2);

      Maison m9=new Maison("m9");
      m9.position=new Point(6, 3);

      
      Secteur s1=new Secteur("S1");
      s1.init_form(new Point(0, 0),new Point(0, 5),new Point(5, 5),new Point(5, 0));

      Secteur s2=new Secteur("S2");
      s2.init_form(new Point(5, 0),new Point(5, 5),new Point(10, 5),new Point(10, 0));
    
      Secteur s3=new Secteur("S3");
      s3.init_form(new Point(0, 5),new Point(0, 10),new Point(8, 10),new Point(8, 5));
      /*-----coupure------------- */
      Secteur[] coup_ls1=new Secteur[10];
      coup_ls1[0]=s1;
      coup_ls1[1]=s2;
      coup_ls1[2]=s3;

      Secteur[] coup_ls2=new Secteur[10];
      coup_ls2[0]=s3;

      Secteur[] coup_ls3=new Secteur[10];
      coup_ls3[0]=s1;
      coup_ls3[1]=s3;

      /*------retablisssement-------*/
      Secteur[] retab_ls1=new Secteur[10];
      retab_ls1[0]=s2;
      retab_ls1[1]=s3;

      Secteur[] retab_ls2=new Secteur[10];
      retab_ls2[0]=s3;
      retab_ls2[1]=s1;

      Secteur[] retab_ls3=new Secteur[10];
      retab_ls3[0]=s1;
      retab_ls3[1]=s3;

     
      Jirama my_Jirama=new Jirama();
    
        my_Jirama.lm[my_Jirama.taille_lm()]=m1;
        my_Jirama.lm[my_Jirama.taille_lm()]=m2;
        my_Jirama.lm[my_Jirama.taille_lm()]=m3;
        my_Jirama.lm[my_Jirama.taille_lm()]=m4;
        my_Jirama.lm[my_Jirama.taille_lm()]=m5;
        my_Jirama.lm[my_Jirama.taille_lm()]=m6;
        my_Jirama.lm[my_Jirama.taille_lm()]=m7;
        my_Jirama.lm[my_Jirama.taille_lm()]=m8;
        my_Jirama.lm[my_Jirama.taille_lm()]=m9;
    
     my_Jirama.Couper(coup_ls1,new Date(13, 3, 2025, 5, 30, 0));
      my_Jirama.Retablir(retab_ls1,new Date(13, 3, 2025, 12, 0, 00));  
     

        my_Jirama.Couper(coup_ls2,new Date(13, 3, 2025, 13, 00, 0));
        my_Jirama.Retablir(retab_ls2,new Date(13, 3, 2025, 14, 0, 00));
        
      

       my_Jirama.Couper(coup_ls3,new Date(13, 3, 2025, 17, 00, 0));  
       my_Jirama.Retablir(retab_ls3,new Date(13, 3, 2025, 17, 15, 0));
       
   

       Stat st1=new Stat(s1,my_Jirama.lc);   
   Stat st2=new Stat(s2,my_Jirama.lc);
  Stat st3=new Stat(s3,my_Jirama.lc);

    st1.afficher();
    st2.afficher();
    st3.afficher(); 

    Stat[] lst=new Stat[4];
    lst[0]=st1;
    lst[1]=st2;
    lst[2]=st3;
    lst[3]=null;


  

      System.out.println("");
      Secteur d1=st1.min_max_sec(lst);
      Secteur d2=st2.min_min_sec(lst);
      Secteur d3=st1.min_moyenne_sec(lst);
  
      System.out.println("max:"+d1.nom);
      System.out.println("min:"+d2.nom);
      System.out.println("moyenne:"+d3.nom); 
  
    }
   
    
  
    
  
}