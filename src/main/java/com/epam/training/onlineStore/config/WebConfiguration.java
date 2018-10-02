package com.epam.training.onlineStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.epam.training.onlineStore.interceptor.AuthInterceptor;
import com.epam.training.onlineStore.interceptor.UserNameAwareInterceptor;

/**
 * Конфигуратор интерсептеров. Настраивает защищаемые разделы.
 *
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * Бин общего интерсептера проверки наличия аутентификации
     */
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public UserNameAwareInterceptor userNameAwareInterceptor() {
        return new UserNameAwareInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	
    	
    	registry.addInterceptor(authInterceptor()).addPathPatterns("/cart", "/cart*", "/cart/**", "/users/*", "/orders/*");
      //.excludePathPatterns("/login");
////        registry.addInterceptor(authInterceptor()).addPathPatterns("/**")
        //.excludePathPatterns("/login", "/registration",
          //      "/logout", "/css/**", "/js/**", "/checkloginexist");
       

      registry.addInterceptor(userNameAwareInterceptor()).addPathPatterns("/**");
      	//.excludePathPatterns("/**");
//        registry.addInterceptor(userNameAwareInterceptor()).addPathPatterns("/**")
        //.excludePathPatterns("/login",
        //        "/registration", "/logout", "/css/**", "/js/**", "/checkloginexist");
    }

}
