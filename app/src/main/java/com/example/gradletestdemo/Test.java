package com.example.gradletestdemo;

import android.view.View;

/**
 * Created by zxb in 2021/3/25
 */
public class Test {

    public void onCLick(View view){
        if (FastClickUtil.isFastDoubleClick()){
            return;
        }
    }
}
