package com.goit.dao;

import com.goit.entity.Client;
import com.goit.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientCrudService implements ClientDao{


    @Override
    public boolean createClient(Client client) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try{
                session.persist(client);
                transaction.commit();
                return true;
            }
            catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public Client getClientById(Long id) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class,id);
        }
    }

    @Override
    public boolean deleteClientById(Long id) {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try{
                Client client = session.get(Client.class,id);
                session.remove(client);
                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public boolean updateClient(Client client) {
        if (Objects.isNull(client)) {
            return false;
        }
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try{
                session.merge(client);
                transaction.commit();
                return true;
            }catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public List<Client> getAllClients() {
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }
}
