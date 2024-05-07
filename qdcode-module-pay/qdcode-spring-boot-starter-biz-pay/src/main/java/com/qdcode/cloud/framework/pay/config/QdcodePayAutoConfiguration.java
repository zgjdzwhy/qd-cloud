package com.qdcode.cloud.framework.pay.config;

import com.qdcode.cloud.framework.pay.core.client.PayClientFactory;
import com.qdcode.cloud.framework.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 支付配置类
 *
 * @author 盘古巧搭
 */
@AutoConfiguration
public class QdcodePayAutoConfiguration {

    @Bean
    public PayClientFactory payClientFactory() {
        return new PayClientFactoryImpl();
    }

}
