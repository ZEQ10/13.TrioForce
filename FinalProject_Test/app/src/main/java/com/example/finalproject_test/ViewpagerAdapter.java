package com.example.finalproject_test;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewpagerAdapter extends FragmentStateAdapter {


    public ViewpagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewpagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new storage_createdFragment();
            case 1:
                return new storage_bookmarkedFragment();
            case 2:
                return new storage_progressFragment();
            default:
                return new storage_createdFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
