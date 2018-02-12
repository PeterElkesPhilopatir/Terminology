package com.example.peter.terminology;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 21/10/2017.
 */

public class MainAdapter extends BaseAdapter {


    Context mContext;
    List<Integer> images = new ArrayList<>();

    public MainAdapter(Context mContext,List<Integer>images){
        this.mContext = mContext;
        this.images=images;

    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int i) {
        return images.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView openImageView;

        openImageView = new ImageView(mContext);

        openImageView.setImageResource(images.get(position));

        return openImageView;
    }
}

