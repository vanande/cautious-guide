package com.example.tas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import java.util.List;

public class ActiviteAdapter extends BaseAdapter {

    private List<Activite> la;
    private Context context;

    public ActiviteAdapter(List<Activite> la, Context context) {
        this.la = la;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.la.size();
    }

    @Override
    public Object getItem(int i) {
        return this.la.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            view = inflater.inflate(R.layout.activite_item, null);
        }

        TextView nom = view.findViewById(R.id.a_nom);
        TextView desc = view.findViewById(R.id.a_description);
        ImageView img = view.findViewById(R.id.a_image);
        TextView heureDebut = view.findViewById(R.id.a_heureDebut);
        TextView heureFin = view.findViewById(R.id.a_heureFin);
        TextView dateDebut = view.findViewById(R.id.a_dateDebut);
        TextView dateFin = view.findViewById(R.id.a_dateFin);

        Activite current = (Activite) getItem(i);

        nom.setText(current.getNom());
        desc.setText(current.getDescription());
        //img.setImageDrawable(context.getResources().getDrawable(R.drawable.icone));
        Picasso.get().load(current.getImage()).into(img);

        return view;
    }
}
