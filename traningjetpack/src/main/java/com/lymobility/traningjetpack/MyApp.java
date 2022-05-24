package com.lymobility.traningjetpack;

import android.app.Application;
import android.content.Context;

import com.lymobility.traningjetpack.dicos.DaggerNetworkComponent;
import com.lymobility.traningjetpack.dicos.DaggerPizzaComponent;
import com.lymobility.traningjetpack.dicos.DicosComponent;
import com.lymobility.traningjetpack.dicos.NetworkComponent;
import com.lymobility.traningjetpack.dicos.NetworkModule;

/**
 * @author yangteng
 */
public class MyApp extends Application {


    NetworkComponent networkComponent;


    @Override
    public void onCreate() {
        super.onCreate();

//        dicosComponent = DaggerDicosComponent.builder()
//                .dicosModule(new DicosModule()).build();
//        activityComponent = DaggerActivityComponent.builder().pizzaHutComponent(DaggerPizzaHutComponent.builder().build()).build();
        networkComponent = DaggerNetworkComponent.builder()
                .pizzaComponent(DaggerPizzaComponent.builder().build())
                .build();
    }

    public static MyApp getApp(Context context){
        return (MyApp) context.getApplicationContext();
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }
}
