package com.qdcode.cloud.framework.operatelog.config;

import com.qdcode.cloud.framework.operatelog.core.aop.OperateLogAspect;
import com.qdcode.cloud.framework.operatelog.core.service.OperateLogFrameworkService;
import com.qdcode.cloud.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.qdcode.cloud.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class QdcodeOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
