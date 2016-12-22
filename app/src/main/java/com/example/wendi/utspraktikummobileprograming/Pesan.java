package com.example.wendi.utspraktikummobileprograming;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.*;


public class Pesan extends Fragment {

    public Pesan(){}
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.pesan, container, false);

        getActivity().setTitle("Pesan");

        return view;
    }
}
