package com.demo.jaden.employapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demo.jaden.employapplication.R;
import com.demo.jaden.employapplication.adapter.ImageViewPagerAdapter;
import com.demo.jaden.employapplication.constants.Constants;
import com.demo.jaden.employapplication.utils.SPreferenceUtil;
import com.demo.jaden.employapplication.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends BaseActivity {

    private String userId = null;
    private String tokenId = null;

    private ViewPager contentView;
    private LinearLayout pointIndicators;
    private Button btnStart;

    private ImageViewPagerAdapter mPageAdapter;
    private Integer[] resList = {R.drawable.welcome_page_01, R.drawable.welcome_page_02, R.drawable.welcome_page_03};
    private List<ImageView> imageViewList;

    private SPreferenceUtil spUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        spUtil = new SPreferenceUtil(this, Constants.USER_EMPLOYEE_PREFERENCE_INFO);

        if(spUtil.getBoolean(Constants.FIRST_ENTER, true)){
            initView();
        }
        else {
            enterApp();
            finish();
        }
    }

    private void initView(){
        contentView = (ViewPager) findViewById(R.id.content);
        pointIndicators = (LinearLayout) findViewById(R.id.point_indicator);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);

        initPageView();
        initPageIndicator();

        contentView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            int lastPosition;
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                pointIndicators.getChildAt(i).setSelected(true);
                pointIndicators.getChildAt(lastPosition).setSelected(false);

                lastPosition = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initPageView(){
        imageViewList = new ArrayList<>();
        for(int i = 0;i < resList.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(resList[i]);

            imageViewList.add(imageView);
        }
        mPageAdapter = new ImageViewPagerAdapter(imageViewList);

        contentView.setAdapter(mPageAdapter);
    }

    private void initPageIndicator(){

        for(int i=0; i < resList.length; i++){
            ImageView ponitIndicator = new ImageView(this);
            ponitIndicator.setImageResource(R.drawable.welcome_page_indicator);
            int pointSize = getResources().getDimensionPixelSize(R.dimen.point_size);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(pointSize, pointSize);

            if(i > 0){
                params.leftMargin = getResources().getDimensionPixelSize(R.dimen.point_margin);
                ponitIndicator.setSelected(false);
            }
            else{
                ponitIndicator.setSelected(true);
            }

            ponitIndicator.setLayoutParams(params);

            pointIndicators.addView(ponitIndicator);
        }
    }

    private boolean hasLogin() {
        userId = spUtil.getString(Constants.USER_ID);
        tokenId = spUtil.getString(Constants.TOKEN_ID);
        if(StringUtil.isEmpty(userId) || StringUtil.isEmpty(tokenId)){
            return false;
        }
        return true;
    }

    private void enterApp() {
        Intent intent;
        if(hasLogin()){
            intent = new Intent(this, MainActivity.class);
        }
        else {
            intent = new Intent(this, PhoneLoginActivity.class);
        }

        intent.putExtra(Constants.USER_ID, userId);
        intent.putExtra(Constants.TOKEN_ID, tokenId);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view == btnStart){
            enterApp();
        }
    }
}
