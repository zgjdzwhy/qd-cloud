package com.qdcode.cloud.module.bpm.framework.bpm.core.event;

import com.qdcode.cloud.module.bpm.event.BpmProcessInstanceResultEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * {@link BpmProcessInstanceResultEvent} 的生产者
 *
 * @author 盘古巧搭
 */
@AllArgsConstructor
@Validated
public class BpmProcessInstanceResultEventPublisher {

    private final ApplicationEventPublisher publisher;

    public void sendProcessInstanceResultEvent(@Valid BpmProcessInstanceResultEvent event) {
        publisher.publishEvent(event);
    }

}
