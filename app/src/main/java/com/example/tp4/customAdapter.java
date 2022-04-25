package com.example.tp4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class customAdapter extends ArrayAdapter {
    Context adaptercontext ;
    int adapterresource ;
     gares [] adaptergares;
    public customAdapter(Context context, int resource,  gares[] garesdata) {
        super(context, resource, garesdata);
        adaptercontext = context;
        adapterresource=resource;
        adaptergares= garesdata;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row ;
        LayoutInflater rowinflater= LayoutInflater.from(adaptercontext);
        row= rowinflater.inflate(adapterresource,parent,false);
        TextView garesjava=row.findViewById(R.id.gares);
        TextView placejava=row.findViewById(R.id.place);
        ImageView imgjava=row.findViewById(R.id.img);
        gares gare=adaptergares[position];
        garesjava.setText(gare.garesName);
        placejava.setText(gare.garespalce);
        int imgid =adaptercontext.getResources().getIdentifier(gare.gareslogo,"drawable",adaptercontext.getPackageName()) ;
        imgjava.setImageResource(imgid);
        return row;
}}
