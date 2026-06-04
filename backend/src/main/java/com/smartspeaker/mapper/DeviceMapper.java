package com.smartspeaker.mapper;

import com.smartspeaker.entity.Device;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DeviceMapper {
    int insert(Device device);
    int update(Device device);
    Device selectById(Long id);
    Device selectByDeviceSn(String deviceSn);
    List<Device> selectAll();
    int deleteById(Long id);
}
