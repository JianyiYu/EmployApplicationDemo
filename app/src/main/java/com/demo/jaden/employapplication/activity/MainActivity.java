package com.demo.jaden.employapplication.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
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

public class MainActivity extends AppCompatActivity implements JobListFragment.OnListFragmentInteractionListener,
        ConversationFragment.OnFragmentInteractionListener, SettingFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    private FragmentTransaction transaction;

    private FragmentManager fragmentManager;

    private JobListFragment jobListFragment = new JobListFragment();

    private ConversationFragment conversationFragment = new ConversationFragment();

    private SettingFragment settingFragment = new SettingFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_job:
                    showJobListFragment();
                    return true;
                case R.id.navigation_msg:
                    showConversationFragment();
                    return true;
                case R.id.navigation_me:
                    showSettingFragment();
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
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.content, jobListFragment);
        transaction.commit();
    }

    private void showJobListFragment(){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.content, jobListFragment);
        transaction.commit();
    }

    private void showConversationFragment(){

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.content, conversationFragment);
        transaction.commit();
    }

    private void showSettingFragment(){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.content, settingFragment);
        transaction.commit();
    }

    @Override
    public void onListFragmentInteraction(JobContent.JobItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
