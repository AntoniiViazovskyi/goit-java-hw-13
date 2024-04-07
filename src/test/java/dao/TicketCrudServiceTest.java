package dao;

import com.goit.dao.ClientCrudService;
import com.goit.dao.PlanetCrudService;
import com.goit.dao.TicketCrudService;
import com.goit.entity.Client;
import com.goit.entity.Planet;
import com.goit.entity.Ticket;
import com.goit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TicketCrudServiceTest {
    ClientCrudService clientCrudService = new ClientCrudService();
    PlanetCrudService planetCrudService = new PlanetCrudService();
    TicketCrudService ticketCrudService = new TicketCrudService();
    Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
    Transaction transaction;



    @Test
    void addingNewTicket() {
        Client client = clientCrudService.getClientById(1L);
        Planet fromPlanet = planetCrudService.getPlanetById(2L);
        Planet destinationPlanet = planetCrudService.getPlanetById(4L);
        Ticket ticket = new Ticket(client, fromPlanet, destinationPlanet);

        transaction = session.beginTransaction();
        Assertions.assertTrue(ticketCrudService.createTicket(ticket));
        transaction.rollback();
    }

    @Test
    void gettingTicketById() {
        transaction = session.beginTransaction();
        Ticket ticket = ticketCrudService.getTicketById(1L);
        Assertions.assertNotNull(ticket);
        transaction.rollback();
    }

    @Test
    void updatingTicket() {
        transaction = session.beginTransaction();
        Ticket ticket = ticketCrudService.getTicketById(2L);
        Planet planet = planetCrudService.getPlanetById(1L);
        ticket.setToPlanetId(planet);
        ticketCrudService.updateTicket(ticket);
        Assertions.assertEquals(planet.getId(), ticketCrudService.getTicketById(2L).getToPlanetId().getId());
        transaction.rollback();
    }

    @Test
    void gettingListOfTickets() {
        transaction = session.beginTransaction();
        List<Ticket> tickets = ticketCrudService.getAllTickets();
        Assertions.assertNotNull(tickets);
        transaction.rollback();
    }
    @Test
    void deleteClient(){
        transaction = session.beginTransaction();
        Assertions.assertTrue(ticketCrudService.deleteTicketById(11L));
        transaction.rollback();
    }
}
