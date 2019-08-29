package com.gsls.gtlibrary.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gsls.gtlibrary.R;
import com.gsls.gtlibrary.activity.GTActivity;
import com.gsls.gtlibrary.entity.LoginBean;
import com.gsls.gtlibrary.util.GT;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class FragmentA extends GT.GT_Fragment.BaseFragments {

    @GT.Annotations.GT_View(R.id.btn)
    private Button btn;

    @GT.Annotations.GT_Object(valueString = "1076",valueInt = 21,types = {GT.Annotations.GT_Object.TYPE.STRING, GT.Annotations.GT_Object.TYPE.INT}, functions = {"setUsername","setAge"})
    private LoginBean loginBean;

    @GT.Annotations.GT_Res.GT_Drawable(R.drawable.ic_launcher_background)
    private Drawable btnBG;

    @GT.Annotations.GT_Res.GT_Layout(R.layout.activity_main)
    private View layout;

    @GT.Annotations.GT_Collection.GT_List({Fragment_1.class,Fragment_2.class,Fragment_3.class})
    List<Object> fragmentList;

    @GT.Annotations.GT_Collection.GT_Map({Fragment_1.class,Fragment_2.class,Fragment_3.class})
    Map<Object,Object> fragmentMap;

    @GT.Annotations.GT_Collection.GT_Set({Fragment_1.class,Fragment_2.class,Fragment_3.class})
    Set<Object> fragmentSet;

    @Override
    protected int loadLayout() {
        return R.layout.fragment1_my;
    }

    @Override
    protected void initView(@NonNull View view, @Nullable Bundle savedInstanceState) {
        GT.getGT().build(this,view);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GT.log_i("Fragment 我的测试成功!");
                GT.log_i("loginBean:" + loginBean);
                GT.log_i("btnBG:" + btnBG);
                GT.log_i("layout:" + layout);
                GT.log_i("fragmentList:" + fragmentList);
                GT.log_i("fragmentMap:" + fragmentMap);
                GT.log_i("fragmentSet:" + fragmentSet);
                GT.startAct(GTActivity.class);

            }
        });

    }

    @GT.Annotations.GT_Click({R.id.f_btn1,R.id.f_btn2,R.id.f_btn3})
    public void fragment_click(View view){

        switch (view.getId()) {
            case R.id.f_btn1:
                GT.log_e("单击 1 号");
                break;

            case R.id.f_btn2:
                GT.log_e("单击 2 号");
                break;

            case R.id.f_btn3:
                GT.log_e("单击 3 号");
                break;
        }
    }

}
