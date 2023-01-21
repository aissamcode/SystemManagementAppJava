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
 * Use the {@link internlistfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class internlistfragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public internlistfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment internlistfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static internlistfragment newInstance(String param1, String param2) {
        internlistfragment fragment = new internlistfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    systemDatabase dbintern;
    ListView listviewintern;
    Button backinternD,exitinternD;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        dbintern=new systemDatabase(getActivity(),"intern",null,1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_internlistfragment, container, false);
        listviewintern=view.findViewById(R.id.listviewintern);
        backinternD=view.findViewById(R.id.backinternD);
        exitinternD=view.findViewById(R.id.exitinternD);
        // Inflate the layout for this fragment
        backinternD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        exitinternD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finishAffinity();
                System.exit(0);

            }
        });
        ArrayList<String> listintern = dbintern.getDataintern();
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,listintern);
        listviewintern.setAdapter(adapter);
        return view;
    }
}