package com.gsls.gtlibrary.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.util.GT;

@GT.Annotations.GT_Activity(R.layout.activity_main)
public class AndroidActivity extends GT.AnnotationActivity {

    @GT.Annotations.GT_View(R.id.main_tv)
    private Button btn;

    @SuppressLint("WrongConstant")
    @Override
    protected void initView(Bundle savedInstanceState) {
        build(this);//绑定 Activity

        ObjectAnimator translateX = ObjectAnimator.ofFloat(btn, "translationX", 0, 500);
        translateX.setDuration(8000);      //动画执行时间
        translateX.setRepeatCount(2);//执行多少次
        translateX.setRepeatMode(ValueAnimator.REVERSE);//
        translateX.start();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast("你好");
            }
        });

    }

}
