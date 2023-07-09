package colosseum.colosseum.web;

import colosseum.colosseum.web.interceptor.SignInCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SignInCheckInterceptor())
				.order(1)
				.addPathPatterns("/**")
				.excludePathPatterns("/", "/sign-in", "/sign-up", "/css/**", "/*.ico", "/error");
	}
}
