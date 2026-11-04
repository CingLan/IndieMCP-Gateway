package com.indiefund.mcp.domain.protocol.service;

import com.indiefund.mcp.domain.protocol.model.entity.StorageCommandEntity;

import java.util.List;

/**
 * 协议存储接口
 *
 * 2026/3/3 07:29
 */
public interface IProtocolStorage {

    List<Long> doStorage(StorageCommandEntity commandEntity);

    void deleteGatewayProtocol(Long protocolId);

}
