package org.springframework.ai.openai.samples.helloworld.kimiai;


import cn.hutool.core.collection.CollUtil;
import com.gwb.util.Message;
import com.gwb.util.MoonshotAiUtils;
import com.gwb.util.RoleEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.openai.samples.helloworld.Application;
import org.springframework.ai.openai.samples.helloworld.kimiai.service.KimiAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan(basePackages = {"com.gwb.util","org.springframework.ai.openai.samples.*"})
@ExtendWith({MockitoExtension.class})
@SpringBootTest(classes = Application.class)
public class KimiAiServiceTest {

    @Mock
    private MoonshotAiUtils moonshotAiUtils;

    @Autowired
    public KimiAiService kimiAiService;


//    @BeforeEach
//    public void setUp() {
//        // 初始化 KimiAiService 实例
//        kimiAiService = new KimiAiService();
//    }

    @Test
    public void getResponse_Success() {
        // 准备测试数据
        String expectedResponse = "CREATE TABLE students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), age INT);";
        List<Message> messages = CollUtil.newArrayList(
                new Message(RoleEnum.system.name(), "你是一个java程序员"),
                new Message(RoleEnum.user.name(), "如何使用mysql创建一张学生表，给出示例代码")
        );

        // 创建一个模拟的 MoonshotAiUtils 实现
    //    MoonshotAiUtils.setMockResponse(expectedResponse);

        // 执行测试
        String result = kimiAiService.getResponse();
        System.out.println(result);
        // 验证结果
       // assertEquals(expectedResponse, result);
    }
}