package by.nesterenok.testyourself.spring.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import by.nesterenok.testyourself.web.filter.EncodingFilter;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("by.nesterenok.testyourself.spring.configuration");

        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic dispatcher =
            servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy())
            .addMappingForUrlPatterns(null, false, "/*");
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        servletContext.addFilter("encoding-filter", characterEncodingFilter);
    }
}
