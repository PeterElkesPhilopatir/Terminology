package com.example.peter.terminology;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class DentalSuffixFragment extends Fragment {

    View rootView;
    ListView dentalSuffixListview;
    List<DentalSuffix> dentalSuffixList;
    List<String> mNames;

    private ArrayAdapter<String> mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_dental_suffix, container, false);
        getActivity().setTitle("Suffixes denoting conditions");
        dentalSuffixListview = (ListView) rootView.findViewById(R.id.dentalSuffixListView);
        Log.d("DSLV", "done");
        List<String> nullData = new ArrayList<>();

        dentalSuffixListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Dialog suffixDialog = new Dialog(getActivity());
                suffixDialog.setContentView(R.layout.dental_suffix);
                suffixDialog.setTitle(dentalSuffixList.get(i).getSuffix());
                suffixDialog.show();


                TextView wordTitle = (TextView) suffixDialog.findViewById(R.id.dental1);
                wordTitle.setText("Word");

                TextView meaningTitle = (TextView) suffixDialog.findViewById(R.id.dental3);
                meaningTitle.setText("Meaning");

                TextView word = (TextView) suffixDialog.findViewById(R.id.dental2);
                word.setText(dentalSuffixList.get(i).getWord());

                TextView meaning = (TextView) suffixDialog.findViewById(R.id.dental4);
                meaning.setText(dentalSuffixList.get(i).getMeaning());

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
        loadDentalSuffix();
        super.onStart();
    }

    public void loadDentalSuffix() {
        dentalSuffixList = new ArrayList<>();
        Log.d("DSLV", "done22");

        dentalSuffixList.add(new DentalSuffix("-ant", "Etchant", "An acid used in etching"));
        dentalSuffixList.add(new DentalSuffix("-cle", "Vesicle", "Small fluid-filled sac within the body"));
        dentalSuffixList.add(new DentalSuffix("-cule", "Molecule", "Group of atoms bonded together "));
        dentalSuffixList.add(new DentalSuffix("-ia", "Anesthesia", "Insensitivity to pain, especially as artificially induced "));
        dentalSuffixList.add(new DentalSuffix("-id", "Cuspid", "A tooth with a single projection point or elevation"));
        dentalSuffixList.add(new DentalSuffix("-ion", "Occlusion", "The fitting together of the teeth of the lower jaw with the corresponding teeth of the upper jaw"));
        dentalSuffixList.add(new DentalSuffix("-itis", "Arthritis", "Disease causing painful inflammation"));
        dentalSuffixList.add(new DentalSuffix("-ity", "Bacterium", "A member of a large group of unicellular microorganisms which have cell walls but lack organelles"));
        dentalSuffixList.add(new DentalSuffix("-olus", "Alveolus", "The bony socket for the root of a tooth"));
        dentalSuffixList.add(new DentalSuffix("oma", "oma", "A benign tumour of fatty tissue"));
        dentalSuffixList.add(new DentalSuffix("-pathy", "Myopathy", "A disease of muscle tissue"));
        dentalSuffixList.add(new DentalSuffix("-sion", "Incision", "The process of cutting into something"));
        dentalSuffixList.add(new DentalSuffix("-tic", "Nercotic", "The death of cells or tissues from severe injury or disease"));
        dentalSuffixList.add(new DentalSuffix("-tion", "Mastication", "Process by which the food is crushed"));
        dentalSuffixList.add(new DentalSuffix("-ible", "Reversible", "Capable of going through a series of actions(changes) either backward or forward"));
        Log.d("DSLV", "done33");

        mNames = new ArrayList();
        for (int i = 0; i < dentalSuffixList.size(); i++) {
            mNames.add(dentalSuffixList.get(i).getSuffix());
        }
        Log.d("DSLV", "done44 " + mNames.size());
        dentalSuffixListview.setAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.row,
                R.id.singleRowTextView,
                mNames));


    }
}



