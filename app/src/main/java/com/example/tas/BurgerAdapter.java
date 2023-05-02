package com.example.tas;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BurgerAdapter extends BaseAdapter {

    private List<Burger> lburgers;
    private Context context;

    public BurgerAdapter(List<Burger> lburgers, Context context) {
        this.lburgers = lburgers;
        this.context = context;
    }



    @Override
    public int getCount() {
        return this.lburgers.size();
    }

    @Override
    public Object getItem(int i) {
        return this.lburgers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.burger_item, null);
        }

        TextView nom = view.findViewById(R.id.tv_nom_burger);
        TextView ingr = view.findViewById(R.id.tv_ingredients_burger);

        Burger current = (Burger) getItem(i);

        nom.setText(current.getNom());
        ingr.setText(current.getIngredients());

        return view;
    }
}
