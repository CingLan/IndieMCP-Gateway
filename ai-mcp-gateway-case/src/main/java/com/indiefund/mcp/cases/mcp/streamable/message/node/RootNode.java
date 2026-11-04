package com.indiefund.mcp.cases.mcp.streamable.message.node;

import com.indiefund.mcp.cases.mcp.streamable.message.AbstractMcpStreamableMessageServiceSupport;
import com.indiefund.mcp.cases.mcp.streamable.message.factory.DefaultMcpStreamableMessageFactory;
import com.indiefund.mcp.domain.auth.model.entity.RateLimitCommandEntity;
import com.indiefund.mcp.domain.auth.service.IAuthRateLimitService;
import com.indiefund.mcp.domain.session.model.entity.HandleMessageCommandEntity;
import com.indiefund.mcp.domain.session.model.valobj.McpSchemaVO;
import com.indiefund.mcp.domain.session.model.valobj.enums.SessionMessageHandlerMethodEnum;
import com.indiefund.mcp.types.enums.McpErrorCodes;
import com.indiefund.mcp.types.exception.AppException;
import cn.bugstack.wrench.design.framework.tree.StrategyHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 根节点
 * 2026/5/20 07:36
 */
@Slf4j
@Service("mcpStreamableMessageRootNode")
public class RootNode extends AbstractMcpStreamableMessageServiceSupport {

    @Resource(name = "mcpStreamableMessageInitializeNode")
    private InitializeNode initializeNode;

    @Resource(name = "mcpStreamableMessageSessionNode")
    private SessionNode sessionNode;

    @Resource
    private IAuthRateLimitService authRateLimitService;

    @Override
    protected ResponseEntity<?> doApply(HandleMessageCommandEntity requestParameter, DefaultMcpStreamableMessageFactory.DynamicContext dynamicContext) throws Exception {
        try {
            log.info("Streamable 消息处理 RootNode:{}", requestParameter);

            if (requestParameter.getJsonrpcMessage() instanceof McpSchemaVO.JSONRPCRequest request) {
                String method = request.method();
                SessionMessageHandlerMethodEnum sessionMessageHandlerMethodEnum = SessionMessageHandlerMethodEnum.getByMethod(method);
                if (SessionMessageHandlerMethodEnum.TOOLS_CALL.equals(sessionMessageHandlerMethodEnum)) {
                    boolean isHit = authRateLimitService.rateLimit(new RateLimitCommandEntity(requestParameter.getGatewayId(), requestParameter.getApiKey()));
                    if (isHit) {
                        log.warn("Streamable 消息处理 RootNode - 命中限流{} {}", requestParameter.getGatewayId(), requestParameter.getApiKey());
                        throw new AppException(McpErrorCodes.INSUFFICIENT_PERMISSIONS, "fail to auth apikey rateLimiter");
                    }
                }
            }

            return router(requestParameter, dynamicContext);
        } catch (Exception e) {
            log.error("Streamable 消息处理 RootNode:{}", requestParameter, e);
            throw e;
        }
    }

    @Override
    public StrategyHandler<HandleMessageCommandEntity, DefaultMcpStreamableMessageFactory.DynamicContext, ResponseEntity<?>> get(HandleMessageCommandEntity requestParameter, DefaultMcpStreamableMessageFactory.DynamicContext dynamicContext) throws Exception {
        if (requestParameter.getJsonrpcMessage() instanceof McpSchemaVO.JSONRPCRequest request
                && SessionMessageHandlerMethodEnum.INITIALIZE.getMethod().equals(request.method())) {
            return initializeNode;
        }
        return sessionNode;
    }

}
