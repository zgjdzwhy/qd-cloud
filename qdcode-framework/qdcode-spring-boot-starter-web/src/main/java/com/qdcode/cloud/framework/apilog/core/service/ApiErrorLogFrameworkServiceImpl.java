package com.qdcode.cloud.framework.apilog.core.service;

import cn.hutool.core.bean.BeanUtil;
import com.qdcode.cloud.framework.common.pojo.CommonResult;
import com.qdcode.cloud.module.infra.api.logger.ApiErrorLogApi;
import com.qdcode.cloud.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * API 错误日志 Framework Service 实现类
 *
 * 基于 {@link ApiErrorLogApi} 远程服务，记录错误日志
 *
 * @author 盘古巧搭
 */
@RequiredArgsConstructor
public class ApiErrorLogFrameworkServiceImpl implements ApiErrorLogFrameworkService {

    private final ApiErrorLogApi apiErrorLogApi;

    @Override
    @Async
    public void createApiErrorLog(ApiErrorLog apiErrorLog) {
        ApiErrorLogCreateReqDTO reqDTO = BeanUtil.copyProperties(apiErrorLog, ApiErrorLogCreateReqDTO.class);
        apiErrorLogApi.createApiErrorLog(reqDTO).checkError();
    }

}
