package collection; 
import geo.*;
import jirama.*;
import vivant.*; 

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