# 初始准备
1、kimi:jar
<dependency>
<groupId>com.gwb.util</groupId>
<artifactId>kimi-ai-java-sdk</artifactId>
<version>1.0.0-SNAPSHOT</version>
</dependency>

# 1、ai应用代码调整
 String chat = MoonshotAiUtils.doChat("moonshot-v1-8k", messages);
# 2、启动配置调整
@ComponentScan(basePackages = {"com.gwb.util","org.springframework.ai.openai.samples.*"})
# 3、
