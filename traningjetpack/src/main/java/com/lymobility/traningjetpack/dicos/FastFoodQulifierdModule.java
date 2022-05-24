package com.lymobility.traningjetpack.dicos;

import dagger.Module;
import dagger.Provides;

@Module
public class FastFoodQulifierdModule {

    @KFCType
    @Provides
    public FastFood providerKFC(){
        return new KFC();
    }

    @MacDonaldType
    @Provides
    public FastFood providerMacDonald(){
        return new MacDonald();
    }

}
