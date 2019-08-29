package com.gsls.gtlibrary.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.gsls.gtlibrary.util.GT;


public class Fragment_3 extends Fragment {

    public static Fragment_3 newInstance() {
        Bundle args = new Bundle();
        GT.log_i("Fragment_3 newInstance");
        Fragment_3 fragment = new Fragment_3();
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_3(){
        GT.log_i("Fragment_3");
    }

}
