package com.qdcode.cloud.module.infra.framework.file.config;

import com.qdcode.cloud.module.infra.framework.file.core.client.FileClientFactory;
import com.qdcode.cloud.module.infra.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件配置类
 *
 * @author 盘古巧搭
 */
@Configuration(proxyBeanMethods = false)
public class QdcodeFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
