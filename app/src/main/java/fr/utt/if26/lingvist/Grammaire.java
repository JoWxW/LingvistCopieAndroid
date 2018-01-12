package fr.utt.if26.lingvist;

/**
 * Created by wxw on 2018/1/12.
 */

public class Grammaire {
    private int id;
    private String titre;
    private String contenu;

    public Grammaire(int id, String titre, String contenu) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
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
}
