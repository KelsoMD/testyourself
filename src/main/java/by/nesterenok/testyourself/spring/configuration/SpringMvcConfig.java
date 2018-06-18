package by.nesterenok.testyourself.spring.configuration;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan("by.nesterenok.testyourself.web.action.implmvc")
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**","mentor/assets/**", 
				"mentor/groups/assets/**", 
				"user/assets/**", 
				"user/tests/assets/**",
				"guest/assets/**",
				"guest/tests/assets/**")
		.addResourceLocations("/assets/");
	}
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}



	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean(name="messageSource")
	public ReloadableResourceBundleMessageSource reloadableResourceBundle() {
		ReloadableResourceBundleMessageSource reloadableResourceBundle = new ReloadableResourceBundleMessageSource();
		reloadableResourceBundle.setBasenames("/WEB-INF/locales/messages");
		reloadableResourceBundle.setDefaultEncoding("UTF-8");
		reloadableResourceBundle.setFallbackToSystemLocale(false);
		return reloadableResourceBundle;
	}
	
	@Bean(name="localeResolver")
	public SessionLocaleResolver sessionLocaleResolver() {
		return new SessionLocaleResolver();
	}

//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(mappingJackson2HttpMessageConverter());
//	}
//
//	@Bean
//	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
//		return new MappingJackson2HttpMessageConverter();
//	}
}
