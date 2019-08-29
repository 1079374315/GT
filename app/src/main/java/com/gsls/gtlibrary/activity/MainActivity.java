package com.gsls.gtlibrary.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.fragment.FragmentA;
import com.gsls.gtlibrary.util.GT;

@GT.Annotations.GT_Activity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @GT.Annotations.GT_View(R.id.btn)
    private Button btn;

    @GT.Annotations.GT_Res.GT_String(R.string.app_name)
    private String appName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GT.getGT().build(this);

        GT.GT_Fragment.getGT_fragment()
                .initFragment(savedInstanceState,this,getSupportFragmentManager())
                .loadFragment(R.id.frameLayout,new FragmentA());



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GT.log_e("appName:" + appName);
            }
        });

    }

    @GT.Annotations.GT_Click({R.id.btn1,R.id.btn2,R.id.btn3})
    public void setOnClickListener(View view){
        switch (view.getId()){
            case R.id.btn1:
                GT.log_e("appName:" + appName);
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
