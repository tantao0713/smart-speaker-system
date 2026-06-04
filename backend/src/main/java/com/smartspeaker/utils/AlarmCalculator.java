package com.smartspeaker.utils;

/**
 * 告警计算工具类
 */
public class AlarmCalculator {
    public static final int VOLUME_THRESHOLD = 90;
    public static final int LOW_BATTERY_THRESHOLD = 10;
    
    public static boolean shouldTriggerVolumeAlarm(int newVolume, int oldVolume) {
        return oldVolume <= VOLUME_THRESHOLD && newVolume > VOLUME_THRESHOLD;
    }
    
    public static boolean shouldClearVolumeAlarm(int newVolume, int oldVolume) {
        return oldVolume > VOLUME_THRESHOLD && newVolume <= VOLUME_THRESHOLD;
    }
    
    public static boolean shouldTriggerLowBatteryAlarm(int newBattery, int oldBattery) {
        return oldBattery > LOW_BATTERY_THRESHOLD && newBattery <= LOW_BATTERY_THRESHOLD;
    }
    
    public static boolean shouldClearLowBatteryAlarm(int newBattery, int oldBattery) {
        return oldBattery <= LOW_BATTERY_THRESHOLD && newBattery > LOW_BATTERY_THRESHOLD;
    }
    
    public static boolean isOverRunTime(long continuousRunTime, long maxSafeRunTime) {
        return continuousRunTime >= maxSafeRunTime;
    }
    
    public static int calculateBatteryPercentage(
            double currentVoltage,
            double maxVoltage,
            double minVoltage) {
        
        if (currentVoltage < minVoltage) {
            return 0;
        }
        if (currentVoltage > maxVoltage) {
            return 100;
        }
        
        double percentage = (currentVoltage - minVoltage) / (maxVoltage - minVoltage) * 100;
        return Math.min(100, Math.max(0, (int) percentage));
    }
}
