package com.gsls.gtlibrary;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.gsls.gtlibrary.util.GT;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GT.Window.fullScreen(this);                 //设置全屏模式
        setContentView(R.layout.activity_main);

        GT.Game.startGameWindow(this);//开启游戏的 沉浸式模式

    }

}
