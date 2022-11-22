package com.example.mongodbdemo.repository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import com.example.mongodbdemo.entity.Voltage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MongoDbVoltageRepositoryTest {
    @Resource
    private MongoDbVoltageRepository mongoDbVoltageRepository;
    @Test
    void save() {
        Voltage entity = new Voltage();
        entity.setMeasuringPointName("1");
        entity.setMeasuringPointCode("2");
        entity.setMeasuringPointDeviceId("2112");
        entity.setVoltageLevel("110");
        entity.setVoltageType("1");
        entity.setVoltageUnit("2");
        entity.setCapacity("3");
        entity.setActiveLoad(new BigDecimal("0"));
        entity.setReactiveLoad(new BigDecimal("0"));
        entity.setLoadFactor("dd");
        entity.setCollectionTimestamp(new Timestamp(new java.util.Date().getTime()));

        Mono<Voltage> save = mongoDbVoltageRepository.save(entity);
        BigInteger id = save.block().getId();
        System.err.println(id);
    }
}