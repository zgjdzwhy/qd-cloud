package com.qdcode.cloud.module.pay.convert.demo;

import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.module.pay.controller.admin.demo.vo.PayDemoOrderCreateReqVO;
import com.qdcode.cloud.module.pay.controller.admin.demo.vo.PayDemoOrderRespVO;
import com.qdcode.cloud.module.pay.dal.dataobject.demo.PayDemoOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 示例订单 Convert
 *
 * @author 盘古巧搭
 */
@Mapper
public interface PayDemoOrderConvert {

    PayDemoOrderConvert INSTANCE = Mappers.getMapper(PayDemoOrderConvert.class);

    PayDemoOrderDO convert(PayDemoOrderCreateReqVO bean);

    PayDemoOrderRespVO convert(PayDemoOrderDO bean);

    PageResult<PayDemoOrderRespVO> convertPage(PageResult<PayDemoOrderDO> page);

}
