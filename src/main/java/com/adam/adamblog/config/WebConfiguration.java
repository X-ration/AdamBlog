package com.adam.adamblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author adam
 * 创建于 2018-03-01 20:14.
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        configurer.setUrlPathHelper(urlPathHelper);
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }
}
