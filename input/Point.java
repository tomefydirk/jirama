public class Point{
    double  x;
    double y;

    Point(double x,double y){
        this.x=x;
        this.y=y;
        
      }
    boolean appartient_sec(Point born_inf,Point born_sup){
        return this.x>=born_inf.x && this.x<=born_sup.x && this.y>=born_inf.y && this.y<=born_sup.y;
        
    }
    double fabs(double nb){
        if(nb>=0){
            return nb;
        }else{
            return -nb;
        }
    }
    boolean equal(Point autre){
       return fabs(autre.x-this.x)<0.00001 && fabs(autre.y-this.y)<0.00001;
        
    }

     // impl --->#[Debug]
    String into_string(){
        return "{ x: "+this.x+" ; y: "+this.y+" }";
    }
    void afficher(){
        System.out.println(this.into_string());
    }
      
}
