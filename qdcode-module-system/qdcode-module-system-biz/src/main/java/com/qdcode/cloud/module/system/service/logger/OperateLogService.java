package com.qdcode.cloud.module.system.service.logger;

import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogCreateReqDTO;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2CreateReqDTO;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2PageReqDTO;
import com.qdcode.cloud.module.system.controller.admin.logger.vo.operatelog.OperateLogPageReqVO;
import com.qdcode.cloud.module.system.dal.dataobject.logger.OperateLogDO;
import com.qdcode.cloud.module.system.dal.dataobject.logger.OperateLogV2DO;

/**
 * 操作日志 Service 接口
 *
 * @author 盘古巧搭
 */
public interface OperateLogService {

    /**
     * 记录操作日志
     *
     * @param createReqDTO 操作日志请求
     */
    void createOperateLog(OperateLogCreateReqDTO createReqDTO);

    /**
     * 获得操作日志分页列表
     *
     * @param pageReqVO 分页条件
     * @return 操作日志分页列表
     */
    PageResult<OperateLogDO> getOperateLogPage(OperateLogPageReqVO pageReqVO);

    // ======================= LOG V2 =======================

    /**
     * 记录操作日志 V2
     *
     * @param createReqDTO 创建请求
     */
    void createOperateLogV2(OperateLogV2CreateReqDTO createReqDTO);

    /**
     * 获得操作日志分页列表
     *
     * @param pageReqVO 分页条件
     * @return 操作日志分页列表
     */
    PageResult<OperateLogV2DO> getOperateLogPage(OperateLogV2PageReqDTO pageReqVO);

}
