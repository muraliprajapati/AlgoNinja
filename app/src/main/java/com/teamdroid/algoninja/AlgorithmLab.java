package com.teamdroid.algoninja;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Murali on 25-06-2015.
 */
public class AlgorithmLab {

    ArrayList<Algorithm> algorithmArrayList;
    String[] algorithmName;
    String[] algorithmDescription;
    Context context;

    public AlgorithmLab(Context context) {
        this.context = context;
        algorithmArrayList = new ArrayList<>();
        algorithmName = context.getResources().getStringArray(R.array.algorithm_name);
        algorithmDescription = context.getResources().getStringArray(R.array.algorithm_description);
        for (int i = 0; i < algorithmName.length && i<algorithmDescription.length; i++) {
            Algorithm algorithm = new Algorithm();
            algorithm.setName(algorithmName[i]);
            algorithm.setDescription(algorithmDescription[i]);
            algorithmArrayList.add(algorithm);
            Log.i("MY_APP_LOG", "Algorithm added to list");
        }

        Log.i("MY_APP_LOG", "Algorithm list create");
    }

    public ArrayList<Algorithm> getAlgorithmArrayList() {

        return algorithmArrayList;
    }


    public Algorithm getAlgorithm(UUID algorithmID) {
        for (Algorithm algorithm : algorithmArrayList) {
            if (algorithm.getAlgorithmID().equals(algorithmID)) {
                return algorithm;
            }
        }
        return null;
    }
}
