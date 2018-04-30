package com.example.chetanp.rentitapp.Fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.chetanp.rentitapp.BasicComponentsReuse;
import com.example.chetanp.rentitapp.R;
import com.example.chetanp.rentitapp.UserInterface.LoginActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPassword extends Fragment implements View.OnClickListener {
    @BindViews({R.id.rspassEtxtid,R.id.rscPassEtxtid}) List<EditText> rsEdittext_obj;
    @BindView(R.id.resetsubmitBtnid) Button subresetPass_obj;
    @BindView(R.id.rsleftarrowBtnid) ImageView rsbackImagebtn;
    private String str_newPass,str_cPass;
    private BasicComponentsReuse basicComponentsReuse_obj=null;
    ProgressDialog resetprogressbar;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View reset_view=inflater.inflate(R.layout.reset_password,container,false);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        // bind the view using butterknife
        ButterKnife.bind(this,reset_view);
        //progress bar work
        resetprogressbar=basicComponentsReuse_obj.showProgressBar_method(getActivity(),resetprogressbar);
//        resetprogressbar = new ProgressDialog(getActivity(), android.R.style.Theme_DeviceDefault_Light_Dialog);
//        resetprogressbar.setMessage("Please wait");
//        resetprogressbar.setCancelable(false);
//        resetprogressbar.setCanceledOnTouchOutside(false);
//        resetprogressbar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return reset_view;
    }//end of  onCreate method

    @OnClick({R.id.resetsubmitBtnid,R.id.rsleftarrowBtnid})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.resetsubmitBtnid:
                newPasswordValidate();
                break;
            case R.id.rsleftarrowBtnid:
                Intent arrowintent=new Intent(getActivity(), LoginActivity.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(getActivity(),arrowintent);
                break;
        }//end of switch case
    }//ends onClick

    private void newPasswordValidate() {
        str_newPass=rsEdittext_obj.get(0).getText().toString().trim();
        str_cPass=rsEdittext_obj.get(1).getText().toString().trim();
        if(str_newPass.isEmpty())
            basicComponentsReuse_obj.editTextfieldvalidate_method(rsEdittext_obj.get(0),"Enter Password");
        else if(str_cPass.isEmpty())
            basicComponentsReuse_obj.editTextfieldvalidate_method(rsEdittext_obj.get(1),"Confirm Password");
        else if (! str_newPass.equals(str_cPass))
            basicComponentsReuse_obj.editTextfieldvalidate_method(rsEdittext_obj.get(1),"Password Missmatch");
        else newPasswordApiHit_method();
    }//end of new Password Validate

    private void newPasswordApiHit_method() {
        resetprogressbar.show();
        //API hit work here
        Toast.makeText(getContext(),"Password Change success",Toast.LENGTH_SHORT).show();
        Intent backintent=new Intent(getActivity(), LoginActivity.class);
        basicComponentsReuse_obj.intentmoveAnimateCode_method(getContext(),backintent);
        resetprogressbar.dismiss();
    }//new password api hit method ends
}//end of class
