package com.gsls.gtlibrary.activity;

import android.os.Bundle;

import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.bean.Book;
import com.gsls.gtlibrary.bean.User;
import com.gsls.gtlibrary.util.GT;

import java.util.List;
import java.util.Set;

@GT.Annotations.GT_Activity(R.layout.activity_main)
public class AndroidActivity extends GT.AnnotationActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        GT.getGT().build(this);


    }

}
