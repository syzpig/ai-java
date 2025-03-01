package org.springframework.ai.openai.samples.helloworld.springai;

//import org.springframework.ai.chat.ChatClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ai.minimax.api.MiniMaxApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MinimaxAiController {

//	@Autowired
//	public  ChatClient chatClient;
	String apiKey="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJHcm91cE5hbWUiOiJzeXoiLCJVc2VyTmFtZSI6InN5eiIsIkFjY291bnQiOiIiLCJTdWJqZWN0SUQiOiIxNzkzMjY2NTE2OTU5OTY5ODQ5IiwiUGhvbmUiOiIxNTE1NTk2NjE5MyIsIkdyb3VwSUQiOiIxNzkzMjY2NTE2OTUxNTgxMjQxIiwiUGFnZU5hbWUiOiIiLCJNYWlsIjoiIiwiQ3JlYXRlVGltZSI6IjIwMjQtMDYtMDggMTA6MzA6MjYiLCJpc3MiOiJtaW5pbWF4In0.lEFXsMbuzP7wSEM4sNXEIDAtAszKS4JTj1rM___6_nOLMEg7_xIyfnus1ysS9ycw2hE724SWMel1ysnp2mb1s1JJc45jQpzcQ6Oq_mSPXij4DO7wXyqKq0loAcEwY0U8GILO-MwAZqDT25S8I8l2vAnzgfsIUhNdwyJ3yIazqTnHGpSHKbBoU8waqY22h1tTiy9HOK7Jewvonyv0Fq5QtycQ1kLTO4sGEaX-_DAKkguqGTH-P0-_49WLBHrBbY1OqxBczMNMpcTEnYysztHhbglGbJ66vWUlifJ2pomQpj0OKEpSrgLG9Dzo9v7EIkEi_3bTt-hm5UHYX3LUqwu6jQ";

	MiniMaxApi miniMaxApi = new MiniMaxApi(apiKey);

	@GetMapping("/ai/minimax")
	public Map<String, String> completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {



			MiniMaxApi.ChatCompletionMessage chatCompletionMessage = new MiniMaxApi.ChatCompletionMessage(message, MiniMaxApi.ChatCompletionMessage.Role.USER);
			ResponseEntity<MiniMaxApi.ChatCompletion> response = miniMaxApi
					.chatCompletionEntity(new MiniMaxApi.ChatCompletionRequest(List.of(chatCompletionMessage), "abab6.5-chat", 0.7, false));
			System.out.printf("=== %s\n", response.getBody().baseResponse().message());

		return Map.of("generation",response.getBody().baseResponse().message());
	}

}
