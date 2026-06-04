package com.smartspeaker.service;

import com.smartspeaker.entity.Device;
import java.util.List;

public interface DeviceService {
    Device registerDevice(Device device);
    Device getDeviceById(Long id);
    Device getDeviceBySerialNumber(String deviceSn);
    List<Device> getAllDevices();
    void updateDevice(Device device);
    void deleteDevice(Long id);
}
