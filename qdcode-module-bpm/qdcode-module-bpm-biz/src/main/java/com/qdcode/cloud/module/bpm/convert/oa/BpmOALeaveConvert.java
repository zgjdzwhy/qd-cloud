package com.qdcode.cloud.module.bpm.convert.oa;

import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.module.bpm.controller.admin.oa.vo.BpmOALeaveCreateReqVO;
import com.qdcode.cloud.module.bpm.controller.admin.oa.vo.BpmOALeaveRespVO;
import com.qdcode.cloud.module.bpm.dal.dataobject.oa.BpmOALeaveDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 请假申请 Convert
 *
 * @author 巧搭
 */
@Mapper
public interface BpmOALeaveConvert {

    BpmOALeaveConvert INSTANCE = Mappers.getMapper(BpmOALeaveConvert.class);

    BpmOALeaveDO convert(BpmOALeaveCreateReqVO bean);

    BpmOALeaveRespVO convert(BpmOALeaveDO bean);

    List<BpmOALeaveRespVO> convertList(List<BpmOALeaveDO> list);

    PageResult<BpmOALeaveRespVO> convertPage(PageResult<BpmOALeaveDO> page);

}
