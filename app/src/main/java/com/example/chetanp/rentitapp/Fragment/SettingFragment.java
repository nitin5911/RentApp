package com.example.chetanp.rentitapp.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chetanp.rentitapp.R;

/**
 * Created by Chetan P on 09-02-2018.
 */

public class SettingFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.setting_fragment,container,false);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
