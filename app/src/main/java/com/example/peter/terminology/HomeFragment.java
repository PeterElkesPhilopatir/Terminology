package com.example.peter.terminology;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    View rootView;
    List<Integer> images;
    ListView listView;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface Callback {
        void onItemSelected(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);


        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onStart() {
        loadButtons();
        super.onStart();
    }


    public void loadButtons() {
        images = new ArrayList<>();
        images.add(R.mipmap.button00);
        images.add(R.mipmap.button01);
        images.add(R.mipmap.button02);

        listView = (ListView) rootView.findViewById(R.id.listviewMain);
        listView.setAdapter(new MainAdapter(getContext(), images));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), "you clicked" + position, Toast.LENGTH_SHORT).show();
                ((Callback) getActivity()).onItemSelected(position);
            }


        });


    }



}
