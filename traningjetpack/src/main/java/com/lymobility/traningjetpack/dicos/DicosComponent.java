package com.lymobility.traningjetpack.dicos;

import com.lymobility.traningjetpack.SecondActivity;
import com.lymobility.traningjetpack.TranJetPackMainActivity;


import dagger.Component;

/**
 * @author yangteng
 */
@ApplicationScope
@Component(modules = {DicosModule.class,LittleSheepModule.class,FastFoodQulifierdModule.class},dependencies = {PizzaComponent.class})
public interface DicosComponent {
    void inject(TranJetPackMainActivity activity);
    void inject(SecondActivity activity);
}
