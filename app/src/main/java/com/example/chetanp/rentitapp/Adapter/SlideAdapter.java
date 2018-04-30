package com.example.chetanp.rentitapp.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.chetanp.rentitapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Chetan P on 22-02-2018.
 */

public class SlideAdapter extends PagerAdapter {
    private ArrayList<Integer> image_list=new ArrayList<>();
    private LayoutInflater layoutInflater_obj;
    private Context context;
    ImageView slideImg;

    public SlideAdapter(Context context,ArrayList<Integer>img){
         image_list=img;
         this.context=context;
     }//end of constructor

    @Override
    public int getCount() {
        return image_list.size();
    }//end of getCount method
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }//end of isViewFromObject method
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View)object);
     }//end of destroyItem method
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater_obj = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myImage=layoutInflater_obj.inflate(R.layout.slideimagesview,container,false);
        slideImg=myImage.findViewById(R.id.slideImage);
        Picasso.with(context).load(image_list.get(position)).placeholder(R.mipmap.ic_launcher).
                error(R.mipmap.ic_launcher).into(slideImg);

        container.addView(myImage,0);
        return myImage;
    }//end of instantiateItem method

}//end of main class
