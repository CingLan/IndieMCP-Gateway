package com.indiefund.mcp.cases.admin;

import com.indiefund.mcp.api.dto.GatewayLLMRequestDTO;
import com.indiefund.mcp.api.dto.GatewayLLMResponseDTO;

/**
 * LLM 对话模型服务，测试 MCP
 *
 * 2026/4/8 07:50
 */
public interface IAdminLLMService {

    GatewayLLMResponseDTO testCallGateway(GatewayLLMRequestDTO requestDTO);

}
