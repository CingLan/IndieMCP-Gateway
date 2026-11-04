package com.indiefund.mcp.api;

import com.indiefund.mcp.api.dto.*;
import com.indiefund.mcp.api.response.Response;
import com.indiefund.mcp.api.response.ResponsePage;
import java.util.List;

/**
 * 运营配置管理服务接口
 *
 * 2026/3/24 08:00
 */
public interface IAdminService {

    Response<GatewayConfigResponseDTO> saveGatewayConfig(GatewayConfigRequestDTO.GatewayConfig requestDTO);

    Response<GatewayConfigResponseDTO> saveGatewayToolConfig(GatewayConfigRequestDTO.GatewayToolConfig requestDTO);

    Response<GatewayConfigResponseDTO> saveGatewayProtocol(GatewayConfigRequestDTO.GatewayProtocol requestDTO);

    Response<GatewayConfigResponseDTO> importGatewayProtocol(GatewayConfigRequestDTO.GatewayProtocolImport requestDTO);

    Response<List<GatewayProtocolDTO>> analysisProtocol(GatewayConfigRequestDTO.GatewayProtocolImport requestDTO);

    Response<GatewayConfigResponseDTO> saveGatewayAuth(GatewayConfigRequestDTO.GatewayAuth requestDTO);

    Response<List<GatewayConfigDTO>> queryGatewayConfigList();

    ResponsePage<List<GatewayConfigDTO>> queryGatewayConfigPage(GatewayConfigQueryDTO queryDTO);

    Response<List<GatewayToolConfigDTO>> queryGatewayToolList();

    ResponsePage<List<GatewayToolConfigDTO>> queryGatewayToolPage(GatewayToolQueryDTO queryDTO);

    Response<List<GatewayToolConfigDTO>> queryGatewayToolListByGatewayId(String gatewayId);

    Response<List<GatewayProtocolDTO>> queryGatewayProtocolList();

    ResponsePage<List<GatewayProtocolDTO>> queryGatewayProtocolPage(GatewayProtocolQueryDTO queryDTO);

    Response<List<GatewayProtocolDTO>> queryGatewayProtocolListByGatewayId(String gatewayId);

    Response<List<GatewayAuthDTO>> queryGatewayAuthList();

    ResponsePage<List<GatewayAuthDTO>> queryGatewayAuthPage(GatewayAuthQueryDTO queryDTO);

    Response<GatewayConfigResponseDTO> deleteGatewayToolConfig(String gatewayId, Long toolId);

    Response<GatewayLLMResponseDTO> testCallGateway(GatewayLLMRequestDTO requestDTO);

}
