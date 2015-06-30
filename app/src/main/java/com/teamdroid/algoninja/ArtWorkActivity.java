package com.teamdroid.algoninja;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Murali on 24-06-2015.
 */
public class ArtWorkActivity extends FragmentActivity {
    ViewPager artWorkViewPager;
    Button skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_work);
        skipButton = (Button)findViewById(R.id.skipButton);
        artWorkViewPager = (ViewPager) findViewById(R.id.artWorkViewPager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        artWorkViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {



                if (position == 0) {
                    return ArtWorkFragment.newInstance(R.drawable.one);
                }

                if (position == 1) {
                    return ArtWorkFragment.newInstance(R.drawable.two);
                }
                if (position == 2) {
                    return ArtWorkFragment.newInstance(R.drawable.three);
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
