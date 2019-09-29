package com.memorize;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.memorize.conf.AppWebConfig;
import com.memorize.conf.JPAConfig;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class<?>[] { AppWebConfig.class, JPAConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8");

		return new Filter[] { encodingFilter };
	}

}
