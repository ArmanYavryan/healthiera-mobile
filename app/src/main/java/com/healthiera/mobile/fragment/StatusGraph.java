package com.healthiera.mobile.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.healthiera.mobile.R;
import com.healthiera.mobile.activity.main.MakeGraph;
import com.jjoe64.graphview.GraphView;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatusGraph extends Fragment {


    public StatusGraph() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_status_graph, container, false);
        view = GraphImplementation(view);
        return view;
    }

    private View GraphImplementation(View view) {
        float[] values;
        GraphView graph;
        values = new float[]{0.2f, 0.6f, 0.8f, 0.5f, 0.1f, 0.3f, 0.6f, 0.8f, 0.7f, 0.4f, 0.1f};
        graph = (GraphView) view.findViewById(R.id.gv1);
        MakeGraph makeGraph = new MakeGraph(graph, "Urination", view.getContext(), values, "#FF3020");

        values = new float[]{2f, 6f, 1f, 15.5f, 28.1f, 13f, 5.6f, 0.8f, 4.7f, 6.4f, 17.1f};
        graph = (GraphView) view.findViewById(R.id.gv2);
        makeGraph = new MakeGraph(graph, "Running", view.getContext(), values, "#FF3020");

        values = new float[]{1.8f,4f}; // empty
        graph = (GraphView) view.findViewById(R.id.gv3);
        makeGraph = new MakeGraph(graph, "Sleeping", view.getContext(), values, "#FF3020");

        values = new float[]{12f,5f, 10.1f, 6.3f, -1.6f, 1.8f, -3.7f, 0.6f, 1.1f};
        graph = (GraphView) view.findViewById(R.id.gv4);
        makeGraph = new MakeGraph(graph, "Eatinging", view.getContext(), values, "#FF3020");

        values = new float[]{4f, 20.1f, 4.3f, 17.6f, 13.8f, 21.7f, 4.4f, 6.1f};
        graph = (GraphView) view.findViewById(R.id.gv5);
        makeGraph = new MakeGraph(graph, "Dancing", view.getContext(), values, "#FF3020");

        return view;
    }

}
