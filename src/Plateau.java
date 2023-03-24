import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;
    private int pourcentageDeBombes;
    private List<List<CaseIntelligente>> cases;

    public Plateau(int nbLignes,int nbColonnes,int pourcentage){
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.pourcentageDeBombes = pourcentage;
        this.nbBombes = 0;
        this.cases = new ArrayList<>();
        for (int i = 0;i<nbColonnes;++i){
            List<Case> ligneDeCase = new ArrayList<>();
            for (int j = 0;i<nbLignes;++j){
                ligneDeCase.add(new Case());
            }
            this.cases.add(ligneDeCase);
        }
    }

    public int getNbLigne() {
        return this.nbLignes;
    }
    public int getNbColonne() {
        return this.nbColonnes;
    }
    public int getNbTotalBombes() {
        return this.nbBombes;
    }
    public int nbCases() {
        return this.nbColonnes*this.nbLignes;
    }
    public CaseIntelligente getCase(int ligne,int colonne) {
        return this.cases.get(colonne).get(ligne);
    }
    //
    public int getNbCasesMarquees() {
        return 1;
    }
    public void poseBombe(int colonne, int ligne) {
        this.cases.get(colonne).get(ligne).poseBombe();
    }
    private void creerLesCasesVides() {
        
    }
    private void rendLesCasesIntellignetes(){
        
    }
    protected void poseDesBombesAleatoirement() {
        
    }
    public void reset() {
        
    }
}
