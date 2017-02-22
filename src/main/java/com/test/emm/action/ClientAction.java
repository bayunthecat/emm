package com.test.emm.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.test.emm.model.Client;
import com.test.emm.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component("clientAction")
public class ClientAction extends ActionSupport {

    private Object result;

    private Client client;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public String execute() {
        result = clientRepository.add(client);
        return Action.SUCCESS;
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
}
