package com.lymobility.traningjetpack;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView tvSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        MyApp.getApp(this).getNetworkComponent().inject(this);
//        DaggerDicosComponent.builder().dicosModule(new DicosModule()).build().inject(this);
//        TextView tvSecond = findViewById(R.id.tv_second);

//        String msg = ""+dicos.hashCode();
//        Log.d("SecondA",msg);
    }
}