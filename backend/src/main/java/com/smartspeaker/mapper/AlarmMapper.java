package com.smartspeaker.mapper;

import com.smartspeaker.entity.AlarmRecord;
import org.apache.ibatis.annotations.Mapper;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface AlarmMapper {
    int insert(AlarmRecord alarm);
    int update(AlarmRecord alarm);
    AlarmRecord selectById(Long id);
    List<AlarmRecord> selectByDeviceId(Long deviceId);
    List<AlarmRecord> selectByDeviceIdAndType(Long deviceId, String alarmType);
    List<AlarmRecord> selectUnclearedAlarms(Long deviceId);
    int deleteByDeviceId(Long deviceId);
    int deleteClearedBefore(LocalDateTime beforeTime);
}
