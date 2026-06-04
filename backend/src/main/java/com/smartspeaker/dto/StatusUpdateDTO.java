package com.smartspeaker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设备状态更新 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusUpdateDTO {
    private String deviceSn;
    private Long deviceId;
    private Integer powerSwitch;
    private Integer volume;
    private Integer lightSwitch;
    private Integer batteryPercentage;
    private Integer chargeStatus;
    private Double currentBatteryVoltage;
    private Long runStartTime;
}
