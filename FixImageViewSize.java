package com.pn.app.common.util;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FixImageViewSize {

    public static void adjustWidth(final ImageView view,final int vWidth)
    {
        if(view==null)return;
        if(view.getDrawable()==null)return;
        final int width= view.getDrawable().getIntrinsicWidth();
        final int height= view.getDrawable().getIntrinsicHeight();
        view.post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams vl=view.getLayoutParams();
                vl.height=vWidth*height/width;
                vl.width=vWidth;
                view.setLayoutParams(vl);
            }
        });

    }

    public static void adjustWidth(final ImageView view,final int vWidth,final onFixListener onFixListener)
    {
        if(view==null)return;
        if(view.getDrawable()==null)return;
        final int width= view.getDrawable().getIntrinsicWidth();
        final int height= view.getDrawable().getIntrinsicHeight();
        view.post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams vl=view.getLayoutParams();
                vl.height=vWidth*height/width;
                vl.width=vWidth;
                view.setLayoutParams(vl);
                float ratio=1.0f*vWidth/width;
                onFixListener.onFix(ratio,vl.width,vl.height);
            }
        });

    }

    public static void adjustHeight(final ImageView view,final int vHeight)
    {
        if(view==null)return;
        if(view.getDrawable()==null)return;
        final int width= view.getDrawable().getIntrinsicWidth();
        final int height= view.getDrawable().getIntrinsicHeight();
        view.post(new Runnable() {
            @Override
            public void run() {
                int vWidth=view.getWidth();
                ViewGroup.LayoutParams vl=view.getLayoutParams();
                vl.height=vHeight;
                vl.width=vHeight*width/height;
                view.setLayoutParams(vl);
            }
        });

    }

    public interface onFixListener
    {
        public void onFix(float ratio,int width,int height);
    }
}
