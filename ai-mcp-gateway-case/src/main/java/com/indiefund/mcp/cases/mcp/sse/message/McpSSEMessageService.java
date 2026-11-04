package com.indiefund.mcp.cases.mcp.sse.message;

import com.indiefund.mcp.cases.mcp.IMcpMessageService;
import com.indiefund.mcp.cases.mcp.sse.message.factory.DefaultMcpMessageFactory;
import com.indiefund.mcp.domain.session.model.entity.HandleMessageCommandEntity;
import cn.bugstack.wrench.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 会话消息处理
 *
 * 2026/2/20 07:37
 */
@Slf4j
@Service("mcpSSEMessageService")
public class McpSSEMessageService implements IMcpMessageService<Void> {

    @Resource
    private DefaultMcpMessageFactory defaultMcpMessageFactory;

    @Override
    public ResponseEntity<Void> handleMessage(HandleMessageCommandEntity commandEntity) throws Exception {
        StrategyHandler<HandleMessageCommandEntity, DefaultMcpMessageFactory.DynamicContext, ResponseEntity<Void>> strategyHandler
                = defaultMcpMessageFactory.strategyHandler();

        return strategyHandler.apply(commandEntity, new DefaultMcpMessageFactory.DynamicContext());
    }

}
