package com.smartspeaker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 设备历史数据实体类
 * 对应数据库 device_history 表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceHistory {
    private Long id;
    private Long deviceId;
    private String recordType;
    private String oldValue;
    private String newValue;
    private Integer batteryPercentage;
    private Double batteryVoltage;
    private Long continuousRunTime;
    private Integer chargeStatus;
    private LocalDateTime recordTime;
}
