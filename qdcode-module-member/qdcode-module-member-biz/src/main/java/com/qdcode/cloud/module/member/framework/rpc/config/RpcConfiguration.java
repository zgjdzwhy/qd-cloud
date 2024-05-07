package com.qdcode.cloud.module.member.framework.rpc.config;

import com.qdcode.cloud.module.system.api.logger.LoginLogApi;
import com.qdcode.cloud.module.system.api.sms.SmsCodeApi;
import com.qdcode.cloud.module.system.api.social.SocialClientApi;
import com.qdcode.cloud.module.system.api.social.SocialUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {SmsCodeApi.class, LoginLogApi.class, SocialUserApi.class, SocialClientApi.class})
public class RpcConfiguration {
}
