package com.qdcode.cloud.module.system.enums;

import com.qdcode.cloud.framework.common.enums.RpcConstants;

/**
 * API 相关的枚举
 *
 * @author 盘古巧搭
 */
public class ApiConstants {

    /**
     * 服务名
     *
     * 注意，需要保证和 spring.application.name 保持一致
     */
    public static final String NAME = "system-server";

    public static final String PREFIX = RpcConstants.RPC_API_PREFIX +  "/system";

    public static final String VERSION = "1.0.0";

}
