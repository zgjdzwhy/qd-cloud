package com.qdcode.cloud.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文档地址
 *
 * @author 盘古巧搭
 */
@Getter
@AllArgsConstructor
public enum DocumentEnum {

    REDIS_INSTALL("https://github.com/zgjdzwhy/qd-cloud", "Redis 安装文档"),
    TENANT("https://github.com/zgjdzwhy/qd-cloud", "SaaS 多租户文档");
    
    private final String url;
    private final String memo;

}
