package com.qdcode.cloud.module.report.framework.jmreport.config;

import com.qdcode.cloud.framework.security.config.SecurityProperties;
import com.qdcode.cloud.module.system.api.oauth2.OAuth2TokenApi;
import com.qdcode.cloud.module.report.framework.jmreport.core.service.JmReportTokenServiceImpl;
import org.jeecg.modules.jmreport.api.JmReportTokenServiceI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 积木报表的配置类
 *
 * @author 盘古巧搭
 */
@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = "org.jeecg.modules.jmreport") // 扫描积木报表的包
public class JmReportConfiguration {

    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public JmReportTokenServiceI jmReportTokenService(OAuth2TokenApi oAuth2TokenApi, SecurityProperties securityProperties) {
        return new JmReportTokenServiceImpl(oAuth2TokenApi, securityProperties);
    }

}
