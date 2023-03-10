package com.example.systemmanagmentapp.director;

import android.app.FragmentManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.systemmanagmentapp.R;
import com.example.systemmanagmentapp.database.systemDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addfieldfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addfieldfragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public addfieldfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addfieldfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static addfieldfragment newInstance(String param1, String param2) {
        addfieldfragment fragment = new addfieldfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    systemDatabase dbfield;
    TextInputEditText fieldname,fielddescription;
    Button addfieldbutton;

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
        View view=inflater.inflate(R.layout.fragment_addfieldfragment, container, false);
        fieldname=view.findViewById(R.id.fieldname);
        fielddescription=view.findViewById(R.id.fielddescription);
        addfieldbutton=view.findViewById(R.id.addfieldbutton);
        // Inflate the layout for this fragment
        addfieldbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbfield.addfield(fieldname.getText().toString(),fielddescription.getText().toString());
                Toast.makeText(getActivity(),"filed Add successfully",Toast.LENGTH_LONG).show();
                android.app.Fragment filedlist= new fieldlistfragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layoutfield,filedlist,null).commit();
            }
        });
        return view;
    }
}