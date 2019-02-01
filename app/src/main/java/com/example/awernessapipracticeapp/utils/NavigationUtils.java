package com.example.awernessapipracticeapp.utils;

import android.app.Activity;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import androidx.appcompat.widget.Toolbar;

public class NavigationUtils {

    public static Drawer getDrawer(Activity activity, Toolbar toolbar) {

        final OnNavigationItemClickListener mCallback = (OnNavigationItemClickListener) activity;
        PrimaryDrawerItem activity1 = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName("Today's Attendance")
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        mCallback.OnNavigationItemClicked(1);
                        return false;
                    }
                });

        Drawer drawer = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .addDrawerItems(
                        activity1
                ).build();
        return drawer;
    }


    public interface OnNavigationItemClickListener {
        void OnNavigationItemClicked(int ID);
    }
}
