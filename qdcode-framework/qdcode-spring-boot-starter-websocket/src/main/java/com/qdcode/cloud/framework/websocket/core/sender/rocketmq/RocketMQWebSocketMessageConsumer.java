package com.qdcode.cloud.framework.websocket.core.sender.rocketmq;

import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * {@link RocketMQWebSocketMessage} 广播消息的消费者，真正把消息发送出去
 *
 * @author 盘古巧搭
 */
@RocketMQMessageListener( // 重点：添加 @RocketMQMessageListener 注解，声明消费的 topic
        topic = "${qdcode.websocket.sender-rocketmq.topic}",
        consumerGroup = "${qdcode.websocket.sender-rocketmq.consumer-group}",
        messageModel = MessageModel.BROADCASTING // 设置为广播模式，保证每个实例都能收到消息
)
@RequiredArgsConstructor
public class RocketMQWebSocketMessageConsumer implements RocketMQListener<RocketMQWebSocketMessage> {

    private final RocketMQWebSocketMessageSender rocketMQWebSocketMessageSender;

    @Override
    public void onMessage(RocketMQWebSocketMessage message) {
        rocketMQWebSocketMessageSender.send(message.getSessionId(),
                message.getUserType(), message.getUserId(),
                message.getMessageType(), message.getMessageContent());
    }

}
