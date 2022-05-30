package com.example.ecoleloustics;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HighTechItemAdapter extends BaseAdapter{
    
    private Context context;
    private List<HighTechItem> highTechItemList;
    //private LayoutInflater inflater;

    public HighTechItemAdapter(Context context, List<HighTechItem> highTechItemList) {
        this.context = context;
        this.highTechItemList = highTechItemList;
        //this.inflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return highTechItemList.size();
    }

    @Override
    public HighTechItem getItem(int position) {
        return highTechItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {



        view = LayoutInflater.from(context).inflate(R.layout.adapter_item, viewGroup, false);



        HighTechItem currentItem = getItem(i);
        String ItemName= currentItem.getName();
        int itemPrice = currentItem.getPrice();

        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(ItemName);

        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(String.format("%s",itemPrice));



        return view;
    }
}
