package com.smartspeaker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 设备 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDTO {
    private Long id;
    private String deviceSn;
    private String deviceName;
    private Double maxBatteryVoltage;
    private Double currentBatteryVoltage;
    private Long maxSafeRunTime;
}
