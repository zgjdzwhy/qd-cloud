package com.qdcode.cloud.module.system.api.logger;

import cn.hutool.core.collection.CollUtil;
import com.qdcode.cloud.framework.common.pojo.CommonResult;
import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogCreateReqDTO;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2CreateReqDTO;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2PageReqDTO;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2RespDTO;
import com.qdcode.cloud.module.system.convert.logger.OperateLogConvert;
import com.qdcode.cloud.module.system.dal.dataobject.logger.OperateLogV2DO;
import com.qdcode.cloud.module.system.dal.dataobject.user.AdminUserDO;
import com.qdcode.cloud.module.system.service.logger.OperateLogService;
import com.qdcode.cloud.module.system.service.user.AdminUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

import static com.qdcode.cloud.framework.common.pojo.CommonResult.success;
import static com.qdcode.cloud.framework.common.util.collection.CollectionUtils.convertSet;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class OperateLogApiImpl implements OperateLogApi {

    @Resource
    private OperateLogService operateLogService;
    @Resource
    private AdminUserService adminUserService;

    @Override
    public CommonResult<Boolean> createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        operateLogService.createOperateLog(createReqDTO);
        return success(true);
    }

    @Override
    public CommonResult<Boolean> createOperateLogV2(OperateLogV2CreateReqDTO createReqDTO) {
        operateLogService.createOperateLogV2(createReqDTO);
        return success(true);
    }

    @Override
    public CommonResult<PageResult<OperateLogV2RespDTO>> getOperateLogPage(OperateLogV2PageReqDTO pageReqVO) {
        PageResult<OperateLogV2DO> operateLogPage = operateLogService.getOperateLogPage(pageReqVO);
        if (CollUtil.isEmpty(operateLogPage.getList())) {
            return success(PageResult.empty());
        }

        // 获取用户
        List<AdminUserDO> userList = adminUserService.getUserList(
                convertSet(operateLogPage.getList(), OperateLogV2DO::getUserId));
        return success(OperateLogConvert.INSTANCE.convertPage(operateLogPage, userList));
    }

}
