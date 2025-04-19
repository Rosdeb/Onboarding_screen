package com.example.coins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.coins.Adapter.ViewpagerAdapter;

public class MainActivity2 extends AppCompatActivity {

    TextView []dots;
    LinearLayout linearLayout;
    ViewPager viewPager ;

    ViewpagerAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//
//        linearLayout=findViewById(R.id.indicator);
////        viewPager=findViewById(R.id.slideViewPager2);
////
////        adapter = new ViewpagerAdapter(this);
////        viewPager.setAdapter(adapter);
//
//        indicator(3);
////        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
////            @Override
////            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
////
////            }
////
////            @Override
////            public void onPageSelected(int position) {
////
////                indicator(position);
////
////            }
////
////            @Override
////            public void onPageScrollStateChanged(int state) {
////
////            }
////        });

        SharedPreferences sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        boolean isFirstLaunch = sharedPreferences.getBoolean("isFirstLaunch", true);

        if (isFirstLaunch) {
            // Go to OnboardingActivity
            startActivity(new Intent(this, MainActivity.class));

            // Set flag to false so next time onboarding doesn't open
            sharedPreferences.edit().putBoolean("isFirstLaunch", false).apply();
        } else {
            // Go to MainActivity
            startActivity(new Intent(this, HomeActivity.class));
        }

        // Finish launcher so user can't return to it
        finish();
    }

    public void indicator(int position){

        dots= new TextView[4];
        linearLayout.removeAllViews();

        for (int i =0 ; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            linearLayout.addView(dots[i]);

        }

        dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));

    }

    private int  getitem(int i){
        return viewPager.getCurrentItem() +1;
    }

}