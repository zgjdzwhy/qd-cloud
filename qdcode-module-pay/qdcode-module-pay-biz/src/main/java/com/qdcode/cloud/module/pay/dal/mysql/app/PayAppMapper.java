package com.qdcode.cloud.module.pay.dal.mysql.app;

import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.qdcode.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.qdcode.cloud.framework.mybatis.core.query.QueryWrapperX;
import com.qdcode.cloud.module.pay.controller.admin.app.vo.PayAppPageReqVO;
import com.qdcode.cloud.module.pay.dal.dataobject.app.PayAppDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayAppMapper extends BaseMapperX<PayAppDO> {

    default PageResult<PayAppDO> selectPage(PayAppPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PayAppDO>()
                .likeIfPresent(PayAppDO::getName, reqVO.getName())
                .eqIfPresent(PayAppDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(PayAppDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PayAppDO::getId));
    }

}
