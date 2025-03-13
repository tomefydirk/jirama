public class Main{
    public static void main(String[] args){
 
      Point a=new Point(0, -1);
      Point b=new Point(1, 2);
      Point c=new Point(2, 1);
      Maison m1=new Maison(null);
      m1.position=a;
    //  System.out.println(m1.is_coupe);
      Maison m2=new Maison(null);
      m2.position=b;

      Maison m3=new Maison(null);
      m3.position=c;

      Secteur s1=new Secteur("S1");
      s1.init_form(new Point(0, -2),new Point(2, -2),new Point(2, 0),new Point(0, 0));

      Secteur s2=new Secteur("S2");
      s2.init_form(new Point(0, 3),new Point(0, 1),new Point(4, 1),new Point(4, 3));
    

      Secteur[] ls=new Secteur[10];
      ls[0]=s1;
      ls[1]=s2;

      Secteur[] ls1=new Secteur[10];
      ls1[0]=s2;

      Jirama my_Jirama=new Jirama();
    
        my_Jirama.lm[my_Jirama.taille_lm()]=m1;
        my_Jirama.lm[my_Jirama.taille_lm()]=m2;
        my_Jirama.lm[my_Jirama.taille_lm()]=m3;
        

    
      my_Jirama.Couper(ls,new Date(1, 12, 2024, 1, 30, 0));
      my_Jirama.Retablir(ls,new Date(2, 12, 2024, 0, 0, 0));

      Date duree=new Date(1, 0, 0, 1, 30, 0).duree(new Date(2, 0, 0, 0, 0, 0));
      System.out.println(duree.into_string_h_m_s());
      System.out.println(m3.is_coupe);
      my_Jirama.lc[0].afficher();
   
    
    }

}