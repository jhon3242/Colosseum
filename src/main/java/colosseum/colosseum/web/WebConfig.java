package colosseum.colosseum.web;

import colosseum.colosseum.domain.member.MemberRepository;
import colosseum.colosseum.domain.member.MemberRepositoryH2;
import colosseum.colosseum.web.interceptor.SignInCheckInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	DataSource dataSource() {
		return new HikariDataSource();
	}

	@Bean
	MemberRepository userRepository() {
		return new MemberRepositoryH2(dataSource());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SignInCheckInterceptor())
				.order(1)
				.addPathPatterns("/**")
				.excludePathPatterns("/", "/sign-in", "/sign-up", "/css/**", "/*.ico", "/error", "/static/**", "/post");
	}

}
