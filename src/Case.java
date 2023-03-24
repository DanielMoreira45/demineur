/**
 * Case
 */
public class Case {
    private boolean estDecouverte;
    private boolean estMarquee;
    private boolean contientUneBombe;
    /** Permet de crée un nouvelle Case */
    public Case(){
        this.estMarquee = false;
        this.estDecouverte = false;
        this.contientUneBombe = false;
    }
    public boolean estDecouverte() {
        return this.estDecouverte;
    }
    public boolean contientUneBombe() {
        return this.contientUneBombe;
    }
    public void poseBombe() {
        this.contientUneBombe = true;
    }
    public void reset() {
        this.estDecouverte = false;
        this.estMarquee = false;
        this.contientUneBombe = false;
    }
    public boolean estMarquee() {
        return this.estMarquee;
    }
    public void marquer(){
        if (this.estMarquee()){this.estMarquee = false;}
        else{this.estMarquee = true;}
    }
    public boolean reveler() {
        if (this.estDecouverte){return false;}
        else{
            if (this.estMarquee){return false;}
            else{
                this.estDecouverte = true;
                return true;
            }
        }
    }
}