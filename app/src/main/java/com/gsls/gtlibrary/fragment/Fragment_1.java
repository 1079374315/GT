package com.gsls.gtlibrary.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.util.GT;


public class Fragment_1 extends GT.GT_Fragment.BaseFragments {

    @Override
    protected int loadLayout() {
        return R.layout.fragment1_my;
    }

    @Override
    protected void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        build(this,view);
    }

}
