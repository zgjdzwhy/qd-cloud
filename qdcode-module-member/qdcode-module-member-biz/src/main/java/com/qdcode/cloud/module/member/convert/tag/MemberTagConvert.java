package com.qdcode.cloud.module.member.convert.tag;

import com.qdcode.cloud.framework.common.pojo.PageResult;
import com.qdcode.cloud.module.member.controller.admin.tag.vo.MemberTagCreateReqVO;
import com.qdcode.cloud.module.member.controller.admin.tag.vo.MemberTagRespVO;
import com.qdcode.cloud.module.member.controller.admin.tag.vo.MemberTagUpdateReqVO;
import com.qdcode.cloud.module.member.dal.dataobject.tag.MemberTagDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 会员标签 Convert
 *
 * @author 盘古巧搭
 */
@Mapper
public interface MemberTagConvert {

    MemberTagConvert INSTANCE = Mappers.getMapper(MemberTagConvert.class);

    MemberTagDO convert(MemberTagCreateReqVO bean);

    MemberTagDO convert(MemberTagUpdateReqVO bean);

    MemberTagRespVO convert(MemberTagDO bean);

    List<MemberTagRespVO> convertList(List<MemberTagDO> list);

    PageResult<MemberTagRespVO> convertPage(PageResult<MemberTagDO> page);

}
