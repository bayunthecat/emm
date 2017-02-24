package com.test.emm.action;

import com.test.emm.action.form.ClientForm;
import com.test.emm.model.Client;
import com.test.emm.service.ClientService;
import com.test.emm.service.FormConverter;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateClientAction extends Action {

    @Autowired
    private ClientService clientService;

    @Autowired
    @Qualifier("clientFormConverter")
    private FormConverter<ClientForm, Client> converter;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        clientService.createClient(converter.convert((ClientForm) form));
        return mapping.findForward("success");
    }

}
