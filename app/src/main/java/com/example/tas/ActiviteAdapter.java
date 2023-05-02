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

    private List<Activite> la;
    private Context context;

    public ActiviteAdapter(List<Activite> la, Context context) {
        this.la = la;
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

        TextView n = view.findViewById(R.id.a_nom);
        TextView d = view.findViewById(R.id.a_description);

        Activite current =  (Activite) getItem(i);

        n.setText(current.getNom());
        d.setText(current.getDescription());

        return view;
    }
}
