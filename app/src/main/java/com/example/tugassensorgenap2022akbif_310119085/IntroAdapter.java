package com.example.tugassensorgenap2022akbif_310119085;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;
//10119085,Arif Abdan Syakur,IF-3
public class IntroAdapter extends PagerAdapter {

    Context context;
    List<ScreenItem> ListScreen;

    public IntroAdapter(Context context, List<ScreenItem> listScreen) {
        this.context = context;
        ListScreen = listScreen;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen, null);

        TextView screen_title = layoutScreen.findViewById(R.id.screen_title);
        TextView screen_decs = layoutScreen.findViewById(R.id.screen_decs);
        TextView screen_swipe = layoutScreen.findViewById(R.id.screen_swipe);

        screen_title.setText(ListScreen.get(position).getScreen_title());
        screen_decs.setText(ListScreen.get(position).getScreen_desc());
        screen_swipe.setText(ListScreen.get(position).getScreen_swipe());

        container.addView(layoutScreen);

        return layoutScreen;


    }

    @Override
    public int getCount() {
        return ListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
