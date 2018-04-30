package com.example.chetanp.rentitapp.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chetanp.rentitapp.Adapter.HomeFragRecyclAdapter;
import com.example.chetanp.rentitapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeMain_frag extends Fragment {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    private OnFragmentInteractionListener mListener;

    @BindView(R.id.homefragReclrid)RecyclerView home_recycle;
    private RecyclerView.LayoutManager homelayoutManager_obj;
    private HomeFragRecyclAdapter homeFragRecyclAdapter_obj;
    private ArrayList<Integer> catgry_images=new ArrayList<>();


    public HomeMain_frag() {}
    public static HomeMain_frag newInstance(String param1, String param2) {
        HomeMain_frag fragment = new HomeMain_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment; }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        } }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View home_view=inflater.inflate(R.layout.fragment_home_main_frag, container, false);
        ButterKnife.bind(this,home_view);
        //fetch home fragment data from API hit work
        getDataforHomeFrag_method();
        return home_view ;
    }//end of onCreateView method

    private void getDataforHomeFrag_method() {
        //Hit API and write code when success.
        for (int a=0;a<=10;a++){
            catgry_images.add(R.drawable.sport_bike);
        }
        //write code in API response method when success.
        homelayoutManager_obj=new LinearLayoutManager(getActivity());
        homeFragRecyclAdapter_obj =new HomeFragRecyclAdapter(getActivity(),catgry_images);
        home_recycle.setLayoutManager(homelayoutManager_obj);
        home_recycle.setAdapter(homeFragRecyclAdapter_obj);
    }//end of get Data for Home frag method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri); } }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
        //    throw new RuntimeException(context.toString()
        //            + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }

 }//end of main class
