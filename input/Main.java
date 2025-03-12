public class Main{
    public static void main(String[] args){
      Point ex1=new Point(0, -2);
      Point ex2=new Point(2, -2);
      Point ex3=new Point(2, 0);
      Point ex4=new Point(0, 0);

      Point exA=new Point(0, 3);
      Point exB=new Point(0, 1);
      Point exC=new Point(4, 1);
      Point exD=new Point(4, 3);

      Point a=new Point(0, -1);
      Point b=new Point(1, 2);
      Point c=new Point(2, 1);
      Maison m1=new Maison();
      m1.position=a;
    //  System.out.println(m1.is_coupe);
      Maison m2=new Maison();
      m2.position=b;

      Maison m3=new Maison();
      m3.position=c;

      Secteur s=new Secteur();
      s.form[0]=ex1;
      s.form[1]=ex2;
      s.form[2]=ex3;
      s.form[3]=ex4;

      Secteur s1=new Secteur();
      s1.form[0]=exB;
      s1.form[1]=exA;
      s1.form[2]=exC;
      s1.form[3]=exD;

      Secteur[] ls=new Secteur[10];
      ls[0]=s;
      ls[1]=s1;

      Secteur[] ls1=new Secteur[10];
      ls1[0]=s1;
   //   System.out.println(a.equal(b)); 
      Jirama my_Jirama=new Jirama();
    
        my_Jirama.lm[my_Jirama.taille_lm()]=m1;
        my_Jirama.lm[my_Jirama.taille_lm()]=m2;
        my_Jirama.lm[my_Jirama.taille_lm()]=m3;
        
 //       System.out.println(my_Jirama.taille_lm());
    
      my_Jirama.Couper(ls,new Date(0, 0, 0, 0, 0, 0),2);
      my_Jirama.Retablir(ls,new Date(0, 0, 0, 0, 0, 0),2);

      System.out.println(m3.is_coupe);
      //my_Jirama.lc[2].afficher();
     // Point c=s1.min_p();
    
    }

}