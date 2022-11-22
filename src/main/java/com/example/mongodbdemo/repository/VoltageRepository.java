package com.example.mongodbdemo.repository;

import com.example.mongodbdemo.entity.Voltage;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface VoltageRepository extends ReactiveCrudRepository<Voltage,Long> {


}
