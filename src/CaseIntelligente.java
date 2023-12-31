import java.util.ArrayList;
import java.util.List;

public class CaseIntelligente extends Case{
    public List<Case> lesVoisines;

    public CaseIntelligente(){
        super();
        this.lesVoisines = new ArrayList<>();
    }
    public void ajouteVoisine(Case uneCase) {
        this.lesVoisines.add(uneCase);
    }
    private int nombreBombesVoisines() {
        int cpt = 0;
        for (Case c:this.lesVoisines){
            if (c.contientUneBombe()){
                ++cpt;
            }
        }
        return cpt;
    }
    @Override
    public String toString() {
        if (this.estMarquee()){
            return "?";
        }
        if (!this.estMarquee() && !this.estDecouverte()){
            return " ";
        }
        if (this.contientUneBombe() && this.estDecouverte()) {
            return "@";
        }
        int cpt = this.nombreBombesVoisines();
        return ""+cpt;
        
    }
}
