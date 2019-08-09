package com.gsls.gtlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gsls.gtlibrary.util.GT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String[] items = {"1 号","2 号","3 号","4 号","5 号"};
        //带有多选项的 对话框
        new GT.GT_AlertDialog(this).dialogSingleChoiceList(R.mipmap.ic_launcher, "标题", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                GT.toast_s(MainActivity.this,"选择了:" + items[i]);
            }
        }).show();


    }

}
