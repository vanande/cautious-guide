package com.example.tas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ActiviteAdapter extends BaseAdapter {
    private List<Activite> activites;
    private Context context;


    public ActiviteAdapter(List<Activite> activites, Context context) {
        this.activites = activites;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.activite_item, null);
        }

        TextView nom = view.findViewById(R.id.nom_activite);
        TextView t = view.findViewById(R.id.type_activite);
        TextView d = view.findViewById(R.id.description_activite);


        Activite current =  (Activite) getItem(i);

        nom.setText(current.getNom());
        t.setText(current.getType());
        d.setText(current.getDescription());

        return view;
    }
}
