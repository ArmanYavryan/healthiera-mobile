package com.healthiera.mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.healthiera.mobile.R;

/**
 * Created by Davit on 19.08.2016.
 */
public class Goals extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//test
        View rootView = inflater.inflate(R.layout.goals,container,false);
        return rootView;
    }
}