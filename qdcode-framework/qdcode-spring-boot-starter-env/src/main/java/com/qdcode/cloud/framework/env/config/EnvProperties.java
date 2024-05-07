package com.qdcode.cloud.framework.env.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 环境配置
 *
 * @author 盘古巧搭
 */
@ConfigurationProperties(prefix = "qdcode.env")
@Data
public class EnvProperties {

    public static final String TAG_KEY = "qdcode.env.tag";

    /**
     * 环境标签
     */
    private String tag;

}
