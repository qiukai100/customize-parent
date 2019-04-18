package com.customize.hbase.config;

import com.customize.hbase.service.HBaseService;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HBaseConfig {

    @Value("${HBase.nodes}")
    private String nodes;

    @Value("${HBase.maxSize}")
    private String maxSize;

    @Bean
    public HBaseService getHbaseService() {
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", nodes);
        conf.set("hbase.client.keyvalue.maxsize", maxSize);
        return new HBaseService(conf);
    }
}
