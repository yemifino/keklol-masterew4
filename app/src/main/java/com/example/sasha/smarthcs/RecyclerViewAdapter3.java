package com.example.sasha.smarthcs;

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

public class RecyclerViewAdapter3 extends RecyclerView.Adapter<RecyclerViewAdapter3.ViewHolder> {

    interface OnResourceSelected {
        void onResourcesSelected(int pos);
    }

    Resources resources;

    public RecyclerViewAdapter3(Resources resources) {
        this.resources = resources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card2_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.name.setText("Дата : ");
        viewHolder.namet.setText( ProfileActivity.cards3.get(i)+"."+MainActivity.year);
        viewHolder.cost.setText("Цена : ");
        viewHolder.costt.setText((CharSequence) ProfileActivity.Light_cards.get(0));
    }

    @Override
    public int getItemCount() {
        return ProfileActivity.Light_cards.size();
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
