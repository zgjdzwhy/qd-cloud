package com.qdcode.cloud.gateway.util;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功后，提供文档相关的地址
 *
 * @author 盘古巧搭
 */
@Component
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("\n----------------------------------------------------------\n\t" +
                            "项目启动成功！\n\t" +
                            "接口文档: \t{} \n\t" +
                            "开发文档: \t{} \n\t" +
                            "视频教程: \t{} \n" +
                            "----------------------------------------------------------",
                    "https://cloud.iqdcode.cn/api-doc/",
                    "https://cloud.iqdcode.cn",
                    "https://t.zsxq.com/02Yf6M7Qn");

            // 数据报表
            System.out.println("[报表模块 qdcode-module-report 教程][参考 https://cloud.iqdcode.cn/report/ 开启]");
            // 工作流
            System.out.println("[工作流模块 qdcode-module-bpm 教程][参考 https://cloud.iqdcode.cn/bpm/ 开启]");
            // 商城系统
            System.out.println("[商城系统 qdcode-module-mall 教程][参考 https://cloud.iqdcode.cn/mall/build/ 开启]");
            // ERP 系统
            System.out.println("[ERP 系统 qdcode-module-erp - 教程][参考 https://cloud.iqdcode.cn/erp/build/ 开启]");
            // CRM 系统
            System.out.println("[CRM 系统 qdcode-module-crm - 教程][参考 https://cloud.iqdcode.cn/crm/build/ 开启]");
            // 微信公众号
            System.out.println("[微信公众号 qdcode-module-mp 教程][参考 https://cloud.iqdcode.cn/mp/build/ 开启]");
            // 支付平台
            System.out.println("[支付系统 qdcode-module-pay - 教程][参考 https://doc.iqdcode.cn/pay/build/ 开启]");
        });
    }

}
