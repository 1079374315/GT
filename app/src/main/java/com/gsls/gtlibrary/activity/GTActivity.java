package com.gsls.gtlibrary.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.util.GT;

public class GTActivity extends GT.AnnotationActivity{

    @GT.Annotations.GT_View(R.id.my_btn)
    private Button btn;

    @Override
    protected void initView() {
        build(this);
        log("基类 Activity 测试成功！ ");
        log("btn:" + btn);
    }
}
