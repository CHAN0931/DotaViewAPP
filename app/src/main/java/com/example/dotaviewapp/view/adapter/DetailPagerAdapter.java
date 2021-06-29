package com.example.dotaviewapp.view.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dotaviewapp.view.fragment.HeroFragment;
import com.example.dotaviewapp.view.fragment.MatchFragment;

public class DetailPagerAdapter extends FragmentPagerAdapter {

    public DetailPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new MatchFragment();
        else
            return new HeroFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0)
            return "MATCHES";
        else
            return "HEROES";
    }
}
