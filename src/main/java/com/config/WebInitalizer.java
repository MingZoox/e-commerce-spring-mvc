package com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitalizer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(SecurityConfig.class);
		ctx.register(WebMvcConfig.class);
		ctx.setServletContext(servletContext);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
		servletContext.addFilter("encodingFilter", characterEncodingFilter).addMappingForUrlPatterns(null, false, "/*");
	}

}
