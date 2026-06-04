package com.smartspeaker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 智能音箱设备实体类
 * 对应数据库 device 表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private Long id;
    private String deviceSn;
    private String deviceName;
    private Double maxBatteryVoltage;
    private Double currentBatteryVoltage;
    private Long maxSafeRunTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
