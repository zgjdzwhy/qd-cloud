package com.qdcode.cloud.module.system.dal.mysql.logger;

import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.qdcode.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.qdcode.cloud.module.system.api.logger.dto.OperateLogV2PageReqDTO;
import com.qdcode.cloud.module.system.dal.dataobject.logger.OperateLogV2DO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogV2Mapper extends BaseMapperX<OperateLogV2DO> {

    default PageResult<OperateLogV2DO> selectPage(OperateLogV2PageReqDTO pageReqDTO) {
        return selectPage(pageReqDTO, new LambdaQueryWrapperX<OperateLogV2DO>()
                .eqIfPresent(OperateLogV2DO::getType, pageReqDTO.getBizType())
                .eqIfPresent(OperateLogV2DO::getBizId, pageReqDTO.getBizId())
                .eqIfPresent(OperateLogV2DO::getUserId, pageReqDTO.getUserId())
                .orderByDesc(OperateLogV2DO::getId));
    }

}
