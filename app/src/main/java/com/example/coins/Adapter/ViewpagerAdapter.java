package com.example.coins.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.coins.R;

public class ViewpagerAdapter extends PagerAdapter {
    Context context;

    int images[]={
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,

    };
    int firsts[]={
            R.string.first1,
            R.string.first2,
            R.string.first3,

    };
    int seconds[]={
            R.string.second1,
            R.string.second2,
            R.string.second3,

    };
    int thirts[]={
            R.string.thirt1,
            R.string.thirt2,
            R.string.thirt3,

    };

    public ViewpagerAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view= LayoutInflater.from(context).inflate(R.layout.slider_item,container,false);

        ImageView imageView = view.findViewById(R.id.images);
        TextView first = view.findViewById(R.id.head);
        TextView scond = view.findViewById(R.id.second);
        TextView thirt = view.findViewById(R.id.thirt);


        imageView.setImageResource(images[position]);
        first.setText(firsts[position]);
        scond.setText(seconds[position]);
        thirt.setText(thirts[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((LinearLayout)object);
    }
}
