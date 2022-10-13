package com.aerospike.demo.simplespringbootaerospikedemo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aerospike")
public class AerospikeConfigurationProperties {
    private String host;
    private int port;
    private String namespace;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getNamespace() {
        return namespace;
    }
}
