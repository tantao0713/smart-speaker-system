package com.smartspeaker.service;

import com.smartspeaker.entity.DeviceHistory;
import java.time.LocalDateTime;
import java.util.List;

public interface HistoryService {
    List<DeviceHistory> getHistoryByDeviceId(Long deviceId);
    List<DeviceHistory> getHistoryByTimeRange(Long deviceId, LocalDateTime startTime, LocalDateTime endTime);
    List<DeviceHistory> getHistoryByType(Long deviceId, String recordType);
    void cleanOldHistory(int daysToKeep);
}
