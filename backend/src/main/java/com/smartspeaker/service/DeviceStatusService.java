package com.smartspeaker.service;

import com.smartspeaker.entity.DeviceStatus;

public interface DeviceStatusService {
    DeviceStatus getStatusByDeviceId(Long deviceId);
    void updateStatus(DeviceStatus newStatus);
    void updatePowerSwitch(Long deviceId, Integer powerSwitch);
    void updateVolume(Long deviceId, Integer volume);
    void updateLightSwitch(Long deviceId, Integer lightSwitch);
    void updateBatteryInfo(Long deviceId, Double currentVoltage, Integer chargeStatus);
    void updateRunningTime(Long deviceId, Long continuousRunTime);
    void checkRunTimeOverflow(Long deviceId);
}
