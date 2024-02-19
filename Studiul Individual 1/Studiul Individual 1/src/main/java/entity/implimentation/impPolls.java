package entity.implimentation;

import entity.Polls;
import jakarta.persistence.*;
import org.hibernate.event.internal.PostDeleteEventListenerStandardImpl;
import utils.queries.queryOperations;

import java.util.List;

public class impPolls implements impHelper<Polls> {
    @Override
    public List<Polls> findAll() {
        return queryOperations.executeQuery("Polls.All", Polls.class);
    }

    @Override
    public Polls findByID(int id) {
        return queryOperations.findById(id, Polls.class);
    }

    @Override
    public void deleteByID(int id) {
        queryOperations.deleteById(id, Polls.class);
    }

    @Override
    public void insert(List<Polls> elementList) {
        queryOperations.insertList(elementList);
    }

    @Override
    public void insert(Polls element) {
        queryOperations.insert(element);
    }

    public long countAnonymous(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        long anonymousCount;

        try {
            transaction.begin();

            TypedQuery<Long> countAonymous = entityManager.createNamedQuery("Polls.AnonymousCount", Long.class);
            anonymousCount = countAonymous.getSingleResult();

            transaction.commit();
        }finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.clear();
            entityManagerFactory.close();
        }
        return anonymousCount;
    }
}
