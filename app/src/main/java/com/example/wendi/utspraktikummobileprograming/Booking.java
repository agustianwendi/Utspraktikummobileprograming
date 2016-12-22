package com.example.wendi.utspraktikummobileprograming;

/**
 * Created by arif1 on 10/26/2016.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class Booking extends Fragment {

    public Booking(){}
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.booking, container, false);

        getActivity().setTitle("Booking");

        return view;
    }
}
