import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private int nbLignes;
    private int nbColonnes;
    private int nombreBombe;
    private List<List<Case>> cases;

    public Plateau(int nbLignes,int nbColonnes){
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nombreBombe = 0;
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
    public void setNombreBombe(int nbBombe) {
        this.nombreBombe = nbBombe;
    }
    private int getNombreBombe() {
        return this.nombreBombe;
    }
    private int getNbDrapeauxRestants() {
        int nbDrapeauPlateau = 0;
        for (int i=0;i<this.getNbColonne();++i){
            for (int j=0;j<this.getNbLigne()){
                if(this.cases.get(i).get(j).estDrapeau()){
                    ++nbDrapeauPlateau;
                }
            }
        }
        return nbDrapeauPlateau - this.getNombreBombe();
    }
    private List<Case> casesAdjacent() {
        
        for (int i=0;i<this.getNbColonne();++i){
            for (int j=0;j<this.getNbLigne()){
                if (i+1<this.ge)
            }
        }
    }
    private int nbCases() {
        return this.nbColonnes*this.nbLignes;
    }
    private Case getCase(int ligne,int colonne) {
        return this.cases.get(colonne).get(ligne);
    }
}
