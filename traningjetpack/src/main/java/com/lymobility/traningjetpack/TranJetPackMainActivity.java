package com.lymobility.traningjetpack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TranJetPackMainActivity extends AppCompatActivity {

    TextView tvTrain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran_jet_pack_main);
        tvTrain = findViewById(R.id.tv_traning);

        MyApp.getApp(this)
                .getNetworkComponent().inject(this);
//        DaggerDicosComponent.builder().dicosModule(new DicosModule()).build().inject(this);
//        DaggerDicosComponent.builder()
//                .littleSheepModule(new LittleSheepModule())
//                .fastFoodQulifierdModule(new FastFoodQulifierdModule())
//                .build().inject(this);

//        tvTrain.setText(dicos.returnDicos()+" \n "+littleSheep.retrunCotent() + " \n "+littleSheepAll.retrunCotent()
//                + " \n "+kfc.returnContent()
//                + " \n "+macdonald.returnContent());

//        tvTrain.setText(dicos.hashCode()+" \n "+dicos2.hashCode());
    }

    public void onClick(View view) {
        startActivity(new Intent(this,SecondActivity.class));
    }
}