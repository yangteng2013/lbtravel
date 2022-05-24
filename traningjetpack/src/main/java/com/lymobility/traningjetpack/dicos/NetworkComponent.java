package com.lymobility.traningjetpack.dicos;

import com.lymobility.traningjetpack.SecondActivity;
import com.lymobility.traningjetpack.TranJetPackMainActivity;

import dagger.Component;

@Component(modules = NetworkModule.class,dependencies = PizzaComponent.class)
public interface NetworkComponent {

    void inject(TranJetPackMainActivity activity);
    void inject(SecondActivity activity);
}
