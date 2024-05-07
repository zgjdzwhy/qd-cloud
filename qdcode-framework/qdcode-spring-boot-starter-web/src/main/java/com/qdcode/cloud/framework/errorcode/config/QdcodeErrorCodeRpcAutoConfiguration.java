package com.qdcode.cloud.framework.errorcode.config;

import com.qdcode.cloud.module.system.api.errorcode.ErrorCodeApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 错误码用到 Feign 的配置项
 *
 * @author 盘古巧搭
 */
@AutoConfiguration
@EnableFeignClients(clients = ErrorCodeApi.class) // 主要是引入相关的 API 服务
public class QdcodeErrorCodeRpcAutoConfiguration {
}
