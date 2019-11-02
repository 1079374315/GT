package com.gsls.gtlibrary.activity;

import android.os.Bundle;

import com.gsls.gtlibrary.util.GT;

public class TestActivity extends GT.AnnotationActivity{

    @Override
    protected void initView(Bundle savedInstanceState) {

        Object animal = GT.AppDataPool.Interior.queryDataPool(AndroidActivity.class, "animal");
        Object aandroidActivityBundleaa = GT.AppDataPool.Interior.queryDataPool(AndroidActivity.class, "androidActivityBundle");

        log("TestActivity:" + animal);
        log("aandroidActivityBundleaa:" + aandroidActivityBundleaa);

        if(aandroidActivityBundleaa instanceof Bundle){
            Bundle aandroidActivityBundleaa1 = (Bundle) aandroidActivityBundleaa;
            int id = aandroidActivityBundleaa1.getInt("id");
            String name = aandroidActivityBundleaa1.getString("name");
            log("id:" + id);
            log("name:" + name);
        }

        GT.AppDataPool.Interior.updateDataPool(AndroidActivity.class,"animal","111111111");
        GT.AppDataPool.Interior.deleteDataPool(AndroidActivity.class,"androidActivityBundle");

        log("修改过后的数据：" + GT.AppDataPool.Interior.queryDataPool(AndroidActivity.class, "animal"));
        log("删除过后的数据：" + GT.AppDataPool.Interior.queryDataPool(AndroidActivity.class, "androidActivityBundle"));

    }
}
