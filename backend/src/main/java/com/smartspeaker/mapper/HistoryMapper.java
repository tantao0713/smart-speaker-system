package com.smartspeaker.mapper;

import com.smartspeaker.entity.DeviceHistory;
import org.apache.ibatis.annotations.Mapper;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface HistoryMapper {
    int insert(DeviceHistory history);
    List<DeviceHistory> selectByDeviceId(Long deviceId);
    List<DeviceHistory> selectByDeviceIdAndTime(Long deviceId, LocalDateTime startTime, LocalDateTime endTime);
    List<DeviceHistory> selectByDeviceIdAndType(Long deviceId, String recordType);
    int deleteByDeviceId(Long deviceId);
    int deleteBeforeTime(LocalDateTime beforeTime);
}
