package com.lymobility.traningjetpack.dicos;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @ApplicationScope
    @Provides
    public NetworkClient providerNetworkClient(){
        return new NetworkClient();
    }
}
