package com.app.fringale.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.app.fringale.Activities.SplashActivity2;
import com.app.fringale.R;
import com.app.fringale.StaticModels.ViewPagerAdapterModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class ViewPagerAdapter extends PagerAdapter {

    private final ArrayList<ViewPagerAdapterModel> arraylist;
    // Context object
    Context context;



    // Layout Inflater
    LayoutInflater mLayoutInflater;
    BottomSheetBehavior<View>bottomSheetBehavior;



    // Viewpager Constructor
    public ViewPagerAdapter( Context context,ArrayList<ViewPagerAdapterModel> arraylist) {
        this.arraylist = arraylist;
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//    public ViewPagerAdapter(@NotNull SplashActivity2 splashActivity2, @NotNull ArrayList<ViewPagerAdapterModel> arraylist) {
//        this.context = context;
//        this.arraylist = arraylist;
//        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }

    @Override
    public int getCount() {
        // return the number of images
        return arraylist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        // inflating the item.xml
        View itemView = mLayoutInflater.inflate(R.layout.viewpageritem, container, false);

        // referencing the image view from the item.xml file
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageViewMain);
        TextView tvtext1 = (TextView) itemView.findViewById(R.id.tvtext1);
        TextView tvtext2 = (TextView) itemView.findViewById(R.id.tvtext2);

        // setting the image in the imageView
        imageView.setImageResource(arraylist.get(position).getImageview());
        tvtext1.setText(arraylist.get(position).getTitle1());
        tvtext2.setText(arraylist.get(position).getTitle2());

        // Adding the View
        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }


    private void showsongsplaylist(){
        BottomSheetDialog bottomSheet  = new BottomSheetDialog(context);
        BottomSheetBehavior<View> bottomSheetBehavior;
        View bottomshetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_dialog,null);
        bottomSheet.setContentView(bottomshetView);


        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomshetView .getParent());
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        CoordinatorLayout layout = bottomSheet.findViewById(R.id.coordinator);
        assert layout !=null;
        layout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);

        bottomSheet.show();
    }
}
