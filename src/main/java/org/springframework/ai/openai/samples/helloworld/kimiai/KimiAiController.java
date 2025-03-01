package org.springframework.ai.openai.samples.helloworld.kimiai;

//import org.springframework.ai.chat.ChatClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import cn.hutool.core.collection.CollUtil;
import com.gwb.util.Message;
import com.gwb.util.MoonshotAiUtils;
import com.gwb.util.RoleEnum;
import org.springframework.ai.openai.samples.helloworld.kimiai.service.KimiAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class KimiAiController {

    @Autowired
    private KimiAiService kimiAiService;

	@GetMapping("/ai/simpleAi")
	public Map<String, String> completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        String chat = kimiAiService.getResponse();
        System.out.println("ai回答："+chat);
		return Map.of("generation",chat);
	}

}
