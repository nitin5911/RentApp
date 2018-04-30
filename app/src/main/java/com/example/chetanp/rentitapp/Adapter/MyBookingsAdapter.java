package com.example.chetanp.rentitapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;

/**
 * Created by Chetan P on 14-02-2018.
 */

public class MyBookingsAdapter extends RecyclerView.Adapter<MyBookingsAdapter.ViewHolder>{
    private ArrayList<String>myBooking=new ArrayList<>();
    private Context context;


    public MyBookingsAdapter(Context ctx, ArrayList<String>data){
        this.context=ctx;
        this.myBooking=data;
    }

    @Override
    public MyBookingsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_booking_itemview,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyBookingsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return myBooking.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (getAdapterPosition()){
                default:
                 //   itemView.getContext().startActivity(new Intent(itemView.getContext(),HomeDetailActivity.class));
//                    view.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
                    break;
            }

        }
    }
}