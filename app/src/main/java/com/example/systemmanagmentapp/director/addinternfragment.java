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
 * Use the {@link addinternfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addinternfragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public addinternfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addinternfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static addinternfragment newInstance(String param1, String param2) {
        addinternfragment fragment = new addinternfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    TextInputEditText internlastname,internfirstname,interngender,internbacgrades,internfield;

    Button addintern;
    systemDatabase dbintern,dbuser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        dbintern=new systemDatabase(getActivity(),"intern",null,1);
        dbuser=new systemDatabase(getActivity(),"user",null,1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_addinternfragment, container, false);
        // Inflate the layout for this fragment
        internlastname=view.findViewById(R.id.internlastname);
        internfirstname=view.findViewById(R.id.internfirstname);
        interngender=view.findViewById(R.id.interngender);
        internbacgrades=view.findViewById(R.id.internbacgrades);
        internfield=view.findViewById(R.id.internfield);
        addintern=view.findViewById(R.id.addintern);
        addintern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbintern.addintern(internlastname.getText().toString(),internfirstname.getText().toString(),interngender.getText().toString(),Double.parseDouble(internbacgrades.getText().toString()),internfield.getText().toString(), Double.valueOf("0"));
                dbuser.adduser((internfirstname.getText().toString()+internlastname.getText().toString()),"000000",internlastname.getText().toString(),internfirstname.getText().toString(),3);
                Toast.makeText(getActivity(),"intern Added successfully",Toast.LENGTH_LONG).show();
                android.app.Fragment internlistfragment= new internlistfragment();
                FragmentManager fragmentManager= getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.layoutintern,internlistfragment,null).commit();
            }
        });
        return view;
    }
}