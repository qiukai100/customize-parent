package com.customize.activity.activiti.config.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.HttpPutFormContentFilter;

import javax.servlet.annotation.WebFilter;


@Component
@WebFilter(urlPatterns = "/*", filterName = "putFilter")
@Order(Integer.MIN_VALUE)
public class PutFilter extends HttpPutFormContentFilter {
}
