package com.qdcode.cloud.module.member.api.user;

import com.qdcode.cloud.framework.common.pojo.CommonResult;
import com.qdcode.cloud.module.member.api.user.dto.MemberUserRespDTO;
import com.qdcode.cloud.module.member.convert.user.MemberUserConvert;
import com.qdcode.cloud.module.member.dal.dataobject.user.MemberUserDO;
import com.qdcode.cloud.module.member.service.user.MemberUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static com.qdcode.cloud.framework.common.pojo.CommonResult.success;

/**
 * 会员用户的 API 实现类
 *
 * @author 盘古巧搭
 */
@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class MemberUserApiImpl implements MemberUserApi {

    @Resource
    private MemberUserService userService;

    @Override
    public CommonResult<MemberUserRespDTO> getUser(Long id) {
        MemberUserDO user = userService.getUser(id);
        return success(MemberUserConvert.INSTANCE.convert2(user));
    }

    @Override
    public CommonResult<List<MemberUserRespDTO>> getUserList(Collection<Long> ids) {
        return success(MemberUserConvert.INSTANCE.convertList2(userService.getUserList(ids)));
    }

    @Override
    public CommonResult<List<MemberUserRespDTO>> getUserListByNickname(String nickname) {
        return success(MemberUserConvert.INSTANCE.convertList2(userService.getUserListByNickname(nickname)));
    }

    @Override
    public CommonResult<MemberUserRespDTO> getUserByMobile(String mobile) {
        return success(MemberUserConvert.INSTANCE.convert2(userService.getUserByMobile(mobile)));
    }

}
