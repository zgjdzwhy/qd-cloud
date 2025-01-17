package com.qdcode.cloud.module.system.service.sms;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.qdcode.cloud.framework.common.enums.UserTypeEnum;
import com.qdcode.cloud.framework.sms.config.QdcodeSmsAutoConfiguration;
import com.qdcode.cloud.module.system.test.BaseDbAndRedisIntegrationTest;
import com.qdcode.cloud.module.system.mq.consumer.sms.SmsSendConsumer;
import com.qdcode.cloud.module.system.mq.producer.sms.SmsProducer;
import com.qdcode.cloud.module.system.service.user.AdminUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// TODO @巧搭：需要迁移
@Import({QdcodeSmsAutoConfiguration.class,
        SmsChannelServiceImpl.class, SmsSendServiceImpl.class, SmsTemplateServiceImpl.class, SmsLogServiceImpl.class,
        SmsProducer.class, SmsSendConsumer.class})
public class SmsServiceIntegrationTest extends BaseDbAndRedisIntegrationTest {

    @Resource
    private SmsSendServiceImpl smsService;
    @Resource
    private SmsChannelServiceImpl smsChannelService;

    @MockBean
    private AdminUserService userService;

    @Test
    public void testSendSingleSms_aliyunSuccess() {
        // 参数准备
        String mobile = "15601691399";
        Long userId = 1L;
        Integer userType = UserTypeEnum.ADMIN.getValue();
        String templateCode = "test_02";
        Map<String, Object> templateParams = MapUtil.<String, Object>builder()
                .put("code", "1234").build();
        // 调用
        smsService.sendSingleSms(mobile, userId, userType, templateCode, templateParams);

        // 等待 MQ 消费
        ThreadUtil.sleep(1, TimeUnit.HOURS);
    }

//    @Test
//    public void testDoSendSms() {
//        // 等待 MQ 消费
//        ThreadUtil.sleep(1, TimeUnit.HOURS);
//    }

}
