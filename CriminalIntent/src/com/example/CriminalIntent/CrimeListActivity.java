package com.example.CriminalIntent;

import android.support.v4.app.Fragment;

/**
 * Created by Daniel on 4/1/14.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
