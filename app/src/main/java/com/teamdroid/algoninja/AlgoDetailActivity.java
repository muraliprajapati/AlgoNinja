package com.teamdroid.algoninja;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import io.karim.MaterialTabs;

/**
 * Created by Murali on 16-06-2015.
 */
public class AlgoDetailActivity extends AppCompatActivity {
    public static final String ALGO_NAME = "com.teamdroid.algoninja.algoName";
    public static final String ALGO_INDEX = "com.teamdroid.algoninja.algoIndex";
    ViewPager viewPager;
    MaterialTabs mTabs;
    String[] tabName;
    Toolbar toolbar;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MY_APP_LOG", "onCreate called");
        String algo_name = getIntent().getStringExtra(ALGO_NAME);
        setContentView(R.layout.activity_algo_detail);
        toolbar = (Toolbar) findViewById(R.id.appBar);
        //toolbar.setTitle(algo_name);

        setSupportActionBar(toolbar);

        //String algo_name = getIntent().getStringExtra(ALGO_NAME);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(algo_name);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        index = getIntent().getIntExtra(ALGO_INDEX, 0);

        Log.i("MY_APP_LOG", "ToolBar title set");


        tabName = getResources().getStringArray(R.array.TabName);
        viewPager = (ViewPager) findViewById(R.id.pager);
        mTabs = (MaterialTabs) findViewById(R.id.material_tabs);

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Bundle bundle = new Bundle();
                bundle.putInt(ALGO_INDEX, index);
                Fragment fragment = null;
                if (position == 0) {
                    fragment = new DescriptionTabFragment();
                    fragment.setArguments(bundle);
                }

                if (position == 1) {
                    fragment = new CodeTabFragment();
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabName[position];
            }
        });
        mTabs.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.algo_detail_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }
}
