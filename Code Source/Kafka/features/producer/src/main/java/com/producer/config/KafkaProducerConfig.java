package com.producer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.producer")
public class KafkaProducerConfig {

    @Value("${spring.kafka.producer.bootstrap-servers: localhost:9092}")
    private String bootstrapServers;

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Json Producer
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // @Bean
    public <T> ProducerFactory<String, T> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();

        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.ACKS_CONFIG, "all");
        configProps.put(ProducerConfig.RETRIES_CONFIG, 3);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        // **___ configure the following three settings for SSL Encryption ___**
        //configProps.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
        //configProps.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "/var/private/ssl/kafka.client.truststore.jks");
        //configProps.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, "test1234");

        // **___configure the following three settings for SSL Authentication ___**
        //configProps.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, "/var/private/ssl/kafka.client.keystore.jks");
        //configProps.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, "test1234");
        //configProps.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, "test1234");

        return new DefaultKafkaProducerFactory<>(configProps);
    }

//    public WebClient.Builder webClientBuilder(){
//        return WebClient.Builder();
//    }
}
