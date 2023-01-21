package com.example.systemmanagmentapp.director;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.systemmanagmentapp.R;
import com.example.systemmanagmentapp.database.systemDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fieldlistfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fieldlistfragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fieldlistfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fieldlistfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static fieldlistfragment newInstance(String param1, String param2) {
        fieldlistfragment fragment = new fieldlistfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    systemDatabase dbfield;
    ListView listviewfield;
    Button backfieldD,exitfieldD;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        dbfield=new systemDatabase(getActivity(),"field",null,1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fieldlistfragment, container, false);
        listviewfield=view.findViewById(R.id.listviewfield);
        backfieldD=view.findViewById(R.id.backfieldD);
        exitfieldD=view.findViewById(R.id.exitfieldD);
        // Inflate the layout for this fragment
        backfieldD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        exitfieldD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finishAffinity();
                System.exit(0);

            }
        });

        ArrayList<String> listfield = dbfield.getDatafield();
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,listfield);
        listviewfield.setAdapter(adapter);
        return view;
    }
}