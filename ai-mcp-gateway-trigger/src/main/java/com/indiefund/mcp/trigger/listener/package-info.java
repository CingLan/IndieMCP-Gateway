/**
 * 监听服务。单体里用它把会话同步从业务链路里拆开，多实例时走 Redis 发布订阅。
 */
package com.indiefund.mcp.trigger.listener;