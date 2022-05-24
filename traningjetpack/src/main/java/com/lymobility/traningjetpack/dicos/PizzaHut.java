package com.lymobility.traningjetpack.dicos;


/**
 * @author yangteng
 */
public class PizzaHut {
    String superSupremePizza;
    public PizzaHut() {
        superSupremePizza = "超级至尊披萨";
    }

    public String returnContent(){
        return "必胜客超级至尊套餐"+superSupremePizza;
    }
}
