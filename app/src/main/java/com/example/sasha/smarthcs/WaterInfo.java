package com.example.sasha.smarthcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class WaterInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_info);
        int j = MainActivity.index;

       int Last =8855;
        int w = Last;
        double cost = MainActivity.water_resurse(w);
        int first = (int)(cost);
        int second = (int)((cost - first) * 100);
        String res = Integer.toString(first) + "." + (Integer.toString(second).length() == 1 ? "0" : "") + Integer.toString(second) + " м³";
        TextView resource = findViewById(R.id.resource_w);
        resource.setTextSize(27);
        resource.setText(res);
        TextView sum = findViewById(R.id.sum_w);
        sum.setTextSize(27);
        sum.setText(Integer.toString(Last) + " Рублей");
        RecyclerView bill_list = findViewById(R.id.bill_list);
        bill_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter4 adapter = new RecyclerViewAdapter4(getResources());
        bill_list.setAdapter(adapter);
    }
}
