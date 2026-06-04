package com.smartspeaker.service;

import com.smartspeaker.entity.AlarmRecord;
import java.util.List;

public interface AlarmService {
    List<AlarmRecord> getAlarmsByDeviceId(Long deviceId);
    List<AlarmRecord> getUnclearedAlarms(Long deviceId);
    List<AlarmRecord> getAlarmsByType(Long deviceId, String alarmType);
    void clearAlarm(Long alarmId);
    void cleanOldAlarms(int daysToKeep);
}
