package affichage;
import geo.*;
import jirama.*;
import vivant.*; 

public class Main{
    public static void main(String[] args){
 /*----Maison----------*/
      Maison m1=new Maison("m1");
      m1.set_position(new Point(1, 1));

      Maison m2=new Maison("m2");
      m2.set_position(new Point(1, 2));

      Maison m3=new Maison("m3");
      m3.set_position(new Point(1, 3));

      Maison m4=new Maison("m4");
      m4.set_position(new Point(1, 6));

      Maison m5=new Maison("m5");
      m5.set_position(new Point(1, 7));

      Maison m6=new Maison("m6");
      m6.set_position(new Point(1, 8));

      Maison m7=new Maison("m7");
      m7.set_position(new Point(6, 1));

      Maison m8=new Maison("m8");
      m8.set_position(new Point(6, 2));

      Maison m9=new Maison("m9");
      m9.set_position(new Point(6, 3));

      
      Secteur s1=new Secteur("S1");
      s1.init_form(new Point(0, 0),new Point(0, 5),new Point(5, 5),new Point(5, 0));

      Secteur s2=new Secteur("S2");
      s2.init_form(new Point(5, 0),new Point(5, 5),new Point(10, 5),new Point(10, 0));
    
      Secteur s3=new Secteur("S3");
      s3.init_form(new Point(0, 5),new Point(0, 10),new Point(8, 10),new Point(8, 5));

      Secteur[] C1=new Secteur[10];
      s1.insert_into(C1);
      s2.insert_into(C1);
      s3.insert_into(C1);

      Secteur[] C2=new Secteur[10];
      s3.insert_into(C2);

      Secteur[] C3=new Secteur[10];
      s1.insert_into(C3);
      s3.insert_into(C3);

        Secteur[] R1=new Secteur[10];
      s2.insert_into(R1);
      s3.insert_into(R1);


      Secteur[] R2=new Secteur[10];
      s3.insert_into(R2);
      s1.insert_into(R2);


      Secteur[] R3=new Secteur[10];
      s1.insert_into(R3);
      s3.insert_into(R3);


     
      Jirama my_Jirama=new Jirama();
      my_Jirama.push_lm(m1);
      my_Jirama.push_lm(m2);
      my_Jirama.push_lm(m3);
      my_Jirama.push_lm(m4);
      my_Jirama.push_lm(m5);
      my_Jirama.push_lm(m6);
      my_Jirama.push_lm(m7);
      my_Jirama.push_lm(m8);
      my_Jirama.push_lm(m9);

    my_Jirama.set_pays(new Pays("Mada"));
    my_Jirama.get_pays().init_form(new Point(0, 100),new Point(100, 0),new Point(100, 100),new Point(0, 0));

       my_Jirama.Couper(C1,new Date(13, 3, 2025, 5, 30, 0));
     //my_Jirama.Retablir(R1,new Date(13, 3, 2025, 12, 0, 00));  
     

        my_Jirama.Couper(C2,new Date(13, 3, 2025, 13, 00, 0));
     //  my_Jirama.Retablir(R2,new Date(13, 3, 2025, 14, 0, 00));
        
      

       my_Jirama.Couper(C3,new Date(13, 3, 2025, 17, 00, 0));  
//       my_Jirama.Retablir(R3,new Date(13, 3, 2025, 17, 15, 0));

      //  my_Jirama.afficher_lc();
        Stat st1=new Stat(s1,my_Jirama.get_lc());   
       Stat st2=new Stat(s2,my_Jirama.get_lc());
       Stat st3=new Stat(s3,my_Jirama.get_lc());

       st1.afficher();
       st2.afficher();
       st3.afficher();
      Stat[] LST=new Stat[10];
      st1.insert_into(LST);
      st2.insert_into(LST);
      st3.insert_into(LST);


    
      st1.afficher_min_stat(LST);
       my_Jirama.afficher_lc();
      /*-----------debug---------*/
      Point[] test_insert_into=new Point [4];
      (new Point(1,2)).insert_into(test_insert_into);
       (new Point(0,2)).insert_into(test_insert_into);
        (new Point(1,3)).insert_into(test_insert_into);
        for(int i=0;test_insert_into[i]!=null;i++){
            test_insert_into[i].afficher();
        }
       my_Jirama.get_pays().afficher(); 
 } 
}