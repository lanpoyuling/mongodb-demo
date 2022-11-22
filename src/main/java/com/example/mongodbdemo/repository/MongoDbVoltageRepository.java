package com.example.mongodbdemo.repository;

import com.example.mongodbdemo.entity.Voltage;
import org.reactivestreams.Publisher;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Repository
public class MongoDbVoltageRepository implements VoltageRepository{

    @Resource
    private ReactiveMongoTemplate reactiveMongoTemplate;
    @Override
    public <S extends Voltage> Mono<S> save(S entity) {
        Mono<S> save = reactiveMongoTemplate.save(entity);
        return save;
    }

    @Override
    public <S extends Voltage> Flux<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Voltage> Flux<S> saveAll(Publisher<S> entityStream) {
        return null;
    }

    @Override
    public Mono<Voltage> findById(Long aLong) {
        return null;
    }

    @Override
    public Mono<Voltage> findById(Publisher<Long> id) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Long aLong) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<Long> id) {
        return null;
    }

    @Override
    public Flux<Voltage> findAll() {
        return null;
    }

    @Override
    public Flux<Voltage> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public Flux<Voltage> findAllById(Publisher<Long> idStream) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Long aLong) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<Long> id) {
        return null;
    }

    @Override
    public Mono<Void> delete(Voltage entity) {
        return null;
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<? extends Long> longs) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends Voltage> entities) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends Voltage> entityStream) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
