/**
 * Case
 */
public class Case {
    private boolean revele;
    private boolean drapeau;
    private boolean bombe;
    /** Permet de crée un nouvelle Case */
    public Case(){
        this.revele = false;
        this.drapeau = false;
        this.bombe = false;
    }
    /**
     * Permet de savoir si une case est revele
     * @return boolean : true si la case est revele, sinon false
     */
    public boolean estReveler() {
        return this.revele;
    }
    /** Permet de changer l'état de la case, la reveler si elle est cacher et inversement */
    public void setReveler(){
        if (this.estReveler()){this.revele = false;}
        else{this.revele = true;}
    }
    public boolean estDrapeau() {
        return this.drapeau;
    }
    public void setDrapeau() {
        if (this.estDrapeau()){this.drapeau = false;}
        else{this.drapeau = true;}
    }
    public boolean estBombe() {
        return this.bombe;
    }
    public void setBombe() {
        if (this.estBombe()){this.bombe = false;}
        else{this.bombe = true;}
    }
}