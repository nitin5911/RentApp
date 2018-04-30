package com.example.chetanp.rentitapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;

/**
 * Created by Chetan P on 14-02-2018.
 */

public class InvoiceFragmentAdapter extends RecyclerView.Adapter<InvoiceFragmentAdapter.ViewHolder> {
    private ArrayList<String>invoiCes=new ArrayList<>();
    private Context context;
    public InvoiceFragmentAdapter(Context context,ArrayList<String>data){
        this.invoiCes=data;
        this.context=context;
    }

    @Override
    public InvoiceFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_item_view,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(InvoiceFragmentAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return invoiCes.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView invoiceTitle,invoiceNumber,category,
                         rentedFrom,rentedBy,currencyType,priceForDay,priceForWeek,quantity,
                         startDate,endDate,securityAmount,totalRent,itemStatus,contactRentIt,
                          shareInvoice,printInvoice;

        public ViewHolder(View itemView) {
            super(itemView);
            invoiceTitle=itemView.findViewById(R.id.ivtitleTxt);
            invoiceNumber=itemView.findViewById(R.id.ivnumberTxt);
            category=itemView.findViewById(R.id.ivcategoryTxt);
            rentedFrom=itemView.findViewById(R.id.ivrFromTxt);
            rentedBy=itemView.findViewById(R.id.ivrbyTxt);
            currencyType=itemView.findViewById(R.id.ivcurrencytypeTxt);
            priceForDay=itemView.findViewById(R.id.ivpricefordayTxt);
            priceForWeek=itemView.findViewById(R.id.ivpriceforweekTxt);
            quantity=itemView.findViewById(R.id.ivquantityTxt);
            startDate=itemView.findViewById(R.id.ivstartDateTxt);
            endDate=itemView.findViewById(R.id.ivendDateTxt);
            securityAmount=itemView.findViewById(R.id.ivsecurityAmountTxt);
            totalRent=itemView.findViewById(R.id.ivtotalrentTxt);
            itemStatus=itemView.findViewById(R.id.ivitemStatusText);
            contactRentIt=itemView.findViewById(R.id.ivcontactRentitTxt);
            shareInvoice=itemView.findViewById(R.id.ivshareTxt);
            printInvoice=itemView.findViewById(R.id.ivprintTxt);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
