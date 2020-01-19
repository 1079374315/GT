package com.gsls.gtlibrary.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.util.GT;

/**
 * @APP外部存储数据
 */
public class AndroidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GT.getGT().build(this);

        Log.i("GT_", "你好0");
        GT.LOG.setLogFileTf(true,this);//打开本地打印
//        GT.LOG.setLogFilePath("我的测试1/测试2/最终测试日志文件夹/");
//        GT.LOG.setPrintFileName("我的测试打印文件");
        GT.log("你好1");
        GT.logs("你好2");
        GT.errs("你好3");



     /*   *//**
         * @初始化 APP数据池 密码 此方法只需要调用一次
         * @参数一：是哪个Activity 存的数据
         * @参数二：设置共享数据的密码（为了安全性）
         *//*
        GT.AppDataPool.External.init(this,"paw123456");

        *//**
         * @利用GT存储数据共享给其他APP(可在任何类中使用该方法)
         * @参数一：共享数据的 Key
         * @参数二：共享数据
         *//*
        GT.AppDataPool.External.saveDataPool("GT_Key",new String[]{"APP外部数据池1号","APP外部数据池2号"});

        //设置单击跳转页面
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AndroidActivity.this,TextActivity.class));//跳转页面
            }
        });

        RadioGroup cb = new RadioGroup(this);

        cb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });*/

    }
}
