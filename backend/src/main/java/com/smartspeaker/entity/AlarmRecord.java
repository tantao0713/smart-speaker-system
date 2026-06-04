package com.smartspeaker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 告警记录实体类
 * 对应数据库 alarm_record 表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlarmRecord {
    private Long id;
    private Long deviceId;
    private String alarmType;
    private LocalDateTime alarmTriggerTime;
    private LocalDateTime alarmClearTime;
    private String triggerValue;
    private Integer isCleared;
}
