package com.gsls.gtlibrary.activity;

import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.AppUtils;
import com.google.gson.Gson;
import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.util.GT;

import java.util.HashMap;
import java.util.Map;

@GT.Annotations.GT_Activity(R.layout.activity_main)
public class AndroidActivity extends GT.AnnotationActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        build(this);//绑定 Activity
        GT.AppDataPool.External.init(this, 123456);
        GT.getGT().setGtLogTf(true);
    }

    @GT.Annotations.GT_Click({R.id.btn1, R.id.btn2,R.id.btn3,R.id.btn4})
    public void viewClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                log("保存");
                GT.AppDataPool.External.saveDataPool("name", "何彭");
                break;
            case R.id.btn2:
                log("查询");
//                Object name = GT.AppDataPool.External.queryDataPool("com.gsls.gtlibrary", 123456, "name");
//                log("跨APP读取的数据:" + name);

                Object name = GT.AppDataPool.External.queryDataPool("name");
                log("读取的数据:" + name);

                break;
            case R.id.btn3:
                log("修改");
                GT.AppDataPool.External.updateDataPool("name","HP");
                break;
            case R.id.btn4:
                log("删除");
                GT.AppDataPool.External.deleteDataPool("name");
                break;
        }
    }


}
