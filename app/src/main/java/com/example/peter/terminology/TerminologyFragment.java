package com.example.peter.terminology;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TerminologyFragment extends Fragment {
    View rootView;
    List<Integer> images;
    ListView dentalListView;

    public interface CallbackTerminology {
        void onItemSelecteddd(int position);
    }

    public TerminologyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_dental_terminology, container, false);

        if (MainActivity.choice == 1) {
            getActivity().setTitle("Dental Terminology");
        } else if (MainActivity.choice == 2) {
            getActivity().setTitle("Non Dental Terminology");
        }
        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onStart() {
        loadDentalTerminology();
        super.onStart();
    }

    public void loadDentalTerminology() {
        images = new ArrayList<>();
        images.add(R.mipmap.button10);
        images.add(R.mipmap.button11);

        dentalListView = (ListView) rootView.findViewById(R.id.dentalListView);
        dentalListView.setAdapter(new MainAdapter(getContext(), images));
        dentalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position22, long id) {

                ((CallbackTerminology) getActivity()).onItemSelecteddd(position22);

            }


        });
    }

}
