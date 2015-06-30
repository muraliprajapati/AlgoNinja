package com.teamdroid.algoninja;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Murali on 24-06-2015.
 */
public class ArtWorkFragment extends Fragment {
    ImageView imageView;

    public static ArtWorkFragment newInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("image_id",id);
        ArtWorkFragment artWorkFragment = new ArtWorkFragment();
        artWorkFragment.setArguments(bundle);
        return artWorkFragment;
    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_art_work,container,false);
        int image_id =  getArguments().getInt("image_id");
        imageView = (ImageView)view.findViewById(R.id.artWorkImageView);
        imageView.setImageResource(image_id);
        return view;
    }
}
