//package org.springframework.ai.openai.samples.helloworld.springai;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//class AIController {
//	private final ChatClient chatClient;
//
//	AIController(ChatClient chatClient) {
//		this.chatClient = chatClient;
//	}
//	@GetMapping("/ai")
//	Map<String, String> completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
//	String s=	chatClient.prompt()
//				.user(message)
//				.call()
//				.content();
//		return Map.of(
//				"completion",s
//				);
//	}
//}
