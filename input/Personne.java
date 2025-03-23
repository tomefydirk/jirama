package vivant;
import geo.*;
public class Personne{
    private Point position;
    private boolean is_mpiasa_jirama;
    private Personne mere;
    private Personne pere;
    //impl --->#[constructor]{
    public Personne(Point position,boolean is_mpiasa_jirama){
        this.position=position;
        this.mere=mere;
        this.pere=pere;
        this.is_mpiasa_jirama=is_mpiasa_jirama;
    }
    // }

    //impl ---> #[get_field] {
    public Point get_position(){
        return this.position;
    }
    public Personne get_mere(){
        return this.mere;
    }
     public Personne get_pere(){
        return this.pere;
    }
      public boolean get_is_mpiasa_jirama(){
        return this.is_mpiasa_jirama;
    }
    // }

    //impl ---> #[mut_field] {
     public void set_position(Point position){
        this.position=position;
    }
     public void set_pere(Personne pere){
        this.pere=pere;
    }
     public void set_mere(Personne mere){
        this.mere=mere;
    }
     public void set_is_mpiasa_jirama(boolean is_mpiasa_jirama){
        this.is_mpiasa_jirama=is_mpiasa_jirama;
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
    public boolean coupable(){
        if(this.is_mpiasa_jirama){
            return false;
        }
        if(this.pere!=null){
            if(pere.is_mpiasa_jirama){
                return false;
            }
        }
        if(this.mere!=null){
             if(mere.is_mpiasa_jirama){
                return false;
            }
        }
        return true;
    }
}