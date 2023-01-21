package com.example.systemmanagmentapp.director;

import android.app.FragmentManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.systemmanagmentapp.R;
import com.example.systemmanagmentapp.database.systemDatabase;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addformerfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addformerfragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public addformerfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addformerfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static addformerfragment newInstance(String param1, String param2) {
        addformerfragment fragment = new addformerfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    systemDatabase dbformer,dbuser;
    TextInputEditText formerregistrationnumber,formerdiploma,formerspeciality,formerrecruitmentdate,formerfirstname,formerlastname;
    Button addformerbutton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        dbformer=new systemDatabase(getActivity(),"former",null,1);
        dbuser=new systemDatabase(getActivity(),"user",null,1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_addformerfragment, container, false);
        formerregistrationnumber=view.findViewById(R.id.formerregistrationnumber);
        formerdiploma=view.findViewById(R.id.formerdiploma);
        formerspeciality=view.findViewById(R.id.formerspeciality);
        formerrecruitmentdate=view.findViewById(R.id.formerrecruitmentdate);
        formerfirstname=view.findViewById(R.id.formerfirstname);
        formerlastname=view.findViewById(R.id.formerlastname);
        addformerbutton=view.findViewById(R.id.addformerbutton);
        addformerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbformer.addfromer(formerregistrationnumber.getText().toString(),formerdiploma.getText().toString(),formerspeciality.getText().toString(),
                        formerrecruitmentdate.getText().toString(),formerfirstname.getText().toString(),formerlastname.getText().toString());
                dbuser.adduser(formerregistrationnumber.getText().toString(),"000000",formerlastname.getText().toString(),formerfirstname.getText().toString(),2);
                Toast.makeText(getActivity(),"Former Add successfully",Toast.LENGTH_LONG).show();
                android.app.Fragment formerList= new formerlistfragment();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layoutformer,formerList,null).commit();
            }
        });
        return view;
    }
}