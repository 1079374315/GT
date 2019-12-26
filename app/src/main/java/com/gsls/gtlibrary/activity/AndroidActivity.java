package com.gsls.gtlibrary.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;

import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.util.GT;

@GT.Annotations.GT_Activity(R.layout.activity_main)
public class AndroidActivity extends GT.AnnotationActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        build(this);//绑定 Activity

    }

}
