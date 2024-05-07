package com.qdcode.cloud.framework.websocket.core.sender.local;

import com.qdcode.cloud.framework.websocket.core.sender.AbstractWebSocketMessageSender;
import com.qdcode.cloud.framework.websocket.core.sender.WebSocketMessageSender;
import com.qdcode.cloud.framework.websocket.core.session.WebSocketSessionManager;

/**
 * 本地的 {@link WebSocketMessageSender} 实现类
 *
 * 注意：仅仅适合单机场景！！！
 *
 * @author 盘古巧搭
 */
public class LocalWebSocketMessageSender extends AbstractWebSocketMessageSender {

    public LocalWebSocketMessageSender(WebSocketSessionManager sessionManager) {
        super(sessionManager);
    }

}
