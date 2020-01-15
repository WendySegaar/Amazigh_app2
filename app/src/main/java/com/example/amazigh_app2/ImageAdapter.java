package com.example.amazigh_app2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class ImageAdapter extends PagerAdapter {
    Context context;

    private int[] GalImages = new int[] {

            //Dit moet uit database komen.

            R.drawable.dieren01_egel,
            R.drawable.dieren01_ezel,
            R.drawable.dieren01_paard

            //loop door database
    };
    ImageAdapter(Context context){
        this.context=context;
    }

    public int getCount() {
        return GalImages.length;
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(GalImages[position]);
        ((ViewPager) container).addView(imageView, 0);


        return imageView;
    }

    @Override
    public void
    destroyItem(ViewGroup container, int position, Object object){
        ((ViewPager) container) .removeView((ImageView) object);
    }
}

