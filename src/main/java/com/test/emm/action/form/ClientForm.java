package com.test.emm.action.form;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class ClientForm extends ActionForm {

    private long id;

    private String name;

    private String surname;

    private String email;

    private String birthDate;

    private String gender;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (StringUtils.isEmpty(name)) {
            errors.add(name, new ActionMessage("error.name.empty"));
        }
        if (StringUtils.isEmpty(surname)) {
            errors.add(surname, new ActionMessage("error.surname.empty"));
        }
        if (!emailValidator.isValid(email)) {
            errors.add(email, new ActionMessage("error.email.invalid"));
        }
        return errors;
    }
}
