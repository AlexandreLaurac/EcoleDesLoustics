package com.example.ecoleloustics.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ecoleloustics.Model.Utilisateur;

import com.example.ecoleloustics.R;

import java.util.List;

public class UtilisateurAdapter extends BaseAdapter{
    
    private Context context;
    private List<Utilisateur> utilisateurList;
    //private LayoutInflater inflater;

    public UtilisateurAdapter(Context context, List<Utilisateur> utilisateurList) {
        this.context = context;
        this.utilisateurList = utilisateurList;
        //this.inflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return utilisateurList.size();
    }

    @Override
    public Utilisateur getItem(int position) {
        return utilisateurList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {



        view = LayoutInflater.from(context).inflate(R.layout.adapter_item, viewGroup, false);



        Utilisateur currentItem = getItem(i);
        String itemNom= currentItem.getName();
        String itemPrenom = currentItem.getPrenom();

        TextView itemNomView = view.findViewById(R.id.item_name);
        itemNomView.setText(itemNom);

        TextView itemPrenomView = view.findViewById(R.id.item_price);
        itemPrenomView.setText(itemPrenom);



        return view;
    }
}
