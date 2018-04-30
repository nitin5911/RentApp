package com.example.chetanp.rentitapp.Fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Chetan P on 06-02-2018.
 */

public class PostAddFragment extends Fragment implements View.OnClickListener {
    private Button postAdd;
    private Spinner categories,price,country,zone;
    private EditText addTitle,addDescription,priceForDay,priceForWeek,itemQuantity,discountPercent,cityText,zipCodeText;
    private ImageView removeFirstImage,removeSecondImage,removeThirdImage,addFirstImage,addSecondImage,addThirdImage;
    private CheckBox hideEmailInAdd,hideMobleInAdd,multipleItems;
    private ArrayList<String>category=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.post_add_fragment,container,false);

        postAdd= view.findViewById(R.id.paBtn);
        categories=view.findViewById(R.id.paCategosrySpinner);
        price=view.findViewById(R.id.paPriceSpinner);
        country=view.findViewById(R.id.paCountrySpinner);
        zone=view.findViewById(R.id.paZoneSpinner);
        addTitle=view.findViewById(R.id.patitleEdt);
        addDescription=view.findViewById(R.id.paDescriptionEdt);
        priceForDay=view.findViewById(R.id.paPricedayEdt);
        priceForWeek=view.findViewById(R.id.paPriceweekEdt);
        itemQuantity=view.findViewById(R.id.paQuantityEdt);
        discountPercent=view.findViewById(R.id.paPercentEdt);
        cityText=view.findViewById(R.id.paCityEdt);
        zipCodeText=view.findViewById(R.id.paZipEdt);
        removeFirstImage=view.findViewById(R.id.paRemoveimageFirst);
        removeSecondImage=view.findViewById(R.id.paRemoveImageTwo);
        removeThirdImage=view.findViewById(R.id.paRemoveimageThird);
        addFirstImage=view.findViewById(R.id.paAddimageFirst);
        addSecondImage=view.findViewById(R.id.paAddImageTwo);
        addThirdImage=view.findViewById(R.id.paAddimageThird);
        hideEmailInAdd=view.findViewById(R.id.paHideemailCheckbox);
        hideMobleInAdd=view.findViewById(R.id.paHidephoneCheckbox);
        multipleItems=view.findViewById(R.id.paQuantityCheckbox);

        category.add("Select");
        category.add("Baby & Kids");
        category.add("Books");
        category.add("Camping");
        category.add("Car & Accessories");
        category.add("cooking & Accessories");
        category.add("Costumes");
        category.add("Creative & Crafty");
        category.add("Cycling & Accessories");
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,category);
        categories.setAdapter(adapter);

        initilization();
        postAdd.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.paBtn:
                postingYoutAdd();
                this.getFragmentManager().beginTransaction().add(R.id.main_frame,new MyAddsFragment()).commitNowAllowingStateLoss();
                break;
        }
    }
    private void initilization(){
    }
    private void postingYoutAdd(){
        ProgressDialog progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("Posting your add Please wait..");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(true);
    }
}
