package fr.utt.if26.lingvist;

import java.util.ArrayList;

/**
 * Created by wxw on 2018/1/12.
 */

public class Grammaire {
    private int id;
    private String titre;
    private String contenu;
    private ArrayList<Grammaire> grammaires;

    public Grammaire(int id, String titre, String contenu) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;

    }
    public Grammaire(){
        grammaires = new ArrayList<Grammaire>();
        initialiserGrammaires();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public ArrayList<Grammaire> getGrammaires() {
        return grammaires;
    }

    public void setGrammaires(Grammaire grammaire) {
        this.grammaires.add(grammaire);
    }

    public void initialiserGrammaires(){
        Grammaire g1 = new Grammaire(1, "Le pluriel", "En général, on forme le pluriel en ajoutant un -s au nom au singulier.");
        Grammaire g2 = new Grammaire(2, "Les adjectif", "On utilise les adjectifs de deux manières:\n" +
                "+ devant un nom (a nice girl)\n" +
                "+ avec le verbe \"be\" (This girl is nice)\n" +
                "Les adjectifs sont invariables en genre et en nombre.");
        grammaires.add(g1);
        grammaires.add(g2);
    }
}
