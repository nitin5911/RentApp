package com.example.chetanp.rentitapp.UserInterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.chetanp.rentitapp.Adapter.CatgryItemsRecyclAdapter;
import com.example.chetanp.rentitapp.BasicComponentsReuse;
import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryItems extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.ciRecyclerid)RecyclerView ctrgyrecyclerView;
    @BindViews({R.id.ciFilterImg,R.id.ciGotoImg})List<ImageView>img_obj;
    private RecyclerView.LayoutManager ctgrylayoutManager_obj;
    private CatgryItemsRecyclAdapter ctgryrecycleAdapter_obj;
    private ArrayList<String> catgry_data=new ArrayList<>();
    int homecardpos;
    BasicComponentsReuse basicComponentsReuse_obj=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_items);
        ButterKnife.bind(this);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        homecardpos=getIntent().getIntExtra("imageposition",-1);
        if(homecardpos!=-1) {
            Toast.makeText(this, "Category Position selected is " + homecardpos, Toast.LENGTH_SHORT).show();
            getCategoryItemsData_method();
        }
    }//end of onCreate view method

    private void getCategoryItemsData_method() {
        //Hit API and write code when success.
        for (int a=0;a<=10;a++){
            catgry_data.add("My Bike");
        }
        ctgrylayoutManager_obj=new LinearLayoutManager(getApplicationContext());
        ctgryrecycleAdapter_obj=new CatgryItemsRecyclAdapter(this,catgry_data);
        ctrgyrecyclerView.setLayoutManager(ctgrylayoutManager_obj);
        ctrgyrecyclerView.setAdapter(ctgryrecycleAdapter_obj);
    }//end of get Data for Home frag method

    @OnClick({R.id.ciRecyclerid,R.id.ciGotoImg})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ciGotoImg:
                Intent setloc_intent = new Intent(CategoryItems.this, SetUserLocationMap.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(CategoryItems.this,setloc_intent);
                break;
        }//end of switch

    }//end of on click

}//end of class