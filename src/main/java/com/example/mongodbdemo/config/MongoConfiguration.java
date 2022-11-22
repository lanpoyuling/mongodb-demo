package com.example.mongodbdemo.config;

import com.google.common.collect.Lists;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Configuration
@Slf4j
@EnableReactiveMongoRepositories
public class MongoConfiguration {
    @Resource
    private MongoConnectInfo mongoConnectInfo;

    @PostConstruct
    public void init() {
        log.info("mongoConnect:{}", mongoConnectInfo);
    }

    @Bean
    public ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory() {

        List<ServerAddress> hosts = Lists.newArrayList(new ServerAddress(mongoConnectInfo.getHost(),
                mongoConnectInfo.getPort()));


        MongoCredential credential = MongoCredential.createCredential(mongoConnectInfo.getUserName(),
                mongoConnectInfo.getDatabase(),
                mongoConnectInfo.getPassword());
        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .applyToClusterSettings(builder -> builder.hosts(hosts))
                .build();
        MongoClient mongoClient = MongoClients.create(settings);

        return new SimpleReactiveMongoDatabaseFactory(mongoClient, mongoConnectInfo.getDatabase());
    }


    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory());
    }
}
