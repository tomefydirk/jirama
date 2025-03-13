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
    String into_string(){
        return this.j+"/"+this.m+"/"+this.a+"  "+" "+this.h +"h-"+this.min+"m-"+this.s+"s";
    }
    void afficher(){
        System.out.println(this.into_string());
    }
}