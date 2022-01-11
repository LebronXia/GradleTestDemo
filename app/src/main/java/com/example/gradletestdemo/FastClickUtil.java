package com.example.gradletestdemo;

/**
 * Created by zxb in 2021/3/24
 */
public class FastClickUtil {
    private static final int FAST_CLICK_TIME_DISTANCE = 300;
    private static long sLastClickTime = 0;

    public static boolean isFastDoubleClick(){
        long time = System.currentTimeMillis();
        long timeDistance = time - sLastClickTime;
        if (0 < timeDistance && timeDistance < FAST_CLICK_TIME_DISTANCE) {
            return true;
        }
        sLastClickTime = time;
        return false;
    }
}
