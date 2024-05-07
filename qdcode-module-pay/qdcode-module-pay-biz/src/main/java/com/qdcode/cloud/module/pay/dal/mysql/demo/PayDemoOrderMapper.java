package com.qdcode.cloud.module.pay.dal.mysql.demo;

import com.qdcode.cloud.framework.common.pojo.PageParam;
import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.qdcode.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.qdcode.cloud.module.pay.dal.dataobject.demo.PayDemoOrderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 示例订单 Mapper
 *
 * @author 盘古巧搭
 */
@Mapper
public interface PayDemoOrderMapper extends BaseMapperX<PayDemoOrderDO> {

    default PageResult<PayDemoOrderDO> selectPage(PageParam reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PayDemoOrderDO>()
                .orderByDesc(PayDemoOrderDO::getId));
    }

    default int updateByIdAndPayed(Long id, boolean wherePayed, PayDemoOrderDO updateObj) {
        return update(updateObj, new LambdaQueryWrapperX<PayDemoOrderDO>()
                .eq(PayDemoOrderDO::getId, id).eq(PayDemoOrderDO::getPayStatus, wherePayed));
    }

}
