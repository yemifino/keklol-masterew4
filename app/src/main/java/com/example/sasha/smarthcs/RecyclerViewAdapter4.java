package com.example.sasha.smarthcs;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.sasha.smarthcs.ProfileActivity.*;

public class RecyclerViewAdapter4 extends RecyclerView.Adapter<RecyclerViewAdapter4.ViewHolder> {

    interface OnResourceSelected {
        void onResourcesSelected(int pos);
    }

    Resources resources;

    public RecyclerViewAdapter4(Resources resources) {
        this.resources = resources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card2_layout,viewGroup,false));
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.name.setText("Дата : ");
        if (i<4){
        viewHolder.namet.setText( String.valueOf(cards3.get(i))+"."+MainActivity.year);}
        else { viewHolder.namet.setText( String.valueOf(cards3.get(i))+"."+MainActivity.year_pre);}
        viewHolder.cost.setText("Цена : ");
        String kek;
        String lol =ProfileActivity.Gas_cards.get(i);
        lol=ProfileActivity.removeChar(lol,0);
        lol=ProfileActivity.removeChar(lol,0);
        lol=ProfileActivity.removeChar(lol,0);
        lol=ProfileActivity.removeChar(lol,3);
        lol=ProfileActivity.removeChar(lol,3);
        lol=ProfileActivity.removeChar(lol,3);

        kek=lol;


        viewHolder.costt.setText(kek+" "+"Рублей");
    }

    @Override
    public int getItemCount() {
        return 6 ;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView cost;
        TextView namet;
        TextView costt;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            cost = view.findViewById(R.id.textView2);
            name = view.findViewById(R.id.name);
            namet = view.findViewById(R.id.cost);
            costt = view.findViewById(R.id.textView3);
        }
    }
}
