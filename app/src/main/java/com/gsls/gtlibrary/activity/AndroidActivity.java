package com.gsls.gtlibrary.activity;

import android.os.Bundle;

import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.util.GT;

@GT.Annotations.GT_Activity(R.layout.activity_main)
public class AndroidActivity extends GT.AnnotationActivity {

    @GT.Annotations.GT_Object
   GT.GT_Animation gt_animation;

    @Override
    protected void initView(Bundle savedInstanceState) {
        build(this);//绑定 Activity
        log(gt_animation);

    }

}
