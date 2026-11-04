package com.indiefund.mcp.domain.auth.service;

import com.indiefund.mcp.domain.auth.model.entity.RateLimitCommandEntity;

/**
 * 调用限制服务接口
 *
 * 2026/2/22 10:17
 */
public interface IAuthRateLimitService {

    /**
     * 限流操作
     * true - 限流
     * false - 未限流
     */
    boolean rateLimit(RateLimitCommandEntity commandEntity);

}
