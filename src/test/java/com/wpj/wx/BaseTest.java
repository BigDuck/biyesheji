/*
 * Copyright (c) 2015 - 11 - 16  3 : 6 :9
 * @author wupeiji It will be
 * @Email wpjlovehome@gmail.com
 */

package com.wpj.wx;

import org.junit.runner.RunWith;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * projectName：com-byteslounge-websockets
 * Time：2015/11/16 15:05
 * author：WPJ587
 * description：测试的基类
 **/
@WebIntegrationTest(randomPort = true)
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@IntegrationTest("server.port:0")
@SpringApplicationConfiguration(classes = App.class)
@Transactional("transactionManager")
public class BaseTest {
}
