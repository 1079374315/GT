package com.gsls.gtlibrary.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.gsls.gtlibrary.util.GT;


public class Fragment_1 extends Fragment {

    public static Fragment_1 newInstance() {
        Bundle args = new Bundle();
        GT.log_i("Fragment_1 newInstance");
        Fragment_1 fragment = new Fragment_1();
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_1(){
        GT.log_i("Fragment_1");
    }

}
