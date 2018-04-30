package com.example.chetanp.rentitapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chetanp.rentitapp.Adapter.MyAddAdapter;
import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;

/**
 * Created by Chetan P on 06-02-2018.
 */

public class MyAddsFragment extends Fragment implements View.OnClickListener {
    private RecyclerView myAdds;
    private ArrayList<String>data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_adds_fragment,container,false);
        data=new ArrayList<>();
        for(int i=0;i<=10;i++){
            data.add("chetan");
        }

        myAdds=view.findViewById(R.id.my_adds_fragment_recyclerview);
        RecyclerView.LayoutManager addsLayout=new LinearLayoutManager(getActivity().getApplicationContext());
        myAdds.setLayoutManager(addsLayout);
        MyAddAdapter myAddAdapter=new MyAddAdapter(getActivity(),data);
        myAdds.setAdapter(myAddAdapter);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
