package org.springframework.ai.openai.samples.helloworld.kimiai.service;

import cn.hutool.core.collection.CollUtil;
import com.gwb.util.Message;
import com.gwb.util.MoonshotAiUtils;
import com.gwb.util.RoleEnum;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class KimiAiService {

    //kimi聊天
    public String getResponse() {
        List<Message> messages = CollUtil.newArrayList(
                new Message(RoleEnum.system.name(), "你是一个java程序员"),
                new Message(RoleEnum.user.name(), "如何使用mysql创建一张学生表，给出示例代码")
        );
        System.out.println("问题：如何使用mysql创建一张学生表，给出示例代码");
        String chat = MoonshotAiUtils.doChat("moonshot-v1-8k", messages);
        return chat;
    }

    //抽奖demo
    public String draw(List<String> prizes) {
        if (prizes == null || prizes.isEmpty()) {
            throw new IllegalArgumentException("奖品列表不能为空");
        }
        Random random = new Random();
        int index = random.nextInt(prizes.size());
        return prizes.get(index);
    }

}
