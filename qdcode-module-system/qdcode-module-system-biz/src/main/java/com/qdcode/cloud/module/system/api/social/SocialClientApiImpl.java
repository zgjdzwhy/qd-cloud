package com.qdcode.cloud.module.system.api.social;

import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import com.qdcode.cloud.framework.common.pojo.CommonResult;
import com.qdcode.cloud.framework.common.util.object.BeanUtils;
import com.qdcode.cloud.module.system.api.social.dto.SocialWxJsapiSignatureRespDTO;
import com.qdcode.cloud.module.system.api.social.dto.SocialWxPhoneNumberInfoRespDTO;
import com.qdcode.cloud.module.system.service.social.SocialClientService;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.qdcode.cloud.framework.common.pojo.CommonResult.success;

/**
 * 社交应用的 API 实现类
 *
 * @author 盘古巧搭
 */
@RestController
@Validated
public class SocialClientApiImpl implements SocialClientApi {

    @Resource
    private SocialClientService socialClientService;

    @Override
    public CommonResult<String> getAuthorizeUrl(Integer socialType, Integer userType, String redirectUri) {
        return success(socialClientService.getAuthorizeUrl(socialType, userType, redirectUri));
    }

    @Override
    public CommonResult<SocialWxJsapiSignatureRespDTO> createWxMpJsapiSignature(Integer userType, String url) {
        WxJsapiSignature signature = socialClientService.createWxMpJsapiSignature(userType, url);
        return success(BeanUtils.toBean(signature, SocialWxJsapiSignatureRespDTO.class));
    }

    @Override
    public CommonResult<SocialWxPhoneNumberInfoRespDTO> getWxMaPhoneNumberInfo(Integer userType, String phoneCode) {
        WxMaPhoneNumberInfo info = socialClientService.getWxMaPhoneNumberInfo(userType, phoneCode);
        return success(BeanUtils.toBean(info, SocialWxPhoneNumberInfoRespDTO.class));
    }

}
