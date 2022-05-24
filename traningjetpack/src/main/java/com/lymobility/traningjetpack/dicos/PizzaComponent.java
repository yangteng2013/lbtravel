package com.lymobility.traningjetpack.dicos;

import com.lymobility.traningjetpack.SecondActivity;
import com.lymobility.traningjetpack.TranJetPackMainActivity;

import dagger.Component;

/**
 * @author yangteng
 */
@Component(modules = PizzaModule.class)
public interface PizzaComponent {
    void injectTrain(TranJetPackMainActivity activity);
    void injectSecond(SecondActivity activity);
}
