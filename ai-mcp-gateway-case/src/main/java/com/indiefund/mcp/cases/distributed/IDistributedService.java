package com.indiefund.mcp.cases.distributed;

import com.indiefund.mcp.domain.session.model.valobj.SessionSyncEventVO;

import java.util.function.Consumer;

/**
 * 分布式服务接口
 *
 * 2026/6/9 23:25
 */
public interface IDistributedService {

    void handleSessionSyncEvent(SessionSyncEventVO event);

    void subscribeSessionSyncEvent(Consumer<SessionSyncEventVO> consumer);

}
