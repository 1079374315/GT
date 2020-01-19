package com.gsls.gtlibrary.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gsls.gtlibrary.util.GT;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * @在APP内部查询的方法
         * @参数一：查询的 Key 值
         */
        Object gt_key = GT.AppDataPool.External.queryDataPool("GT_Key");

        //如果当前 Object 属于 String[]
        if(gt_key instanceof String[]){

            //强转数据类型
            String[] appArray = (String[]) gt_key;

            for(String str : appArray){
                GT.log("str:" + str);
            }
            
        }

    }
}
