package com.example.chetanp.rentitapp.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chetanp.rentitapp.Adapter.InvoiceFragmentAdapter;
import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;

/**
 * Created by Chetan P on 06-02-2018.
 */

public class InvoiceFragment extends Fragment implements View.OnClickListener {
    private RecyclerView invoiceItem;
    private ArrayList<String>invoiceData=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.invoice_fragment,container,false);
        invoiceItem=view.findViewById(R.id.invoice_recyclerview);
        for(int i=0;i<=4;i++){
            invoiceData.add("Acme");
        }
        invoiceItem.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        InvoiceFragmentAdapter invoiceFragmentAdapter=new InvoiceFragmentAdapter(getActivity().getApplicationContext(),invoiceData);
        invoiceItem.setLayoutManager(layoutManager);
        invoiceItem.setAdapter(invoiceFragmentAdapter);

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
