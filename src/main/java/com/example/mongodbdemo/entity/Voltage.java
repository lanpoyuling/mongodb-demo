package com.example.mongodbdemo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Document
@Data
public class Voltage extends AbstractDocument{
    /**
     * 测点名称
     */
    private String measuringPointName;
    /**
     * 测点名称code
     */
    private String measuringPointCode;
    /**
     * 测点设备标识
     */
    private String measuringPointDeviceId;
    /**
     * 电压等级
     */
    private String voltageLevel;
    /**
     * 电压类型
     */
    private String voltageType;
    /**
     * 电压单位 (V,mV,μV,kV)
     */
    private String voltageUnit;

    /**
     * 容量
     */
    private String capacity;
    /**
     * 有功负荷
     */
    private BigDecimal activeLoad;
    /**
     * 无功负荷
     */
    private BigDecimal reactiveLoad;
    /**
     * 负载率
     */
    private String loadFactor;
    /**
     * 采集时间戳
     */
    private Timestamp collectionTimestamp;

}
