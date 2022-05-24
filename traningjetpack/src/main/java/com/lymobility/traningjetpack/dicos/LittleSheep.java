package com.lymobility.traningjetpack.dicos;

import javax.inject.Inject;
import javax.inject.Named;

public class LittleSheep {
    String mutton = "没有肉";
    String vegetables = "没有菜";

    public LittleSheep(String mutton) {
        this.mutton = mutton;
    }

    public LittleSheep(String mutton, String vegetables) {
        this.mutton = mutton;
        this.vegetables = vegetables;
    }
    public String retrunCotent() {
        return "小肥羊火锅：" + mutton + " " + vegetables;
    }
}
