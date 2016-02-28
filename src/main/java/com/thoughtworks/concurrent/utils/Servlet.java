package com.thoughtworks.concurrent.utils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public abstract class Servlet implements javax.servlet.Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
