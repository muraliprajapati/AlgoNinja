package com.teamdroid.algoninja;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Murali on 16-06-2015.
 */
public class DescriptionTabFragment extends Fragment {
    public AlgorithmLab algorithmLab;
    TextView algorithmDescriptionTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        algorithmLab = new AlgorithmLab(getActivity());

        ArrayList<Algorithm> myDataset = algorithmLab.getAlgorithmArrayList();
        View view = inflater.inflate(R.layout.fragment_description_tab, container, false);
        algorithmDescriptionTextView = (TextView)view.findViewById(R.id.algorithmDescriptionTextView);
        algorithmDescriptionTextView.setText(myDataset.get(getArguments().getInt(AlgoDetailActivity.ALGO_INDEX)).getDescription());
        return view;
    }
}
