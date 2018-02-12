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

public class NonDentalAbbreviationFragment extends Fragment {
    View rootView;
    ListView nonDentalAbbListView;
    List<NonDentalAbbreviation> nonDentalAbbreviations;
    List<String> mNames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_non_dental_abbreviation, container, false);
        getActivity().setTitle("Abbreviations of Organizations");

        nonDentalAbbListView = (ListView) rootView.findViewById(R.id.nonDentalAbbListView);

        nonDentalAbbListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Dialog suffixDialog = new Dialog(getActivity());
                suffixDialog.setContentView(R.layout.dental_suffix);
                suffixDialog.setTitle(nonDentalAbbreviations.get(i).getName());
                suffixDialog.show();

                TextView exTitle = (TextView) suffixDialog.findViewById(R.id.dental1);
                exTitle.setText("Extension");

                TextView none = (TextView) suffixDialog.findViewById(R.id.dental3);
                none.setText("");

                TextView ex = (TextView) suffixDialog.findViewById(R.id.dental2);
                ex.setText(nonDentalAbbreviations.get(i).getExtension());

                TextView none2 = (TextView) suffixDialog.findViewById(R.id.dental4);
                none2.setText("");

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
        loadNonDentalAbb();
        super.onStart();
    }

    public void loadNonDentalAbb() {
        nonDentalAbbreviations = new ArrayList<>();

        nonDentalAbbreviations.add(new NonDentalAbbreviation("ABEDA "," Arab Bank for Economic Development in Africa"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("ACP","African, Caribbean, and Pacific Countries"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("AL","Arab League"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("BIS","Bank for International Settlements"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("CE","Council of Europe"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("CEI","Central European Initiative"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("CSCE","Conference on Security and Cooperation in Europe"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("ECO","Economic Cooperation Organization"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("ECA","Economic Commission for Africa"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("ESA","European Space Agency"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("FAO ","Food and Agriculture Organization"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("GCC ","Gulf Cooperation Council"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("IAEA","International Atomic Energy Agency"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("IFC"," International Finance Corporation"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("LAIA"," Latin American Integration Association"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("OAPEC","Organization of Arab Petroleum Exporting Countries"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("SACU","Southern African Customs Union"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("UNDP","United Nations Development Program"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("WToO","World Tourism Organization"));
        nonDentalAbbreviations.add(new NonDentalAbbreviation("WFP","World Food Program"));

        mNames = new ArrayList();
        for (int i = 0; i < nonDentalAbbreviations.size(); i++) {
            mNames.add(nonDentalAbbreviations.get(i).getName());
        }
        Log.d("DSLV", "done44 " + mNames.size());
        nonDentalAbbListView.setAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.row,
                R.id.singleRowTextView,
                mNames));


    }
}
