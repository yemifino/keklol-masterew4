package com.example.sasha.smarthcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class GazInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaz_info);
        int j = MainActivity.index;




        TextView resource = findViewById(R.id.resource_g);
        resource.setTextSize(27);
        resource.setText((String.valueOf((int)((Integer.valueOf(MainActivity.GSV.get(0))/MainActivity.gas_ideal))) +" " +"м³"));
        TextView sum = findViewById(R.id.sum_g);
        sum.setTextSize(27);
        sum.setText(MainActivity.GSV.get(0)+" "+"Рублей");
        RecyclerView bill_list = findViewById(R.id.bill_list);
        bill_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter2 adapter = new RecyclerViewAdapter2(getResources());
        bill_list.setAdapter(adapter);
    }
}
