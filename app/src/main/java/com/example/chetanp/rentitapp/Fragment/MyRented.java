package com.example.chetanp.rentitapp.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chetanp.rentitapp.Adapter.MyRentedAdapter;
import com.example.chetanp.rentitapp.MainActivity;
import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;

/**
 * Created by Chetan P on 06-02-2018.
 */

public class MyRented extends Fragment implements View.OnClickListener  {
    private RecyclerView myRentedList;
    private ArrayList<String>data= new ArrayList<>();
    private MyRentedAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.my_rented_fragment,container,false);
        myRentedList=view.findViewById(R.id.my_rented_recyclerview);
        for (int i=0;i<=10;i++){
            data.add("Title");
        }

        myRentedList.setHasFixedSize(true);
        RecyclerView.LayoutManager mylayoutmanager=new LinearLayoutManager(getActivity().getApplicationContext());
        myRentedList.setLayoutManager(mylayoutmanager);
        adapter=new MyRentedAdapter((MainActivity) getActivity(),data);
        myRentedList.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClick(View view) {

    }

}
