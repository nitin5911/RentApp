package com.example.chetanp.rentitapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chetanp.rentitapp.MainActivity;
import com.example.chetanp.rentitapp.R;
import com.example.chetanp.rentitapp.UserInterface.EditProfile;

/**
 * Created by Chetan P on 06-02-2018.
 */

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private Button editProfile;
    private TextView profileName,profileMobile,profileEmail,profileAddress,profileDistrict,profilePincode;
    private ImageView profileImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.profile_fragment,container,false);

        editProfile=view.findViewById(R.id.pEditBtn);
        profileName=view.findViewById(R.id.pNameTxt);
        profileMobile=view.findViewById(R.id.pMobileTxt);
        profileEmail=view.findViewById(R.id.pEmailTxt);
        profileAddress=view.findViewById(R.id.pAddressTxt);
        profileDistrict=view.findViewById(R.id.pDistrictTxt);
        profilePincode=view.findViewById(R.id.pPincodeTxt);
        profileImage=view.findViewById(R.id.pImage);
        editProfile.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pEditBtn:
                Intent in=new Intent((MainActivity)(getActivity()), EditProfile.class);
                    startActivity(in);
        }
    }
}
