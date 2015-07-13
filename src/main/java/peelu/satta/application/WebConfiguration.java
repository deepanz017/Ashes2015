package peelu.satta.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"peelu.satta"})
public class WebConfiguration extends WebMvcConfigurerAdapter{
//
// @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
//        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry resolverRegistry){
        resolverRegistry.jsp("/WEB-INF/pages/", ".jsp");
        super.configureViewResolvers(resolverRegistry);
    }
//    @Bean
//    public InternalResourceViewResolver getViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/pages/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
}
