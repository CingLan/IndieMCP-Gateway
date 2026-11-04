package com.indiefund.mcp.test.infrastructure.dao;

import com.indiefund.mcp.infrastructure.dao.IMcpProtocolHttpDao;
import com.indiefund.mcp.infrastructure.dao.po.McpProtocolHttpPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class McpProtocolRegistryDaoTest {

    @Resource
    private IMcpProtocolHttpDao mcpProtocolRegistryDao;

}