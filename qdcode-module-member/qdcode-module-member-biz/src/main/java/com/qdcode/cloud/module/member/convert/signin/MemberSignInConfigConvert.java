package com.qdcode.cloud.module.member.convert.signin;

import com.qdcode.cloud.module.member.controller.admin.signin.vo.config.MemberSignInConfigCreateReqVO;
import com.qdcode.cloud.module.member.controller.admin.signin.vo.config.MemberSignInConfigRespVO;
import com.qdcode.cloud.module.member.controller.admin.signin.vo.config.MemberSignInConfigUpdateReqVO;
import com.qdcode.cloud.module.member.controller.app.signin.vo.config.AppMemberSignInConfigRespVO;
import com.qdcode.cloud.module.member.dal.dataobject.signin.MemberSignInConfigDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 签到规则 Convert
 *
 * @author QingX
 */
@Mapper
public interface MemberSignInConfigConvert {

    MemberSignInConfigConvert INSTANCE = Mappers.getMapper(MemberSignInConfigConvert.class);

    MemberSignInConfigDO convert(MemberSignInConfigCreateReqVO bean);

    MemberSignInConfigDO convert(MemberSignInConfigUpdateReqVO bean);

    MemberSignInConfigRespVO convert(MemberSignInConfigDO bean);

    List<MemberSignInConfigRespVO> convertList(List<MemberSignInConfigDO> list);

    List<AppMemberSignInConfigRespVO> convertList02(List<MemberSignInConfigDO> list);

}
