package com.healthiera.mobile.fragment.healthData;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.healthiera.mobile.R;
import com.healthiera.mobile.component.base.BaseToggleButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class Heredity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heredity, container, false);

        LinearLayout ln = (LinearLayout) view.findViewById(R.id.ln1);
        ln.addView(new BaseToggleButton(getContext()));

        LinearLayout ln2 = (LinearLayout) view.findViewById(R.id.ln2);
        ln2.addView(new BaseToggleButton(getContext()));

        LinearLayout ln3 = (LinearLayout) view.findViewById(R.id.ln3);
        ln3.addView(new BaseToggleButton(getContext()));

        LinearLayout ln4 = (LinearLayout) view.findViewById(R.id.ln4);
        ln4.addView(new BaseToggleButton(getContext()));

        //BaseToggleFrame toggle1 = (BaseToggleFrame) view.findViewById(R.id.toggle1);

        return view;
    }

}
