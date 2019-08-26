package com.gsls.gtlibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gsls.gtlibrary.util.GT;

@GT.Annotations.GT_Activity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @GT.Annotations.GT_View(R.id.tv)
    private TextView tv;

    @GT.Annotations.GT_View(R.id.btn)
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        GT.getGT().setCONTEXT(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("实验成功！");
            }
        });


    }

}
