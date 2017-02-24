package com.test.emm.service.impl;

import com.test.emm.action.form.ClientForm;
import com.test.emm.model.Client;
import com.test.emm.model.Gender;
import com.test.emm.service.FormConverter;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("clientFormConverter")
public class ClientFormConverter implements FormConverter<ClientForm, Client> {

    private DateFormat dateFormat;

    public ClientFormConverter() {
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    }

    @Override
    public Client convert(ClientForm form) {
        Client client = new Client();
        client.setName(form.getName());
        client.setSurname(form.getSurname());
        client.setEmail(form.getEmail());
        client.setBirthDate(parseDate(form.getBirthDate()));
        client.setGender(Gender.valueOf(form.getGender()));
        return client;
    }

    public Date parseDate(String stringDate) {
        try {
            return dateFormat.parse(stringDate);
        } catch (ParseException e) {
            return null;
        }
    }
}
