package com.test.emm.action;

import com.test.emm.action.form.ClientForm;
import com.test.emm.service.ClientService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateClientAction extends Action {

    @Autowired
    private ClientService clientService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        clientService.createClient((ClientForm) form);
        return mapping.findForward("success");
    }

}
