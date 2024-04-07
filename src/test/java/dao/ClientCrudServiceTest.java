package dao;

import com.goit.dao.ClientCrudService;
import com.goit.entity.Client;
import com.goit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClientCrudServiceTest {
    ClientCrudService clientCrudService = new ClientCrudService();
    Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
    Transaction transaction;

    @Test
    void addingNewClient(){
        transaction = session.beginTransaction();
        Assertions.assertTrue(clientCrudService.createClient(new Client("Jakie")));
        transaction.rollback();
    }

    @Test
    void gettingClientById(){
        transaction = session.beginTransaction();
        Client client = clientCrudService.getClientById(2L);
        Assertions.assertEquals("Bill",client.getName());
        transaction.rollback();
    }

    @Test
    void updatingClient(){
        transaction = session.beginTransaction();
        Client client = clientCrudService.getClientById(1L);
        client.setName("Ivan");
        clientCrudService.updateClient(client);
        Assertions.assertEquals("Ivan",clientCrudService.getClientById(1L).getName());
        transaction.rollback();
    }

    @Test
    void gettingListOfClients(){
        transaction = session.beginTransaction();
        List<Client> clients = clientCrudService.getAllClients();
        Assertions.assertNotEquals(null,clients);
        transaction.rollback();
    }

    @Test
    void deleteClient(){
        transaction = session.beginTransaction();
        Assertions.assertTrue(clientCrudService.deleteClientById(14L));
        transaction.rollback();
    }
}
