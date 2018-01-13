package fr.utt.if26.lingvist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxw on 2018/1/13.
 */

public class GrammairesSer implements Serializable {
    private ArrayList<Grammaire> grammaires;
    public GrammairesSer(List<Grammaire> gs){
        this.grammaires.addAll(gs);
    }

    public ArrayList<Grammaire> getGrammaires() {
        return grammaires;
    }
}
