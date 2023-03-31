import java.util.List;

public class CaseIntelligente extends Case{
    public List<Case> lesVoisines;

    public CaseIntelligente(){
        super();
    }
    public void ajouteVoisine(Case uneCase) {
        System.out.println(this.lesVoisines);
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
        if (this.contientUneBombe()){
            return "@";
        }
        if (!this.estMarquee() && !this.estDecouverte()){
            return " ";
        }
        int cpt = this.nombreBombesVoisines();
        return ""+cpt;
        
    }
}
