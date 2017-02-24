package com.test.emm.action;

import com.test.emm.action.form.AllClientsForm;
import com.test.emm.service.ClientService;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllClients extends Action {

    private static final int PAGE_SIZE = 20;

    @Autowired
    private ClientService clientService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        AllClientsForm allClientsForm = (AllClientsForm) form;
        allClientsForm.setList(
                clientService.getClients(
                        allClientsForm.getPage(),
                        PAGE_SIZE,
                        allClientsForm.getSort(),
                        allClientsForm.getDir()));
        return mapping.findForward("success");
    }
}
