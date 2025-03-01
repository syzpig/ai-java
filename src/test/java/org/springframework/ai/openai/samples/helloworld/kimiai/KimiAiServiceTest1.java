package org.springframework.ai.openai.samples.helloworld.kimiai;

import cn.hutool.core.collection.CollUtil;
import com.gwb.util.Message;
import com.gwb.util.MoonshotAiUtils;
import com.gwb.util.RoleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.openai.samples.helloworld.kimiai.service.KimiAiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KimiAiServiceTest1 {

    private KimiAiService kimiAiService;

    @BeforeEach
    public void setUp() {
        kimiAiService = new KimiAiService();
    }

    @Test
    public void testDrawWithValidPrizes() {
        List<String> prizes = Arrays.asList("奖品1", "奖品2", "奖品3");
        String result = kimiAiService.draw(prizes);
        assertTrue(prizes.contains(result), "返回的奖品应该在奖品列表中");
    }

    @Test
    public void testDrawWithEmptyPrizes() {
        List<String> prizes = Arrays.asList();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            kimiAiService.draw(prizes);
        });
        assertEquals("奖品列表不能为空", exception.getMessage());
    }

    @Test
    public void testDrawWithNullPrizes() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            kimiAiService.draw(null);
        });
        assertEquals("奖品列表不能为空", exception.getMessage());
    }
}