package com.qdcode.cloud.module.system.service.logger;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.framework.common.util.object.BeanUtils;
import com.qdcode.cloud.framework.common.util.string.StrUtils;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogCreateReqDTO;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2CreateReqDTO;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2PageReqDTO;
import com.qdcode.cloud.module.system.controller.admin.logger.vo.operatelog.OperateLogPageReqVO;
import com.qdcode.cloud.module.system.dal.dataobject.logger.OperateLogDO;
import com.qdcode.cloud.module.system.dal.dataobject.logger.OperateLogV2DO;
import com.qdcode.cloud.module.system.dal.dataobject.user.AdminUserDO;
import com.qdcode.cloud.module.system.dal.mysql.logger.OperateLogMapper;
import com.qdcode.cloud.module.system.dal.mysql.logger.OperateLogV2Mapper;
import com.qdcode.cloud.module.system.service.user.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;

import static com.qdcode.cloud.framework.common.util.collection.CollectionUtils.convertSet;
import static com.qdcode.cloud.module.system.dal.dataobject.logger.OperateLogDO.JAVA_METHOD_ARGS_MAX_LENGTH;
import static com.qdcode.cloud.module.system.dal.dataobject.logger.OperateLogDO.RESULT_MAX_LENGTH;

/**
 * 操作日志 Service 实现类
 *
 * @author 盘古巧搭
 */
@Service
@Validated
@Slf4j
public class OperateLogServiceImpl implements OperateLogService {

    @Resource
    private OperateLogMapper operateLogMapper;
    @Resource
    private OperateLogV2Mapper operateLogV2Mapper;

    @Resource
    private AdminUserService userService;

    @Override
    public void createOperateLog(OperateLogCreateReqDTO createReqDTO) {
        OperateLogDO log = BeanUtils.toBean(createReqDTO, OperateLogDO.class);
        log.setJavaMethodArgs(StrUtils.maxLength(log.getJavaMethodArgs(), JAVA_METHOD_ARGS_MAX_LENGTH));
        log.setResultData(StrUtils.maxLength(log.getResultData(), RESULT_MAX_LENGTH));
        operateLogMapper.insert(log);
    }

    @Override
    public PageResult<OperateLogDO> getOperateLogPage(OperateLogPageReqVO pageReqVO) {
        // 处理基于用户昵称的查询
        Collection<Long> userIds = null;
        if (StrUtil.isNotEmpty(pageReqVO.getUserNickname())) {
            userIds = convertSet(userService.getUserListByNickname(pageReqVO.getUserNickname()), AdminUserDO::getId);
            if (CollUtil.isEmpty(userIds)) {
                return PageResult.empty();
            }
        }
        // 查询分页
        return operateLogMapper.selectPage(pageReqVO, userIds);
    }

    // ======================= LOG V2 =======================

    @Override
    public void createOperateLogV2(OperateLogV2CreateReqDTO createReqDTO) {
        OperateLogV2DO log = BeanUtils.toBean(createReqDTO, OperateLogV2DO.class);
        operateLogV2Mapper.insert(log);
    }

    @Override
    public PageResult<OperateLogV2DO> getOperateLogPage(OperateLogV2PageReqDTO pageReqDTO) {
        return operateLogV2Mapper.selectPage(pageReqDTO);
    }

}
