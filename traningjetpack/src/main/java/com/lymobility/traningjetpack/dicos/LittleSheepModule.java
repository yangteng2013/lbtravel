package com.lymobility.traningjetpack.dicos;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class LittleSheepModule {

    @Named("mutton")
    @Provides
    public LittleSheep getLittleSheepMutton(){
        return new LittleSheep("三十盘羊肉吃到吐");
    }

    @Named("all")
    @Provides
    public LittleSheep getLittleSheepAll(){
        return new LittleSheep("十盘羊肉","十盘蔬菜");
    }

}
