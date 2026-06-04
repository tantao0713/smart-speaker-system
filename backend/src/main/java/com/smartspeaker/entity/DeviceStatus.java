package com.smartspeaker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 设备实时状态实体类
 * 对应数据库 device_status 表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceStatus {
    private Long id;
    private Long deviceId;
    private Integer powerSwitch;
    private Integer volume;
    private Integer lightSwitch;
    private Integer batteryPercentage;
    private Integer chargeStatus;
    private String chargeIndicatorColor;
    private Long continuousRunTime;
    private Long runStartTime;
    private Integer isOverRunTime;
    private Integer isVolumeWarning;
    private Integer isLowBatteryWarning;
    private LocalDateTime updateTime;
}
