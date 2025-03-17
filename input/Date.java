public class Date{
    int j;
    int m;
    int a;
    int h;
    int min;
    int s;

    Date(int j,int m,int a,int h,int min,int s){
        this.j=j;
        this.m=m;
        this.a=a;
        this.h=h;
        this.min=min;
        this.s=s;
    }
    int  into_sec(){
        return this.j*86400+3600*this.h+60*this.min+this.s;
    }
    Date from_sec(int total_sec){
       int  j = total_sec / (24 * 3600);
        total_sec %= (24 * 3600); 

       int  h = total_sec / 3600;
        total_sec %= 3600; 

      int   min = total_sec / 60;
        total_sec %= 60;

      int   s = total_sec;
      return new Date(j, 0,0, h, min, s);
    }
    Date duree(Date limit){
        int diff=limit.into_sec()-this.into_sec();
        return from_sec(diff);
    }

    // impl --->#[Debug]
    String into_string(){
        return "Jour: "+this.j+" / m:"+this.m+" / a: "+this.a+"  "+" "+this.h +"h-"+this.min+"m-"+this.s+"s";
    }
    String into_string_h_m_s(){
        return this.h +"h-"+this.min+"m-"+this.s+"s";
    }
    void afficher(){
        System.out.println(this.into_string());
    }
    void afficher_h_m_s(){
        System.out.println(this.into_string_h_m_s());
    }
}