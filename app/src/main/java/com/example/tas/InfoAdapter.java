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

public class InfoAdapter extends BaseAdapter {

    private List<Info> la;
    private Context context;

    public InfoAdapter(List<Info> la, Context context) {
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
            view = inflater.inflate(R.layout.info_item, null);
        }

        TextView nom = view.findViewById(R.id.i_nom);

        Info current = (Info) getItem(i);

        nom.setText(current.getNom());

        return view;
    }
}
