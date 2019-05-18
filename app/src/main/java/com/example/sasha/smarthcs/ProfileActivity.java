package com.example.sasha.smarthcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.nio.channels.SelectionKey;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;
import ru.yandex.money.android.sdk.Amount;
import ru.yandex.money.android.sdk.Checkout;
import ru.yandex.money.android.sdk.Configuration;
import ru.yandex.money.android.sdk.PaymentMethodType;
import ru.yandex.money.android.sdk.ShopParameters;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static java.security.AccessController.getContext;

public class ProfileActivity extends AppCompatActivity {
    static ArrayList<Dat> Dat_cards = new ArrayList<>();
    public String gas="gas";
    static ArrayList<Integer> cards3 = new ArrayList<>();
    private static final String LOCAL = "http://192.168.1.8:5000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView login = findViewById(R.id.textlogin);
        cards3.add(0,4);
        cards3.add(1,3);
        cards3.add(2,2);
        cards3.add(3,1);
        cards3.add(4,12);
        cards3.add(5,11);


        openProfile();
        /*Retrofit retrofit = new Retrofit.Builder() .baseUrl(LOCAL) .addConverterFactory(GsonConverterFactory.create()) .build();
        API api = retrofit.create(API.class);
        Call<Reply> call = api.getFullResources(new Request(MainActivity.LOGIN),"gas");
        // TODO add rand() (or make good input)
        call.enqueue(new Callback<Reply>() {
            @Override
            public void onResponse(Call<Reply> call, Response<Reply> response) {
                if (MainActivity.cards2.get(0).now.sum_g == 0) for (int i = 0; i < 30; i++) MainActivity.cards2.get(i).now.sum_g += Integer.valueOf(response.body().reply);
            }

            @Override
            public void onFailure(Call<Reply> call, Throwable t) {

            }
        });
        Call<Reply> call2 = api.getFullResources(new Request(MainActivity.LOGIN),"light");
        call2.enqueue(new Callback<Reply>() {
            @Override
            public void onResponse(Call<Reply> call, Response<Reply> response) {
                if (MainActivity.cards2.get(0).now.sum_l == 0) for (int i = 0; i < 30; i++) MainActivity.cards2.get(i).now.sum_l += Integer.valueOf(response.body().reply);
            }

            @Override
            public void onFailure(Call<Reply> call, Throwable t) {

            }
        });
        Call<Reply> call3 = api.getFullResources(new Request(MainActivity.LOGIN),"water");
        call3.enqueue(new Callback<Reply>() {
            @Override
            public void onResponse(Call<Reply> call, Response<Reply> response) {
                if (MainActivity.cards2.get(0).now.sum_w == 0) for (int i = 0; i < 30; i++) MainActivity.cards2.get(i).now.sum_w += Integer.valueOf(response.body().reply);
            }

            @Override
            public void onFailure(Call<Reply> call, Throwable t) {

            }
        });*/
        RecyclerView bill_list = findViewById(R.id.biil_list);
        bill_list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getResources(), new RecyclerViewAdapter.OnResourceSelected() {
            @Override
            public void onResourcesSelected(int pos) {
                if(pos == 0) {
                    startWaterInfo();
                }
                else if(pos == 1) {
                    startGazInfo();
                }
                else if(pos == 2) {
                    startLightInfo();
                }
                else if(pos == 3) {
                    startTotalInfo();
                }
            }
        });

        bill_list.setAdapter(adapter);
        Checkout.attach(getSupportFragmentManager());}
    void openProfile() {
        Retrofit retrofit = new Retrofit.Builder() .baseUrl(LOCAL) .addConverterFactory(GsonConverterFactory.create()) .build();
        final API api = retrofit.create(API.class);
      Call<ResursePOL> call =api.getFullResources(new PostData(MainActivity.LOGIN), "light" );
        call.enqueue(new Callback<ResursePOL>() {
            @Override
            public void onResponse(@NotNull Call<ResursePOL> call, @NotNull Response<ResursePOL> response) {
                ResursePOL res =response.body();
 //ArrayList<String> arrayList=new ArrayList<>();
// arrayList.add("8709");
// arrayList.add("5450");
// arrayList.add("3736");
                assert response.body() != null;
                List<String> arrayList = response.body().getArray();
               Dat_cards.add(0,new Dat(arrayList.get(0)));
               Dat_cards.add(1,new Dat(arrayList.get(1)));
               Dat_cards.add(2,new Dat(arrayList.get(2)));
               Dat_cards.add(3,new Dat(arrayList.get(3)));
               Dat_cards.add(4,new Dat(arrayList.get(4)));
               Dat_cards.add(5,new Dat(arrayList.get(5)));
               Dat_cards.add(6,new Dat(arrayList.get(6)));
               Dat_cards.add(7,new Dat(arrayList.get(7)));


            }
            @Override
            public void onFailure(Call<ResursePOL> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Checkout.detach();
    }

    public void buy(View view)
    {
        Toast.makeText(getApplicationContext(), "Оплата...", Toast.LENGTH_LONG).show();
        timeToStartCheckout();
    }

    void timeToStartCheckout() {

        Checkout.configureTestMode(
                new Configuration(
                        true,
                        true,
                        true,
                        1,
                        true,
                        true
                )
        );
        int sum = 0;
        Checkout.tokenize(
                this,
                new Amount(new BigDecimal(Integer.toString(sum)), Currency.getInstance("RUB")),
                new ShopParameters(
                        "Умный ЖКХ",
                        "Оплата ЖКХ",
                        "47",
                        Collections.singleton(PaymentMethodType.BANK_CARD)
                )
        );
    }

    private void startWaterInfo() {
        Intent intent = new Intent(this,WaterInfo.class);
        startActivity(intent);
    }

    private void startLightInfo() {
        Intent intent = new Intent(this, LightInfo.class);
        startActivity(intent);
    }

    private void startGazInfo() {
        Intent intent = new Intent(this, GazInfo.class);
        startActivity(intent);
    }

    private void startTotalInfo() {
        Intent intent = new Intent(this, TotalInfo.class);
        startActivity(intent);
    }

    public void exit(View view)
    {
        Toast.makeText(getApplicationContext(), "Выход...", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
