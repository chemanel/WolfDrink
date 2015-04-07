package com.chema.jack.wolfdrink;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;


public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<CDrink> barList = null;
    private ArrayList<CDrink> arraylist;

    public ListViewAdapter(Context context,
                           List<CDrink> worldpopulationlist) {
        mContext = context;
        this.barList = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<CDrink>();
        this.arraylist.addAll(worldpopulationlist);
    }

    public class ViewHolder {
        TextView name;
        TextView description;
        TextView latitude;
        TextView longitude;
        ImageView picBar;

    }

    @Override
    public int getCount() {
        return barList.size();
    }

    @Override
    public CDrink getItem(int position) {
        return barList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);

            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            holder.description = (TextView) view.findViewById(R.id.description);
            holder.latitude = (TextView) view.findViewById(R.id.precio);
            holder.longitude = (TextView) view.findViewById(R.id.longitude);
            holder.picBar = (ImageView) view.findViewById(R.id.imgBar);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(barList.get(position).getName());
        holder.description.setText(barList.get(position).getDescription());
        holder.latitude.setText(barList.get(position).getPrecio());
        holder.picBar.setImageDrawable(
                Drawable.createFromStream(
                    new ByteArrayInputStream(barList.get(position).getImage()),
                    barList.get(position).getName()
                ));

        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, CCerveza.class);
                // Pass all data rank
                intent.putExtra("name",(barList.get(position).getName()));
                // Pass all data country
                intent.putExtra("description", (barList.get(position).getDescription()));
                // Pass all data population
                //intent.putExtra("latitude", (barList.get(position).getLatitude()));
                //intent.putExtra("longitude", (barList.get(position).getLongitude()));
                // Start SingleItemView Class
                intent.putExtra("image",(barList.get(position).getImage()));
                mContext.startActivity(intent);
            }
        });

        return view;
    }
}