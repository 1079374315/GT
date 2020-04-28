package com.gsls.gtlibrary;

import android.app.Application;

import com.gsls.gtlibrary.util.GT;

public class MyApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		GT.log("MyApp");


	}


}
