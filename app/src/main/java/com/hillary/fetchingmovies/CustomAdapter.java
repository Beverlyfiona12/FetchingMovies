package com.hillary.fetchingmovies;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Movie> data;//modify here
    public CustomAdapter(Context context, ArrayList<Movie> data) //modify here
    {
        this.mContext = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual 
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item_layout, parent,false);//modify here
            viewHolder = new ViewHolder();
//modify this block of code

            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvYear = (TextView) convertView.findViewById(R.id.tvYear);
            viewHolder.tvCategory = (TextView) convertView.findViewById(R.id.tvCategory);
//viewHolder.imageViewDish=(ImageView) convertView.findViewById(R.id.imageViewDish);
//Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//MODIFY THIS BLOCK OF CODE
         Movie m= data.get(position);
        viewHolder.tvTitle.setText(m.getTitle());
        viewHolder.tvYear.setText(m.getYear());
        viewHolder.tvCategory.setText(m.getCategory());

        return convertView;

    }
    static class ViewHolder {
        //MODIFY THIS BLOCK OF CODE
//TextView textViewTitle;
//ImageView imageViewDish;
        TextView tvTitle;
        TextView tvYear;
        TextView tvCategory;
    }

}
//justpaste.it/72xyf