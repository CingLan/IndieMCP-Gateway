package com.indiefund.mcp.domain.protocol.service.storage;

import com.indiefund.mcp.domain.protocol.adapter.repository.IProtocolRepository;
import com.indiefund.mcp.domain.protocol.model.entity.StorageCommandEntity;
import com.indiefund.mcp.domain.protocol.service.IProtocolStorage;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 协议存储服务
 *
 * 2026/3/3 07:30
 */
@Slf4j
@Service
public class ProtocolStorage implements IProtocolStorage {

    @Resource
    private IProtocolRepository repository;

    @Override
    public List<Long> doStorage(StorageCommandEntity commandEntity) {
        return repository.saveHttpProtocolAndMapping(commandEntity.getHttpProtocolVOS());
    }

    @Override
    public void deleteGatewayProtocol(Long protocolId) {
        repository.deleteGatewayProtocol(protocolId);
    }

}
