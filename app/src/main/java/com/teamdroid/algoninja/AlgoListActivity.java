package com.teamdroid.algoninja;

import android.app.Fragment;

/**
 * Created by Murali on 14-06-2015.
 */
public class AlgoListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new AlgoListFragment();
    }
}
