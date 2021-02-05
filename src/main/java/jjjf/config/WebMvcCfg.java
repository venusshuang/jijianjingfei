package jjjf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcCfg extends WebMvcConfigurationSupport {

	@Value("${userfilepath}")
	String USERFILEPATH;

//	@Override
//	protected void addInterceptors(InterceptorRegistry registry) {
//
//	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/userfiles/**").addResourceLocations("file:" + USERFILEPATH);
		super.addResourceHandlers(registry);
	}

}
