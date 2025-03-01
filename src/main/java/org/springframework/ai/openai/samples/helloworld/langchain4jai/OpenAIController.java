package org.springframework.ai.openai.samples.helloworld.langchain4jai;



import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;

import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.model.output.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {

    @GetMapping("/ai")
    public String assistant(@RequestParam(value = "message", defaultValue = "") String message) {

        // 创建一个OpenAiChatModel实例，这是ChatLanguageModel的子类实现。
        // LangChain4j支持多种LLM模型，每种模型类型都有相应的实现类，这里使用的是OpenAiChatModel。
        ChatLanguageModel model = OpenAiChatModel.builder()
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String answer = model.generate(message);


        return answer;
    }

    @GetMapping("/aiStream")
    public void assistantStream(@RequestParam(value = "message", defaultValue = "") String message) {

        StreamingChatLanguageModel chatModel = OpenAiStreamingChatModel.builder()
                .apiKey("demo")
                .modelName("gpt-4o-mini") // 指定要调用的模型名称（例如，gpt-4o-mini）。
                .build();

        // 使用生成的模型实例，传入文本，获取模型的响应。
        chatModel.generate("message", new StreamingResponseHandler<AiMessage>() {
            @Override
            public void onNext(String token) {
                System.out.println("onPartialResponse(): " + token);

            }

            @Override
            public void onComplete(Response<AiMessage> response) {
                StreamingResponseHandler.super.onComplete(response);
                System.out.println("onCompleteResponse(): " + response);

            }

            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });

    }


}
