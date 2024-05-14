package readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 开启组件扫描和自动配置
// 实际上是三个注解的组合
// @Configuration 使用Spring基于Java的配置
// @ComponentScan 启用组件扫描
// @EnableAutoConfiguration 开启Spring Boot的自动配置
@SpringBootApplication
public class ReadinglistApplication {

	public static void main(String[] args) {
		// 负责启动引导应用程序
		SpringApplication.run(ReadinglistApplication.class, args);
	}

}
