package com.lymobility.traningjetpack.dicos;


import dagger.Module;
import dagger.Provides;

@Module
public class DicosModule {

    @ApplicationScope
    @Provides
    public Dicos getDicos(){
        return new Dicos();
    }
}
