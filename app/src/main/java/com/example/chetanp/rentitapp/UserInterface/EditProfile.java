package com.example.chetanp.rentitapp.UserInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chetanp.rentitapp.R;

public class EditProfile extends AppCompatActivity implements View.OnClickListener{
    private Button  saveEditProfile;
    private TextView addImageText,nameText,mobileText,genderText,addressText,districtText,stateText,pincodeText;
    private ImageView editprofileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        init();

        saveEditProfile.setOnClickListener(this);
    }
    private void init(){
        saveEditProfile=findViewById(R.id.epSaveBtn);
        addImageText=findViewById(R.id.epAddimageTxt);
        nameText=findViewById(R.id.epNameEdt);
        mobileText=findViewById(R.id.epMobileEdt);
        genderText=findViewById(R.id.epGenderEdt);
        addressText=findViewById(R.id.epAddressEdt);
        districtText=findViewById(R.id.epDistrictEdt);
        stateText=findViewById(R.id.epState);
        pincodeText=findViewById(R.id.epPincodeEdt);
        editprofileImage=findViewById(R.id.epImage);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.epSaveBtn:
                finish();
                break;
        }

    }
}
