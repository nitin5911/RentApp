package com.example.chetanp.rentitapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;

/**
 * Created by Chetan P on 06-02-2018.
 */

public class MyRentedAdapter extends RecyclerView.Adapter<MyRentedAdapter.MyRentedView>{
    private ArrayList<String>data;
    private Context context;

    public MyRentedAdapter(Context ctx,ArrayList<String>daa){
        this.data=daa;
        this.context=ctx;
    }

    @Override
    public MyRentedView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_rented_item_view,parent,false);
        MyRentedView holder=new MyRentedView(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyRentedView holder, int position) {


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyRentedView extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView postedBy,adTitle,adQuantity,pickupDate,pickupTime,returnDate,returnTime,bookingDate,status;
        private ImageView rentedItemImage;

        public MyRentedView(View itemView) {
            super(itemView);
            postedBy=itemView.findViewById(R.id.mrPstedTxt);
            adTitle=itemView.findViewById(R.id.mradtitleTxt);
            adQuantity=itemView.findViewById(R.id.mrquantityTxt);
            pickupDate=itemView.findViewById(R.id.mrpickupdateTxt);
            pickupTime=itemView.findViewById(R.id.mrpickuptimeTxt);
            returnDate=itemView.findViewById(R.id.mrreturndateTxt);
            returnTime=itemView.findViewById(R.id.mrreturntimeTxt);
            bookingDate=itemView.findViewById(R.id.mrbookingdateTxt);
            status=itemView.findViewById(R.id.mrstatusTxt);
            rentedItemImage=itemView.findViewById(R.id.myrented_image);


        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),"Position"+getPosition(),Toast.LENGTH_SHORT).show();
            switch (getAdapterPosition()){
                default:
          //          itemView.getContext().startActivity(new Intent((itemView.getContext()),HomeDetailActivity.class));
            }

        }
    }
}
