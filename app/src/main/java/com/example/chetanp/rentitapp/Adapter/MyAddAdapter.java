package com.example.chetanp.rentitapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;

/**
 * Created by Chetan P on 09-02-2018.
 */

public class MyAddAdapter extends RecyclerView.Adapter<MyAddAdapter.MyAddsViwHolder> {
    private ArrayList<String>data;
    private Context context;

    public MyAddAdapter(Context context,ArrayList<String>data){
        this.data=data;
        this.context=context;

    }

    @Override
    public MyAddsViwHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_adds_view,parent,false);
        MyAddsViwHolder myAddsViwHolder=new MyAddsViwHolder(view);
        return myAddsViwHolder;
    }

    @Override
    public void onBindViewHolder(MyAddsViwHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyAddsViwHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView myaddsTitle,myaddsStatus,totalView,shareOnFacebook,shareOnTwiter,shareOnmail,addToFavourite,viewOnmobile,viewOnMails;
        private LinearLayout deleteAdd,editAdd;
        private ImageView addImage;

        public MyAddsViwHolder(View itemView) {
            super(itemView);
            myaddsTitle=itemView.findViewById(R.id.matitleTxt);
            myaddsStatus=itemView.findViewById(R.id.mastatusTxt);
            totalView=itemView.findViewById(R.id.maTotalviewsTxt);
            shareOnFacebook=itemView.findViewById(R.id.mafacebookTxt);
            shareOnTwiter=itemView.findViewById(R.id.maTwiterTxt);
            shareOnmail=itemView.findViewById(R.id.maMailsTxt);
            addToFavourite=itemView.findViewById(R.id.maFavouriteTxt);
            viewOnmobile=itemView.findViewById(R.id.maViewPhoneTxt);
            viewOnMails=itemView.findViewById(R.id.maViewMailTxt);
            deleteAdd=itemView.findViewById(R.id.maDeletelayout);
            editAdd=itemView.findViewById(R.id.maEditLayout);
            addImage=itemView.findViewById(R.id.madImage);


            itemView.setOnClickListener(MyAddsViwHolder.this);

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),"Position"+getPosition(),Toast.LENGTH_SHORT).show();
            switch (getAdapterPosition()){
                default:
                //    view.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
                    break;
            }


        }
    }
}
