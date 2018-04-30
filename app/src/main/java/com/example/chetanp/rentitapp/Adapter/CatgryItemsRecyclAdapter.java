package com.example.chetanp.rentitapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chetanp.rentitapp.BasicComponentsReuse;
import com.example.chetanp.rentitapp.R;
import com.example.chetanp.rentitapp.UserInterface.CategoryItemDetails;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Chetan P on 20-02-2018.
 */

public class CatgryItemsRecyclAdapter extends RecyclerView.Adapter<CatgryItemsRecyclAdapter.CatgryItemViewHolder> {
    private Context context;
    private ArrayList<String> catAllData_list=new ArrayList<>();
    BasicComponentsReuse basicComponentsReuse_obj;

    public CatgryItemsRecyclAdapter(Context context, ArrayList data){
        this.context=context;
        catAllData_list=data;
    }//end of constructor

    @Override
    public CatgryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cat_adapter= LayoutInflater.from(parent.getContext()).inflate(R.layout.categoryitemscardview,parent,false);
        CatgryItemViewHolder catgry_viewHolder=new CatgryItemViewHolder(cat_adapter);
        return catgry_viewHolder;
    }//end of onCreateViewHolder method

    @Override
    public void onBindViewHolder(CatgryItemViewHolder holder, int position) {
        for(int catgrycount=0;catgrycount<catAllData_list.size();catgrycount++){
            holder.text_obj.get(0).setText(catAllData_list.get(position));
        }//end of for loop
    }//end of onBindViewHolder method

    @Override
    public int getItemCount() {
        return catAllData_list.size();
    }

    public class CatgryItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindViews({R.id.craTitleText,R.id.craPriceTxt,R.id.craLocationTwoTxt,R.id.craLocationTxt,R.id.craPerdayTxt})
        List<TextView>text_obj;
        @BindView(R.id.craImage) ImageView adImage;
        @BindView(R.id.catgryItemscardid) CardView catCardview_obj;

        public CatgryItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            basicComponentsReuse_obj=new BasicComponentsReuse();
        }//end of viewholder constructor

        @OnClick(R.id.catgryItemscardid)
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.catgryItemscardid:
                    Intent catcard_intent=new Intent(itemView.getContext(),CategoryItemDetails.class);
                    catcard_intent.putExtra("catItemposition",getPosition());
                    basicComponentsReuse_obj.intentmoveAnimateCode_method(itemView.getContext(),catcard_intent);
                    break;
            }//end of switch case
        }//end of onClick method
    }//end of ViewHolder class
}//end of main class

