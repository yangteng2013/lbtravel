package com.lymobility.traningjetpack.dicos;

import dagger.Module;
import dagger.Provides;

@Module
public class PizzaModule {

    @ApplicationScope
    @Provides
    public PizzaHut providerPizza(){
        return new PizzaHut();
    }

}
