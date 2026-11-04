package com.indiefund.mcp.cases.mcp.streamable.message;

import com.indiefund.mcp.cases.mcp.IMcpMessageService;
import com.indiefund.mcp.cases.mcp.streamable.message.factory.DefaultMcpStreamableMessageFactory;
import com.indiefund.mcp.domain.session.model.entity.HandleMessageCommandEntity;
import cn.bugstack.wrench.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Streamable 会话消息处理
 * 2026/5/19 08:28
 */
@Slf4j
@Service("mcpStreamableMessageService")
public class McpStreamableMessageService implements IMcpMessageService<String> {

    @Resource
    private DefaultMcpStreamableMessageFactory defaultMcpStreamableMessageFactory;

    @Override
    public ResponseEntity<String> handleMessage(HandleMessageCommandEntity commandEntity) throws Exception {
        StrategyHandler<HandleMessageCommandEntity, DefaultMcpStreamableMessageFactory.DynamicContext, ResponseEntity<?>> strategyHandler =
                defaultMcpStreamableMessageFactory.strategyHandler();

        ResponseEntity<?> responseEntity = strategyHandler.apply(commandEntity, new DefaultMcpStreamableMessageFactory.DynamicContext());

        return ResponseEntity.status(responseEntity.getStatusCodeValue())
                .headers(responseEntity.getHeaders())
                .body(responseEntity.getBody() == null ? null : responseEntity.getBody().toString());
    }

}
