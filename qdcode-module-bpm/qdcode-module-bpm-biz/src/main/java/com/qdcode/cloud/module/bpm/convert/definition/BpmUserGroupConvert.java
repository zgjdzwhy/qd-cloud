package com.qdcode.cloud.module.bpm.convert.definition;

import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.module.bpm.controller.admin.definition.vo.group.BpmUserGroupCreateReqVO;
import com.qdcode.cloud.module.bpm.controller.admin.definition.vo.group.BpmUserGroupRespVO;
import com.qdcode.cloud.module.bpm.controller.admin.definition.vo.group.BpmUserGroupUpdateReqVO;
import com.qdcode.cloud.module.bpm.dal.dataobject.definition.BpmUserGroupDO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户组 Convert
 *
 * @author 盘古巧搭
 */
@Mapper
public interface BpmUserGroupConvert {

    BpmUserGroupConvert INSTANCE = Mappers.getMapper(BpmUserGroupConvert.class);

    BpmUserGroupDO convert(BpmUserGroupCreateReqVO bean);

    BpmUserGroupDO convert(BpmUserGroupUpdateReqVO bean);

    BpmUserGroupRespVO convert(BpmUserGroupDO bean);

    List<BpmUserGroupRespVO> convertList(List<BpmUserGroupDO> list);

    PageResult<BpmUserGroupRespVO> convertPage(PageResult<BpmUserGroupDO> page);

    @Named("convertList2")
    List<BpmUserGroupRespVO> convertList2(List<BpmUserGroupDO> list);

}
