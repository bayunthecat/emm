package com.test.emm.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.springframework.stereotype.Component;

@Component("birthDateInterceptor")
public class ParameterInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("Here");
        return actionInvocation.invoke();
    }
}
