import java.util.Scanner;

public class Demineur extends Plateau{
    private boolean gameOver;
    private boolean gameWin;
    private int score;

    public Demineur(int nbLignes,int nbColonnes,int pourcentage) {
        super(nbLignes, nbColonnes, pourcentage);
        this.gameOver=false;
        this.score = 0;
    }
    public int getScore() {
        return this.score;
    }
    public void reveler(int colonne,int ligne){
        CaseIntelligente casei = getCase(colonne, ligne);
        casei.reveler();
        if (casei.contientUneBombe()){
            this.gameOver=true;
        }
        this.score+=1;
    }
    public void marquer(int colonne, int ligne) {
        CaseIntelligente casei = getCase(colonne, ligne);
        casei.marquer();
    }
    public boolean estGagnee() {
        return this.getNbTotalBombes()==this.nbdeCaseRestantes();
    }
    public boolean estPerdu(){
        return this.gameOver;
    }
    @Override
    public void reset() {
        super.reset();
        this.gameOver = false;
        this.score = 0;
    }
    public void affiche(){
        System.out.println("JEU DU DEMINEUR");
        // affichage de la bordure supérieure
        System.out.print("  ");
        for (int j=0; j<this.getNbColonne(); j++){
            System.out.print("  "+j+" ");
        }
        System.out.print(" \n");
        
        // affichage des numéros de ligne + cases
        System.out.print("  ┌");
        for (int j=0; j<this.getNbColonne()-1; j++){
                System.out.print("───┬");
        }
        System.out.println("───┐");
        
        // affichage des numéros de ligne + cases
        for (int i = 0; i<this.getNbLigne(); i++){
            System.out.print(i+" ");
            for (int j=0; j<this.getNbColonne(); j++){
                System.out.print("│ "+this.getCase(i, j).toString() + " ");
            }
            System.out.print("│\n");
            
            if (i!=this.getNbLigne()-1){
                // ligne milieu
                System.out.print("  ├");
                for (int j=0; j<this.getNbColonne()-1; j++){
                        System.out.print("───┼");
                }
                System.out.println("───┤");
            }
        }
        // affichage de la bordure inférieure
        System.out.print("  └");
        for (int j=0; j<this.getNbColonne()-1; j++){
                System.out.print("───┴");
        }
        System.out.println("───┘");
        
        // affichage des infos 
        System.out.println("Nombres de bombes à trouver : " + this.getNbTotalBombes());
        System.out.println("Nombres de cases marquées : " + this.getNbCasesMarquees());
        System.out.println("Score : " + this.getScore());
    }
    public void nouvellePartie() {
        this.reset();
        this.poseDesBombesAleatoirement();
        this.affiche();
        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        while (!this.estPerdu() || this.estGagnee()){
            System.out.println("Entrer une instruction de la forme R 3 2 ou M 3 2\npour Révéler/Marquer la case à la ligne 3 et à la colonne 2");
            String[] s = scan.nextLine().split(" ");
            String action = s[0];
            int x = Integer.valueOf(s[1]);
            int y = Integer.valueOf(s[2]);
            if (action.equals("M") || action.equals("m"))
                this.marquer(x, y);
            else if (action.equals("R") || action.equals("r"))
                this.reveler(x, y);
            this.affiche();
        }
        if (this.gameOver){
            System.out.println("Oh !!! Vous avez perdu !");
        }
        else{
            System.out.println("Bravo !! Vous avez gagné !");
        }
    }
}
