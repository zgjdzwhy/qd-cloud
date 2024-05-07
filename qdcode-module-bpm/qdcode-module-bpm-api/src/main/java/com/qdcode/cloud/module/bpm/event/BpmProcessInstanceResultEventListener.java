package com.qdcode.cloud.module.bpm.event;

import cn.hutool.core.util.StrUtil;
import org.springframework.context.ApplicationListener;

// TODO 巧搭：跨服务的情况下，该逻辑无法跑通
/**
 * {@link BpmProcessInstanceResultEvent} 的监听器
 *
 * @author 盘古巧搭
 */
public abstract class BpmProcessInstanceResultEventListener
        implements ApplicationListener<BpmProcessInstanceResultEvent> {

    @Override
    public final void onApplicationEvent(BpmProcessInstanceResultEvent event) {
        if (!StrUtil.equals(event.getProcessDefinitionKey(), getProcessDefinitionKey())) {
            return;
        }
        onEvent(event);
    }

    /**
     * @return 返回监听的流程定义 Key
     */
    protected abstract String getProcessDefinitionKey();

    /**
     * 处理事件
     *
     * @param event 事件
     */
    protected abstract void onEvent(BpmProcessInstanceResultEvent event);

}
