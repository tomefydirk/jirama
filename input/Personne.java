package vivant;
import geo.*;
public class Personne{
    private Point position;
    //impl --->#[constructor]{
    public Personne(Point position){
        this.position=position;
    }
    // }

    //impl ---> #[get_field] {
    public Point get_position(){
        return this.position;
    }
    // }

    //impl ---> #[mut_field] {
     public void set_position(Point position){
        this.position=position;
    }
    // }

    //impl --> #[inserable] {
        public void insert_into(Personne[] ld){
            int i=0;
            while (true) {
                if(ld[i]==null){
                    break;
                }
                i++;
            }
            ld[i]=this;
        }
    
        public void replace_into(Personne[] ld,int index){
            ld[index]=this;
        } 
    // }
}