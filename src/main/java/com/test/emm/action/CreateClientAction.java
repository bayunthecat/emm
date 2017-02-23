package com.test.emm.action;

import com.test.emm.model.Client;
import com.test.emm.model.Gender;
import com.test.emm.util.Generator;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateClientAction extends Action {

    private Generator generator = new Generator();

    private Object result;

    private Client client;

    private DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    private Date birthDate;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response) throws Exception {
        return mapping.findForward("success");
    }

    public Object getResult() {
        return result;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    //TODO workaround to get everything working
    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = format.parse(birthDate);
    }

    private Client getRandomClient() {
        Client client = new Client();
        client.setName(generator.randomIdentifier());
        client.setSurname(generator.randomIdentifier());
        client.setEmail(generator.randomIdentifier());
        client.setBirthDate(new Date());
        client.setGender(Gender.MALE);
        return client;
    }
}
