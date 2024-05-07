package com.qdcode.cloud.module.system.api.sensitiveword;

import com.qdcode.cloud.framework.common.pojo.CommonResult;
import com.qdcode.cloud.module.system.service.sensitiveword.SensitiveWordService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.qdcode.cloud.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class SensitiveWordApiImpl implements SensitiveWordApi {

    @Resource
    private SensitiveWordService sensitiveWordService;

    @Override
    public CommonResult<List<String>> validateText(String text, List<String> tags) {
        return success(sensitiveWordService.validateText(text, tags));
    }

    @Override
    public CommonResult<Boolean> isTextValid(String text, List<String> tags) {
        return success(sensitiveWordService.isTextValid(text, tags));
    }

}
