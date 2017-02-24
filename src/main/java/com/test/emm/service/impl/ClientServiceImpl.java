package com.test.emm.service.impl;

import com.test.emm.action.form.ClientForm;
import com.test.emm.dto.PaginatedListImpl;
import com.test.emm.model.Client;
import com.test.emm.repo.ClientRepository;
import com.test.emm.service.ClientService;
import com.test.emm.service.FormConverter;
import org.displaytag.pagination.PaginatedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    @Qualifier("clientFormConverter")
    private FormConverter<ClientForm, Client> converter;

    private PaginatedList formPaginatedList(List<Client> list, int page, int pageSize) {
        PaginatedListImpl<Client> paginatedList = new PaginatedListImpl<>();
        paginatedList.setFullListSize(clientRepository.getClientCount());
        paginatedList.setObjectsPerPage(pageSize);
        paginatedList.setPageNumber(page);
        paginatedList.setList(list);
        return paginatedList;
    }

    @Override
    public Client createClient(ClientForm form) {
        return clientRepository.add(converter.convert(form));
    }

    @Override
    public PaginatedList getClients(int page, int pageSize, String sort, String dir) {
        page = page > 0 ? page : 1;
        int offset = (page - 1) * pageSize;
        List<Client> list = clientRepository.getAll(offset, pageSize, sort, dir);
        return formPaginatedList(list, page, pageSize);
    }
}
