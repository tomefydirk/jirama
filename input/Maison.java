package vivant;
import geo.*;
import jirama.*; 
public class Maison{
    private Personne[] qui_vive;
    private Point position;
    private boolean is_coupe ;
    private String nom;

    //impl --->#[constructor] {
    public Maison(String nom){
    this.qui_vive=new Personne[100];
 
    this.is_coupe=false;
    this.nom=nom;
    }
    // }

    // impl --->#[Debug] {
    public void afficher(){
        System.out.println(this.nom+" : "+this.is_coupe);
    }
    // }

    //impl --->#[get_field] {
    public Personne[] get_qui_vive(){
        return this.qui_vive;
    }
    public Point get_position(){
        return this.position;
    }
    public boolean get_is_coupe(){
        return this.is_coupe;
    }
    public String get_nom(){
        return this.nom;
    }
    // }

    //impl --->#[mut_field]{
    public void set_qui_vive(Personne[] autre){
        this.qui_vive=autre;
    }
    public void set_position(Point position){
        this.position=position;
    }
    public void set_is_coupe(boolean is_coupe){
        this.is_coupe=is_coupe;
    }
    public void set_nom(String nom){
        this.nom=nom;
    }
    //}

    //impl --> #[inserable] {
        public void insert_into(Maison[] ld){
            int i=0;
            while (true) {
                if(ld[i]==null){
                    break;
                }
                i++;
            }
            ld[i]=this;
        }
    
        public void replace_into(Maison[] ld,int index){
            ld[index]=this;
        }        
    // }
    public boolean coupable(){
        for(int i=0;this.get_qui_vive()[i]!=null;i++){
            if(!this.get_qui_vive()[i].coupable()){
                return false;
            }
        }
        return true;
    }
}

