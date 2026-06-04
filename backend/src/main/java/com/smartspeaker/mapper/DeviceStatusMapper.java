package com.smartspeaker.mapper;

import com.smartspeaker.entity.DeviceStatus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceStatusMapper {
    int insert(DeviceStatus status);
    int update(DeviceStatus status);
    DeviceStatus selectByDeviceId(Long deviceId);
    DeviceStatus selectById(Long id);
    int deleteByDeviceId(Long deviceId);
}
