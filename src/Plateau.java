import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        for (int i = 0;i<this.nbColonnes;++i){
            List<CaseIntelligente> ligneDeCase = new ArrayList<>();
            for (int j = 0;j<this.nbLignes;++j){
                CaseIntelligente casi = new CaseIntelligente();
                ligneDeCase.add(casi);
            }
            this.cases.add(ligneDeCase);
        }
        this.rendLesCasesIntelligentes();
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
    public CaseIntelligente getCase(int colonne, int ligne) {
        return this.cases.get(colonne).get(ligne);
    }
    public int getNbCasesMarquees() {
        int cpt = 0;
        for(List<CaseIntelligente> colonneci:this.cases){
            for (CaseIntelligente lignci:colonneci){
                if (lignci.estMarquee()){
                    cpt+=1;
                }
            }
        }
        return cpt;
    }
    public void poseBombe(int colonne, int ligne) {
        this.cases.get(colonne).get(ligne).poseBombe();
    }
    private void creerLesCasesVides() {
        this.cases = new ArrayList<>();
        for (int i = 0;i<this.nbColonnes;++i){
            List<CaseIntelligente> ligneDeCase = new ArrayList<>();
            for (int j = 0;j<this.nbLignes;++j){
                ligneDeCase.add(new CaseIntelligente());
            }
            this.cases.add(ligneDeCase);
        }
    }
    private void rendLesCasesIntelligentes(){
        for (int i = 0;i<this.nbColonnes;i++){
            for (int j = 0;j<this.nbLignes;j++){
                System.out.println(i+" "+j);
                CaseIntelligente ci = this.getCase(i, j);
                for(int k=i-1;k<=i+1;k++){
                    for(int l=j-1;l<=j+1;l++){
                        System.out.println("kj"+k+" "+l);
                        if (k>=0 && l>=0 && !((k==i) && (l==j)) && k<this.getNbColonne() && l<this.getNbLigne()){
                            
                            System.out.println("kjbon"+k+" "+l);
                            System.out.println("i+k,J+l "+(i+k)+" " + (j+l));
                            System.out.println(this.getCase(i+k, j+l).toString());
                            ci.ajouteVoisine(new Case());
                            System.out.println("aled");
                            ci.ajouteVoisine(this.getCase((i+k), (j+l)));
                        }
                    }
                }
            }
        }
    }
    protected void poseDesBombesAleatoirement() {
        Random generateur = new Random();
        for (int x = 0; x < this.getNbLigne(); x++){
            for (int y = 0; y < this.getNbColonne(); y++){
                if (generateur.nextInt(100)+1 < this.pourcentageDeBombes){
                    this.poseBombe(x, y);
                    this.nbBombes = this.nbBombes + 1;
                }
            }
        }
    }
    public void reset() {
        for(int colonne = 0; colonne < this.getNbLigne(); ++colonne){
            for(int ligne = 0; ligne < this.getNbColonne(); ligne++){
                CaseIntelligente casei = this.getCase(colonne, ligne);
                casei.reset();
            }
        }
    }
    public int getNbCasesMarqueesContientBombe() {
        int cpt = 0;
        for(List<CaseIntelligente> colonneci:this.cases){
            for (CaseIntelligente lignci:colonneci){
                if (lignci.estMarquee() && lignci.contientUneBombe()){
                    cpt+=1;
                }
            }
        }
        return cpt;
    }
}
