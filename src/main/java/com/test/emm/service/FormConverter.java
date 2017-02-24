package com.test.emm.service;

/**
 * Created by User on 024 24.02.17.
 */
public interface FormConverter<From, To> {

    To convert (From form);

}
