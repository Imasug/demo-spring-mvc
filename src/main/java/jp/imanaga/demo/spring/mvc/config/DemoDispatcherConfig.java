package jp.imanaga.demo.spring.mvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("jp.imanaga.demo.spring.mvc")
public class DemoDispatcherConfig implements WebMvcConfigurer {

	@Bean
	public MessageSource messageSource() {
		// TODO ReloadableResourceBundleMessageSourceを指定するとなぜか落ちる
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("messages");
		return messageSource;
	}
}
