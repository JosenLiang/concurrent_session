package com.thoughtworks.concurrent;

import com.thoughtworks.concurrent.utils.Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class Recipes_04 extends Servlet {
    private long count = 0;

    public long getCount() {
        return count;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        count++;
    }
}
