package com.example.chetanp.rentitapp.UserInterface;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chetanp.rentitapp.BasicComponentsReuse;
import com.example.chetanp.rentitapp.Fragment.ResetPassword;
import com.example.chetanp.rentitapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {

    @Nullable
    @BindView(R.id.fgNumberetxtid) EditText fgeditText_obj;
    @Nullable
    @BindView(R.id.otpboxEtxtid) EditText fgOTPetxt_obj;
    @Nullable
    @BindView(R.id.fgbackarrowiconid) ImageView fbbackarraow_obj;
    @Nullable
    @BindViews({R.id.fgsendOTPBtnid,R.id.otpSubmitBtnid}) List<Button> fgButton_obj;
    @Nullable
    @BindViews({R.id.resendOtpTxtid,R.id.otpExptimeTxtid,R.id.cancelTxt}) List<TextView> textView_obj;
    @BindViews({R.id.forgotPasswordLayout,R.id.otpLayout})List<ConstraintLayout> layout_obj;

    private BasicComponentsReuse basicComponentsReuse_obj=null;
    private Intent forgotbackintent;
    private String userMobile,userOTP,userOTPValue="null",otp_msg="Rent It App. Your OTP is";
    ProgressDialog forgetprogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        // bind the view using butterknife
        ButterKnife.bind(this);
        forgetprogressbar=basicComponentsReuse_obj.showProgressBar_method(ForgotPassword.this,forgetprogressbar);
    }//end of onCreate method

    @Optional
    @OnClick({R.id.fgbackarrowiconid,R.id.fgsendOTPBtnid,R.id.otpSubmitBtnid,R.id.resendOtpTxtid,R.id.cancelTxt })
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fgbackarrowiconid:
                forgotbackintent=new Intent(ForgotPassword.this,LoginActivity.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(ForgotPassword.this,forgotbackintent);
                break;
            case R.id.fgsendOTPBtnid:
                validNumber_method();
                    break;
            case R.id.otpSubmitBtnid:
                validOTP_method();
                break;
            case R.id.resendOtpTxtid:
                sendOTP_method();
                break;
            case R.id.cancelTxt:
                fgeditText_obj.getText().clear();
                layout_obj.get(1).setVisibility(View.GONE);
                layout_obj.get(0).setVisibility(View.VISIBLE);
                break;
                }//end of switch case
    } //end of onClick method

    private void validNumber_method(){
         userMobile=fgeditText_obj.getText().toString().trim();
        if(userMobile.isEmpty())
            basicComponentsReuse_obj.editTextfieldvalidate_method(fgeditText_obj,"Enter Your Mobile number");
        else if(userMobile.trim().length()<10)
            basicComponentsReuse_obj.editTextfieldvalidate_method(fgeditText_obj,"Enter Valid Mobile");
        else {
            sendOTP_method();
            //forget layout
            layout_obj.get(0).setVisibility(View.GONE);
            //otp layout
            layout_obj.get(1).setVisibility(View.VISIBLE);
        }//end of else
    }//ent of Valid Email Method

    private void validOTP_method() {
        userOTP=fgOTPetxt_obj.getText().toString().trim();
        if(userOTP.isEmpty())
            basicComponentsReuse_obj.editTextfieldvalidate_method(fgOTPetxt_obj,"Enter Your OTP number");
        else if(!userOTP.equals(userOTPValue))
            basicComponentsReuse_obj.editTextfieldvalidate_method(fgOTPetxt_obj,"OTP Number is mismatch");
        else getSupportFragmentManager().beginTransaction().replace(R.id.forgot_mainLayout,new ResetPassword()).commitNowAllowingStateLoss();
    }//end of valid OTP method

    private void sendOTP_method() {
        //hit API for OTP send here
        Toast.makeText(this, "OTP send is calling", Toast.LENGTH_SHORT).show();
        userOTPValue= basicComponentsReuse_obj.sendDataforOTP_method(ForgotPassword.this,fgButton_obj.get(1),
                textView_obj.get(1),otp_msg,userMobile );
    }//end of send OTP method

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        forgotbackintent=new Intent(ForgotPassword.this,LoginActivity.class);
        basicComponentsReuse_obj.intentmoveAnimateCode_method(ForgotPassword.this,forgotbackintent);
    }//end of onBackPressed method

}//end of mainoptionmenu class
