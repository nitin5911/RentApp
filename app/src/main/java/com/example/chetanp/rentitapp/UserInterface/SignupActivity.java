package com.example.chetanp.rentitapp.UserInterface;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.chetanp.rentitapp.BasicComponentsReuse;
import com.example.chetanp.rentitapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    @BindViews({R.id.supfnameEtxtid,R.id.suplnameEtxtid,R.id.supemailEtxtid,R.id.supphoneEtxtid,
            R.id.suppassEtxtid,R.id.supcpassEtxtid}) List<EditText> editText_obj;
    @BindView(R.id.supleftarrowBtnid) ImageView backImagebtn;
    @BindView(R.id.supsubmitbtnid) Button signUp;
    private Intent signsucessintent,signbackintent;
    BasicComponentsReuse basicComponentsReuse_obj=null;
    private String ufName,ulNamem,uEmail,uPhone,uPassword,ucPassword;
    ProgressDialog signupprogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        // bind the view using butterknife
        ButterKnife.bind(this);
        //progress bar work
        signupprogressbar=basicComponentsReuse_obj.showProgressBar_method(SignupActivity.this,signupprogressbar);
    }//end of onCreate method

    @OnClick({R.id.supleftarrowBtnid,R.id.supsubmitbtnid})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.supleftarrowBtnid:
                signbackintent=new Intent(SignupActivity.this,LoginActivity.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(SignupActivity.this,signbackintent);
                break;
            case R.id.supsubmitbtnid:
                validInputs();
                break;
        }//end of switch case
    }//end Of on click
    private void validInputs(){
        //getting All parameters work
        ufName=editText_obj.get(0).getText().toString().trim();
        ulNamem=editText_obj.get(1).getText().toString().trim();
        uEmail=editText_obj.get(2).getText().toString().trim();
        uPhone=editText_obj.get(3).getText().toString().trim();
        uPassword=editText_obj.get(4).getText().toString().trim();
        ucPassword=editText_obj.get(5).getText().toString();

        //validate fields work
        if(ufName.isEmpty())
            basicComponentsReuse_obj.editTextfieldvalidate_method(editText_obj.get(0),"Enter first Name");
        else if(ulNamem.isEmpty())
            basicComponentsReuse_obj.editTextfieldvalidate_method(editText_obj.get(1),"Enter last Name");
        else if(uEmail.isEmpty())
            basicComponentsReuse_obj.editTextfieldvalidate_method(editText_obj.get(2),"Enter your Email ID");
        else if(!Patterns.EMAIL_ADDRESS.matcher(uEmail).matches())
            basicComponentsReuse_obj.editTextfieldvalidate_method(editText_obj.get(2),"Enter a Valid Email ID");
        else if (uPassword.isEmpty())
            basicComponentsReuse_obj.editTextfieldvalidate_method(editText_obj.get(3),"Enter Password");
        else if(ucPassword.isEmpty())
            basicComponentsReuse_obj.editTextfieldvalidate_method(editText_obj.get(4),"Enter Confirm password");
        else if(! uPassword.equals(ucPassword))
            basicComponentsReuse_obj.editTextfieldvalidate_method(editText_obj.get(4),"Password Mismatch");
        else signupAPI_method() ;
    }//end of valid inputs method

    private void signupAPI_method() {
        signupprogressbar.show();
        //write code for API and write below code in API response method
        signsucessintent=new Intent(SignupActivity.this,LoginActivity.class);
        basicComponentsReuse_obj.intentmoveAnimateCode_method(SignupActivity.this,signsucessintent);
    }//end of signup API hit method

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        signbackintent=new Intent(SignupActivity.this,LoginActivity.class);
        basicComponentsReuse_obj.intentmoveAnimateCode_method(SignupActivity.this,signbackintent);
    }//end of onBackPressed method
}//end of main class