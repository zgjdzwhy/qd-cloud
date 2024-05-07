package com.qdcode.cloud.module.system.api.logger;

import com.qdcode.cloud.framework.common.pojo.CommonResult;
import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogCreateReqDTO;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2CreateReqDTO;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2PageReqDTO;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2RespDTO;
import com.qdcode.cloud.module.system.enums.ApiConstants;
import feign.QueryMap;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO 巧搭：fallbackFactory =
@Tag(name = "RPC 服务 - 操作日志")
public interface OperateLogApi {

    String PREFIX = ApiConstants.PREFIX + "/operate-log";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "创建操作日志")
    CommonResult<Boolean> createOperateLog(@Valid @RequestBody OperateLogCreateReqDTO createReqDTO);

    @PostMapping(PREFIX + "/create-v2")
    @Operation(summary = "创建操作日志")
    CommonResult<Boolean> createOperateLogV2(@Valid OperateLogV2CreateReqDTO createReqDTO);

    @PostMapping(PREFIX + "/page")
    @Operation(summary = "获取指定模块的指定数据的操作日志分页")
    CommonResult<PageResult<OperateLogV2RespDTO>> getOperateLogPage(@QueryMap OperateLogV2PageReqDTO pageReqVO);

}
