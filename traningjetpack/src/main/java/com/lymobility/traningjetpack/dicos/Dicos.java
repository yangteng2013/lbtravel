package com.lymobility.traningjetpack.dicos;


public class Dicos {

    private String friedDrumsticks;

    public Dicos() {
        this.friedDrumsticks="脆皮金枪腿";
    }

    public Dicos(String friedDrumsticks) {
        this.friedDrumsticks = friedDrumsticks;
    }
    public String returnDicos(){
        return "德克士:"+friedDrumsticks;
    }
}
