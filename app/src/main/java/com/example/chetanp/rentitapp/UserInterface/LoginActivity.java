package com.example.chetanp.rentitapp.UserInterface;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chetanp.rentitapp.BasicComponentsReuse;
import com.example.chetanp.rentitapp.MainActivity;
import com.example.chetanp.rentitapp.R;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindViews({R.id.sinskiptxtid,R.id.signuptxtid,R.id.fogetpasstxtid})List<TextView> textView_obj;
    @BindViews({R.id.sinuserEtxtid,R.id.sinpassEtxtid}) List<EditText> editText_obj;
    @BindViews({R.id.sinloginBtnid,R.id.sinfbbtnid}) List<Button> button_obj;
     BasicComponentsReuse basicComponentsReuse_obj=null;
    private String usrEmail,usrPassword;
     ProgressDialog loginprogressbar;
  //  ArrayList<LoginPOJO2> login_arraylist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        // bind the view using butterknife
        ButterKnife.bind(this);
        loginprogressbar=basicComponentsReuse_obj.showProgressBar_method(LoginActivity.this,loginprogressbar);
    }//end of onCreate method

    @OnClick({R.id.sinskiptxtid,R.id.signuptxtid,R.id.fogetpasstxtid,R.id.sinloginBtnid,R.id.sinfbbtnid})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sinskiptxtid:
                Intent skip_intent = new Intent(LoginActivity.this, MainActivity.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(LoginActivity.this,skip_intent);
                break;
            case R.id.signuptxtid:
                Intent login_intent = new Intent(LoginActivity.this, SignupActivity.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(LoginActivity.this,login_intent);
                break;
            case R.id.fogetpasstxtid:
                Intent forgot_intent = new Intent(LoginActivity.this, ForgotPassword.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(LoginActivity.this,forgot_intent);
                break;
            case R.id.sinloginBtnid:
                loginValidation();
                    break;
            case R.id.sinfbbtnid:
                Toast.makeText(this, "Fb button is pressed", Toast.LENGTH_SHORT).show();
                break;
        }//end of switch case
    }//end of onClick method
        private void loginValidation() {
            //getting All parameters work
            usrEmail=editText_obj.get(0).getText().toString().trim();
            usrPassword=editText_obj.get(1).getText().toString().trim();
            //validate fields work
            if(usrEmail.isEmpty())
                basicComponentsReuse_obj.editTextfieldvalidate_method(editText_obj.get(0),"Enter Your E-mail ID");
            else if (! Patterns.EMAIL_ADDRESS.matcher(usrEmail).matches())
                basicComponentsReuse_obj.editTextfieldvalidate_method(editText_obj.get(0),"Enter a valid E-mail ID");
            else if (usrPassword.isEmpty())
                basicComponentsReuse_obj.editTextfieldvalidate_method(editText_obj.get(1),"Enter Your Password");
            else loginApiHit_method();
        }//end of login validation method
    private void loginApiHit_method() {
        //show progess bar
        loginprogressbar.show();
        //write code for API and write below code in API response method
//        login_arraylist.add(response.body().getData());
//        basicComponentsReuse_obj.mainAppSessioncreate_method(getApplicationContext(),"LoginAppSession","LoginuserAuthKey",response.body().getData().getAuthKey(),"Loginuserdetaillist",login_arraylist);
        Intent main_intent = new Intent(LoginActivity.this, MainActivity.class);
        basicComponentsReuse_obj.intentmoveAnimateCode_method(LoginActivity.this,main_intent);
        loginprogressbar.dismiss();
    }//end of login API hit met

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }//end of onBackPressed method
}//end of mainoptionmenu class