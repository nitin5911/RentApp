package com.example.chetanp.rentitapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.chetanp.rentitapp.BasicComponentsReuse;
import com.example.chetanp.rentitapp.R;
import com.example.chetanp.rentitapp.UserInterface.CategoryItems;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragRecyclAdapter extends RecyclerView.Adapter<HomeFragRecyclAdapter.HomeViewHolder> {

    Context context;
    ArrayList<Integer> homeimages_list;
    BasicComponentsReuse basicComponentsReuse_obj;

    public HomeFragRecyclAdapter(Context context, ArrayList arrayList){
        this.context=context;
        homeimages_list=arrayList;
    }//end of constructor

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View home_adapter= LayoutInflater.from(parent.getContext()).inflate(R.layout.homefragcardview,parent,false);
        HomeViewHolder homeViewHolder=new HomeViewHolder(home_adapter);
        return homeViewHolder;
    }//end of onCreateViewHolder method

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        for(int imgcount=0;imgcount<homeimages_list.size();imgcount++){
            Picasso.with(context).load(homeimages_list.get(position)).into(holder.card_image);
        }//end of for loop
    }//end of onBinfViewHolder

    @Override
    public int getItemCount() {
        return homeimages_list.size();
    }//end of getItemCount

    //Home View Holder class work
    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.homecardimgid) ImageView card_image;
        @BindView(R.id.homecardid) CardView cardView_obj;

        public HomeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            basicComponentsReuse_obj=new BasicComponentsReuse();
        }//end of constructor

        @OnClick(R.id.homecardid)
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.homecardid:
                    Intent homecard_intent=new Intent(itemView.getContext(),CategoryItems.class);
                    homecard_intent.putExtra("imageposition",getPosition());
                    basicComponentsReuse_obj.intentmoveAnimateCode_method(itemView.getContext(),homecard_intent);
                    break;
            }//end of switch case
        }//end of onClick method
    }//end pf home view holder class

}//end of main class
