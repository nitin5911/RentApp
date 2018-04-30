package com.example.chetanp.rentitapp.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chetanp.rentitapp.Adapter.MyFavAddsAdapter;
import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;

/**
 * Created by Chetan P on 06-02-2018.
 */

public class FavouriteAddsFragment extends Fragment implements View.OnClickListener {
    private ArrayList<String>data=new ArrayList<>();
    private RecyclerView favAdds;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.favourite_adds_fragment,container,false);
        for(int i=0;i<=10;i++){
            data.add("chet");
        }
        favAdds=view.findViewById(R.id.my_favouriteadds_recyclerview);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getContext());
        favAdds.setLayoutManager(manager);
        MyFavAddsAdapter myFavAddsAdapter=new MyFavAddsAdapter(getActivity(),data);
        favAdds.setAdapter(myFavAddsAdapter);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
