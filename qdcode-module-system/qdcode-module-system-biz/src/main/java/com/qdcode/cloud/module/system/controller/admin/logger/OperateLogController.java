package com.qdcode.cloud.module.system.controller.admin.logger;

import com.qdcode.cloud.framework.common.pojo.CommonResult;
import com.qdcode.cloud.framework.common.pojo.PageParam;
import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.framework.excel.core.util.ExcelUtils;
import com.qdcode.cloud.framework.operatelog.core.annotations.OperateLog;
import com.qdcode.cloud.module.system.controller.admin.logger.vo.operatelog.OperateLogPageReqVO;
import com.qdcode.cloud.module.system.controller.admin.logger.vo.operatelog.OperateLogRespVO;
import com.qdcode.cloud.module.system.convert.logger.OperateLogConvert;
import com.qdcode.cloud.module.system.dal.dataobject.logger.OperateLogDO;
import com.qdcode.cloud.module.system.dal.dataobject.user.AdminUserDO;
import com.qdcode.cloud.module.system.service.logger.OperateLogService;
import com.qdcode.cloud.module.system.service.user.AdminUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.qdcode.cloud.framework.common.pojo.CommonResult.success;
import static com.qdcode.cloud.framework.common.util.collection.CollectionUtils.convertList;
import static com.qdcode.cloud.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Tag(name = "管理后台 - 操作日志")
@RestController
@RequestMapping("/system/operate-log")
@Validated
public class OperateLogController {

    @Resource
    private OperateLogService operateLogService;
    @Resource
    private AdminUserService userService;

    @GetMapping("/page")
    @Operation(summary = "查看操作日志分页列表")
    @PreAuthorize("@ss.hasPermission('system:operate-log:query')")
    public CommonResult<PageResult<OperateLogRespVO>> pageOperateLog(@Valid OperateLogPageReqVO pageReqVO) {
        PageResult<OperateLogDO> pageResult = operateLogService.getOperateLogPage(pageReqVO);
        // 获得拼接需要的数据
        Map<Long, AdminUserDO> userMap = userService.getUserMap(
                convertList(pageResult.getList(), OperateLogDO::getUserId));
        return success(new PageResult<>(OperateLogConvert.INSTANCE.convertList(pageResult.getList(), userMap),
                pageResult.getTotal()));
    }

    @Operation(summary = "导出操作日志")
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPermission('system:operate-log:export')")
    @OperateLog(type = EXPORT)
    public void exportOperateLog(HttpServletResponse response, @Valid OperateLogPageReqVO exportReqVO) throws IOException {
        exportReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<OperateLogDO> list = operateLogService.getOperateLogPage(exportReqVO).getList();
        // 输出
        Map<Long, AdminUserDO> userMap = userService.getUserMap(
                convertList(list, OperateLogDO::getUserId));
        ExcelUtils.write(response, "操作日志.xls", "数据列表", OperateLogRespVO.class,
                OperateLogConvert.INSTANCE.convertList(list, userMap));
    }

}
