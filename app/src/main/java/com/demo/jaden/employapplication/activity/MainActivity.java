package com.demo.jaden.employapplication.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.demo.jaden.employapplication.R;
import com.demo.jaden.employapplication.fragment.ConversationFragment;
import com.demo.jaden.employapplication.fragment.CoversationContent;
import com.demo.jaden.employapplication.fragment.JobListFragment;
import com.demo.jaden.employapplication.fragment.JobContent;
import com.demo.jaden.employapplication.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JobListFragment.OnListFragmentInteractionListener,
        ConversationFragment.OnFragmentInteractionListener, SettingFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    private FragmentTransaction transaction;

    private FragmentManager fragmentManager;

    private JobListFragment jobListFragment;

    private ConversationFragment conversationFragment;

    private SettingFragment settingFragment;

    private List<Fragment> fragments;

    private int currentFragmentIndex;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_job:
                    switchFragment(0);
                    return true;
                case R.id.navigation_msg:
                    switchFragment(1);
                    return true;
                case R.id.navigation_me:
                    switchFragment(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setDefaultFragment();
    }

    private void setDefaultFragment(){

        jobListFragment = new JobListFragment();
        conversationFragment = new ConversationFragment();
        settingFragment = new SettingFragment();

        fragments = new ArrayList<Fragment>();
        fragments.add(jobListFragment);
        fragments.add(conversationFragment);
        fragments.add(settingFragment);

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.content, jobListFragment);
        transaction.commit();

        currentFragmentIndex = 0;
    }

    private void switchFragment(int index){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments.get(currentFragmentIndex));      //隐藏当前Fragment
        if(fragments.get(index).isAdded() == false) {
            transaction.add(R.id.content, fragments.get(index));
        }
        transaction.show(fragments.get(index)).commitAllowingStateLoss();
        currentFragmentIndex = index;
    }

    @Override
    public void onListFragmentInteraction(JobContent.JobItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
