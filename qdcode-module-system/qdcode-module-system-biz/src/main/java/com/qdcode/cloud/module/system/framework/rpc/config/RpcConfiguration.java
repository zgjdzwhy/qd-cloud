package com.qdcode.cloud.module.system.framework.rpc.config;

import com.qdcode.cloud.module.infra.api.file.FileApi;
import com.qdcode.cloud.module.infra.api.websocket.WebSocketSenderApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {FileApi.class, WebSocketSenderApi.class})
public class RpcConfiguration {
}
