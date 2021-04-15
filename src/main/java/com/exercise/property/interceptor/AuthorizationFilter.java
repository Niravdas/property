package com.exercise.property.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * @author Niravdas
 */
@Component
public class AuthorizationFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse response = (HttpServletResponse) resp;
        String APIKey = servletRequest.getHeader("APIKey");
		if (null == APIKey) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The APIKey is not valid.");
			return;
		} else if (APIKey.equals("ValidApiKeyFromDB")) {
			chain.doFilter(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The APIKey is not valid.");
			return;

		}
	}
}
