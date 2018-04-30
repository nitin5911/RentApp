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
 * Created by Chetan P on 09-02-2018.
 */

public class MyFavAddsAdapter extends RecyclerView.Adapter<MyFavAddsAdapter.MyFavAddsViewHolder> {
    private Context context;
    private ArrayList<String>data=new ArrayList<>();
    public MyFavAddsAdapter(Context context,ArrayList<String>data){
        this.context=context;
        this.data=data;
    }//constructor end

    @Override
    public MyFavAddsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_adds_itemview,parent,false);
        MyFavAddsViewHolder myFavAddsViewHolder=new MyFavAddsViewHolder(view);
        return myFavAddsViewHolder;
    }//on create view holder ends
    @Override
    public void onBindViewHolder(MyFavAddsViewHolder holder, int position) {
    }//bind view holder ends

    @Override
    public int getItemCount() {
        return data.size();
    }//item count ends

    public class MyFavAddsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView favAdTitle,favAdDays,favAdPrice;
        private ImageView favAdImage;

        public MyFavAddsViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //initilization
            favAdTitle=itemView.findViewById(R.id.fatitleText);
            favAdDays=itemView.findViewById(R.id.faweekTxt);
            favAdPrice=itemView.findViewById(R.id.fapriceTxt);
            favAdImage=itemView.findViewById(R.id.faImage);
            //initilization ends

        }//view holder constructor ends

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),"Position"+getPosition(),Toast.LENGTH_SHORT).show();
            switch (getAdapterPosition()){
                default:
                //    itemView.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
                    break;
            }//switch ends
        }//view holder on Click ends
    }//myfavviewholder class ends
}//main class ends
