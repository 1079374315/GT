package com.gsls.gtlibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gsls.gtlibrary.entity.LoginBean;
import com.gsls.gtlibrary.util.GT;

@GT.Annotations.GT_Activity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @GT.Annotations.GT_View(R.id.tv)
    private TextView tv;

    @GT.Annotations.GT_View(R.id.btn)
    private Button btn;

    @GT.Annotations.GT_Object(valueString = "我的账号",valueInt = 21,types = {GT.Annotations.GT_Object.TYPE.STRING, GT.Annotations.GT_Object.TYPE.INT},functions = {"setUsername","setAge"})
    private LoginBean loginBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GT.getGT().setCONTEXT(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(loginBean.toString());
                GT.log_e("实体类实验:" + loginBean);
            }
        });

    }

    @GT.Annotations.GT_Click({R.id.btn1,R.id.btn2,R.id.btn3})
    public void setOnClickListener(View view){
        switch (view.getId()){
            case R.id.btn1:
                GT.toast_s("测试成功1");
                break;

            case R.id.btn2:
                GT.toast_s("测试成功2");
                break;

            case R.id.btn3:
                GT.toast_s("测试成功3");
                break;
        }
    }

}
