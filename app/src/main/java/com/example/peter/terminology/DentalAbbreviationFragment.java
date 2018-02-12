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

public class DentalAbbreviationFragment extends Fragment {

    View rootView;
    ListView dentalAbbListview;
    List<DentalAbbreviation> dentalAbbreviationList;
    List<String> mNames;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_dental_abbreviation, container, false);
        getActivity().setTitle("Abbreviations of Organizations");

        dentalAbbListview = (ListView) rootView.findViewById(R.id.dentalAbbListView);
        List<String> nullData = new ArrayList<>();

        dentalAbbListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Dialog suffixDialog = new Dialog(getActivity());
                suffixDialog.setContentView(R.layout.dental_suffix);
                suffixDialog.setTitle(dentalAbbreviationList.get(i).getName());
                suffixDialog.show();

                TextView wordTitle = (TextView) suffixDialog.findViewById(R.id.dental3);
                wordTitle.setText("");

                TextView meaningTitle = (TextView) suffixDialog.findViewById(R.id.dental1);
                meaningTitle.setText("Meaning");

                TextView word = (TextView) suffixDialog.findViewById(R.id.dental4);
                word.setText("");

                TextView meaning = (TextView) suffixDialog.findViewById(R.id.dental2);
                meaning.setText(dentalAbbreviationList.get(i).getMeaning());

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
        loadDentalAbb();
        super.onStart();
    }

    public void loadDentalAbb() {
        dentalAbbreviationList = new ArrayList<>();
        Log.d("DSLV", "done22");
        dentalAbbreviationList.add(new DentalAbbreviation("AAPD","American Academy of Pediatric Dentistry"));
        dentalAbbreviationList.add(new DentalAbbreviation("BACD","British Academy of Cosmetic Dentistry"));
        dentalAbbreviationList.add(new DentalAbbreviation("CDOE","Community Dentistry and Oral Epidemiology"));
        dentalAbbreviationList.add(new DentalAbbreviation("DAEC","Dental Assisting Educators of Canada"));
        dentalAbbreviationList.add(new DentalAbbreviation("ECDN","Early Childhood Dental Network"));
        dentalAbbreviationList.add(new DentalAbbreviation("FADIA","Fellow American Dental Implant Association"));
        dentalAbbreviationList.add(new DentalAbbreviation("GABD","Global Academy for Biologic Dentistry"));
        dentalAbbreviationList.add(new DentalAbbreviation("HSDA","Hispanic Student Dental Association"));
        dentalAbbreviationList.add(new DentalAbbreviation("IADR","International Association of Dental Research"));
        dentalAbbreviationList.add(new DentalAbbreviation("JDAS","Journal of Dental and Allied Sciences"));
        dentalAbbreviationList.add(new DentalAbbreviation("KIND","Kids In Need of Dentistry"));
        dentalAbbreviationList.add(new DentalAbbreviation("LDFT","Longitudinal Dental Foundation Training"));
        dentalAbbreviationList.add(new DentalAbbreviation("MDPB","Medical and Dental Professions Board"));
        dentalAbbreviationList.add(new DentalAbbreviation("NADP","National Association of Dental Plans"));
        dentalAbbreviationList.add(new DentalAbbreviation("PDA","Permanente Dental Associates"));
        dentalAbbreviationList.add(new DentalAbbreviation("TDMR","Texas Dentists for Medicaid Reform"));
        dentalAbbreviationList.add(new DentalAbbreviation("URJD","Universal Research Journal of Dentistry"));
        Log.d("DSLV", "done33");

        mNames = new ArrayList();
        for (int i = 0; i < dentalAbbreviationList.size(); i++) {
            mNames.add(dentalAbbreviationList.get(i).getName());
        }
        Log.d("DSLV", "done44 " + mNames.size());
        dentalAbbListview.setAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.row,
                R.id.singleRowTextView,
                mNames));


    }
}
