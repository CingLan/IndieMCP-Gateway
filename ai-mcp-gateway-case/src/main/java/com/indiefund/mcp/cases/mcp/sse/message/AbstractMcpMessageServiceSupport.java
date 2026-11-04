package com.indiefund.mcp.cases.mcp.sse.message;

import com.indiefund.mcp.cases.mcp.sse.message.factory.DefaultMcpMessageFactory;
import com.indiefund.mcp.cases.mcp.streamable.message.factory.DefaultMcpStreamableMessageFactory;
import com.indiefund.mcp.domain.session.model.entity.HandleMessageCommandEntity;
import com.indiefund.mcp.domain.session.service.ISessionManagementService;
import com.indiefund.mcp.domain.session.service.ISessionMessageService;
import cn.bugstack.wrench.design.framework.tree.AbstractMultiThreadStrategyRouter;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public abstract class AbstractMcpMessageServiceSupport extends AbstractMultiThreadStrategyRouter<HandleMessageCommandEntity, DefaultMcpMessageFactory.DynamicContext, ResponseEntity<Void>> {

    @Resource
    protected ISessionMessageService serviceMessageService;

    @Resource
    protected ISessionManagementService sessionManagementService;

    @Override
    protected void multiThread(HandleMessageCommandEntity requestParameter, DefaultMcpMessageFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {

    }

}
