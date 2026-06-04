package com.smartspeaker.utils;

/**
 * 充电指示灯颜色判断工具类
 */
public class ChargeIndicatorUtil {
    public static final String COLOR_OFF = "OFF";
    public static final String COLOR_ORANGE = "ORANGE";
    public static final String COLOR_BLUE = "BLUE";
    public static final String COLOR_GREEN = "GREEN";
    public static final String COLOR_RED = "RED";
    
    private static final int FULL_BATTERY = 100;
    private static final int LOW_BATTERY_THRESHOLD = 10;
    
    public static String determineColor(
            int chargeStatus,
            int powerSwitch,
            int batteryPercentage) {
        
        if (chargeStatus == 1) {
            return COLOR_ORANGE;
        }
        
        if (powerSwitch == 0) {
            return COLOR_OFF;
        }
        
        if (batteryPercentage >= FULL_BATTERY) {
            return COLOR_GREEN;
        } else if (batteryPercentage <= LOW_BATTERY_THRESHOLD) {
            return COLOR_RED;
        } else {
            return COLOR_BLUE;
        }
    }
}
