package collection; 
import geo.*;


public class My_hashmap{
     private int duration;
     private Secteur s;
    //impl --->#[constructor]{
    public My_hashmap(int duration,Secteur s){
        this.duration=duration;
        this.s=s;
    }
    // }
    public void insert_into_VHash(My_hashmap[] tab){
        int i=0;
        while (true) {
            if(tab[i]==null){
                break;
            }
            i++;
        }
        tab[i]=this;
     }
    public My_hashmap min_tabVHash(My_hashmap [] tab){
        My_hashmap min=tab[0];
        if(tab==null){
            System.out.println("tab est vide { class:Stat && function:min_tab }");
        }
        for(int i=0;tab[i]!=null;i++){
            if(min.get_duration()>=tab[i].get_duration()){
                min=tab[i];
            }
        }
        return min;
     }
     //impl --->#[get_field]{
    public int get_duration(){
        return this.duration;
    }
    public Secteur get_s(){
          return this.s;
    }
     // }

    //impl --->#[mut_field]{
    public void set_duration(int duration){
        this.duration=duration;
    }
    public void set_s(Secteur s){
        this.s=s;
    }
    // }
}