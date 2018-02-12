package com.example.peter.terminology;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NonDentalSuffixFragment extends Fragment {

    View rootView;
    ListView nonDentalSuffixListView;
    List<NonDentalSuffix> nonDentalSuffixList;
    List<String> mNames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_non_dental_suffix, container, false);
        getActivity().setTitle("Suffixes denoting conditions");

        nonDentalSuffixListView = (ListView) rootView.findViewById(R.id.nonDentalSuffixListView);
        List<String> nullData = new ArrayList<>();

        nonDentalSuffixListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Dialog suffixDialog = new Dialog(getActivity());
                suffixDialog.setContentView(R.layout.dental_suffix);
                suffixDialog.setTitle(nonDentalSuffixList.get(i).getSuffix());
                suffixDialog.show();

                TextView meaningTitle = (TextView) suffixDialog.findViewById(R.id.dental1);
                meaningTitle.setText("Meaning");

                TextView exTitle = (TextView) suffixDialog.findViewById(R.id.dental3);
                exTitle.setText("Example");

                TextView meaning = (TextView) suffixDialog.findViewById(R.id.dental2);
                meaning.setText(nonDentalSuffixList.get(i).getMeaning());

                TextView example = (TextView) suffixDialog.findViewById(R.id.dental4);
                example.setText(nonDentalSuffixList.get(i).getExample());

                Button done = (Button) suffixDialog.findViewById(R.id.donBtn);
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        suffixDialog.dismiss();
                    }
                });
            }
        });
        return rootView;
    }

    @Override
    public void onStart() {
        loadNonDentalSuffix();
        super.onStart();
    }

    public void loadNonDentalSuffix() {
        nonDentalSuffixList = new ArrayList<>();

        nonDentalSuffixList.add(new NonDentalSuffix("-algia","Pain","Neuralgia"));
        nonDentalSuffixList.add(new NonDentalSuffix("-asthenia","Weakness","Myasthenia"));
        nonDentalSuffixList.add(new NonDentalSuffix("-emia","Blood","Anemia"));
        nonDentalSuffixList.add(new NonDentalSuffix("-th","The action or process of ","Growth "));
        nonDentalSuffixList.add(new NonDentalSuffix("-it is","Inflammation","Inflammation"));
        nonDentalSuffixList.add(new NonDentalSuffix("-dom","Refer to domain","freedom"));
        nonDentalSuffixList.add(new NonDentalSuffix("-lytic","Destroy or break down","Hemolytic"));
        nonDentalSuffixList.add(new NonDentalSuffix("-oid","Like","Dermoid"));
        nonDentalSuffixList.add(new NonDentalSuffix("-oma","Tumor","Carcinoma"));
        nonDentalSuffixList.add(new NonDentalSuffix("-opathy","Disease of","Neuropathy"));
        nonDentalSuffixList.add(new NonDentalSuffix("-orrhagia","Hemorrhage","Menorrhagia"));
        nonDentalSuffixList.add(new NonDentalSuffix("-Hood","Particular state","childhood"));
        nonDentalSuffixList.add(new NonDentalSuffix("-osis","Condition of","Tuberculosis"));
        nonDentalSuffixList.add(new NonDentalSuffix("-ship","Period of time","friendship"));
        nonDentalSuffixList.add(new NonDentalSuffix("-plasia","Growth","Hyperplasia"));
        nonDentalSuffixList.add(new NonDentalSuffix("-plegia","Paralysis","Paraplegia"));
        nonDentalSuffixList.add(new NonDentalSuffix("-pnea","Breathing","Apnea"));
        nonDentalSuffixList.add(new NonDentalSuffix("-megaly","Enlargement of","Cardiomegaly"));
        nonDentalSuffixList.add(new NonDentalSuffix("-pathy","Disease","Neuropathy"));
        nonDentalSuffixList.add(new NonDentalSuffix("-ness","State or quality","Completeness "));


        mNames = new ArrayList();
        for (int i = 0; i < nonDentalSuffixList.size(); i++) {
            mNames.add(nonDentalSuffixList.get(i).getSuffix());
        }
        Log.d("DSLV", "done44 " + mNames.size());
        nonDentalSuffixListView.setAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.row,
                R.id.singleRowTextView,
                mNames));


    }
}
