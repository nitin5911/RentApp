package com.example.chetanp.rentitapp.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chetanp.rentitapp.Adapter.MyBookingsAdapter;
import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;

/**
 * Created by Chetan P on 06-02-2018.
 */

public class MyBookings extends Fragment  {
    private ArrayList<String> myBooked=new ArrayList<>();
    private RecyclerView myBookings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_bookings_fragment,container,false);

        for(int i=0;i<=10;i++){
            myBooked.add("chetan");
        }

        myBookings=view.findViewById(R.id.my_bookings_recyclerview);
        myBookings.setHasFixedSize(true);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(getActivity().getApplicationContext());
        MyBookingsAdapter myBookingsAdapter=new MyBookingsAdapter(getActivity(),myBooked);
        myBookings.setLayoutManager(lm);
        myBookings.setAdapter(myBookingsAdapter);

        return view;
    }
}
