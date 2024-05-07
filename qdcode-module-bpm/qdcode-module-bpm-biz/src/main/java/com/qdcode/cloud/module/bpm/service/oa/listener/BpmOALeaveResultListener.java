package com.qdcode.cloud.module.bpm.service.oa.listener;

import com.qdcode.cloud.module.bpm.event.BpmProcessInstanceResultEvent;
import com.qdcode.cloud.module.bpm.event.BpmProcessInstanceResultEventListener;
import com.qdcode.cloud.module.bpm.service.oa.BpmOALeaveService;
import com.qdcode.cloud.module.bpm.service.oa.BpmOALeaveServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * OA 请假单的结果的监听器实现类
 *
 * @author 盘古巧搭
 */
@Component
public class BpmOALeaveResultListener extends BpmProcessInstanceResultEventListener {

    @Resource
    private BpmOALeaveService leaveService;

    @Override
    protected String getProcessDefinitionKey() {
        return BpmOALeaveServiceImpl.PROCESS_KEY;
    }

    @Override
    protected void onEvent(BpmProcessInstanceResultEvent event) {
        leaveService.updateLeaveResult(Long.parseLong(event.getBusinessKey()), event.getResult());
    }

}
