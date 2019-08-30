package com.gsls.gtlibrary.activity;

import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.util.GT;

@GT.Annotations.GT_Activity(R.layout.activity_main)
public class MainActivity extends GT.AnnotationActivity {

    @Override
    protected void initView() {
        build(this);
        log("运行成功！");
    }

}
