package com.gsls.gtlibrary;

import android.os.Bundle;

import com.gsls.gtlibrary.util.GT;

@GT.Annotations.GT_Activity(R.layout.activity_main)
public class MainActivity extends GT.AnnotationActivity {



    @Override
    protected void initView(Bundle savedInstanceState) {
        build(this);//绑定 Activity
    }

}
