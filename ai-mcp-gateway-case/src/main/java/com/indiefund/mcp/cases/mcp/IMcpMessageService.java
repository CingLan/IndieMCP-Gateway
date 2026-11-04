package com.indiefund.mcp.cases.mcp;

import com.indiefund.mcp.domain.session.model.entity.HandleMessageCommandEntity;
import org.springframework.http.ResponseEntity;

/**
 * MCP 消息服务接口
 *
 * 2025/12/13 09:08
 */
public interface IMcpMessageService<T> {

    ResponseEntity<T> handleMessage(HandleMessageCommandEntity commandEntity) throws Exception;

}
