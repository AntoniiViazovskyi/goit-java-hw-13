package com.goit.dao;

import com.goit.entity.Client;

import java.util.List;

public interface ClientDao {


     boolean createClient(Client client);

     Client getClientById(Long id);

     boolean deleteClientById(Long id);

     boolean updateClient(Client client);

     List<Client> getAllClients();
}
