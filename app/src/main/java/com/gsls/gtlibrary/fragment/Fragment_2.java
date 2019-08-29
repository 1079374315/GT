package com.gsls.gtlibrary.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.gsls.gtlibrary.util.GT;


public class Fragment_2 extends Fragment {

    public static Fragment_2 newInstance() {
        Bundle args = new Bundle();
        GT.log_i("Fragment_2 newInstance");
        Fragment_2 fragment = new Fragment_2();
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_2(){
        GT.log_i("Fragment_2");
    }

}
