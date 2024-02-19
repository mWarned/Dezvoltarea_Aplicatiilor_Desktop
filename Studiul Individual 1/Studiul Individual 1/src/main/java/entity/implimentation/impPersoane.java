package entity.implimentation;

import entity.Persoane;
import jakarta.persistence.*;
import org.hibernate.cfg.beanvalidation.GroupsPerOperation;
import utils.queries.queryOperations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class impPersoane implements impHelper<Persoane>{
    @Override
    public List<Persoane> findAll() {
        return queryOperations.executeQuery("Persoane.All", Persoane.class);
    }

    @Override
    public Persoane findByID(int id) {
        return queryOperations.findById(id, Persoane.class);
    }

    @Override
    public void deleteByID(int id) {
        queryOperations.deleteById(id, Persoane.class);
    }

    @Override
    public void insert(List<Persoane> elementList) {
        queryOperations.insertList(elementList);
    }

    @Override
    public void insert(Persoane element) {
        queryOperations.insert(element);
    }

    public List<Persoane> findOldest(){
        return queryOperations.executeQuery("Persoane.Oldest", Persoane.class);
    }

    public List<Persoane> findYoungest(){
        return queryOperations.executeQuery("Persoane.Youngest", Persoane.class);
    }

    public List<Persoane> outputAscendingByBirthday(){
        return queryOperations.executeQuery("Persoane.OrderByBirthday", Persoane.class);
    }

    public List<Persoane> outputPeopleInAgeRange(int age1, int age2){
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.minusYears(age2);
        LocalDate endDate = currentDate.minusYears(age1);

        return  queryOperations.twoParametersQuery("Persoane.AgeRange", startDate, endDate, Persoane.class);
    }
    public String divorcePercentage(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        float divorceRate;

        try {
            transaction.begin();

            TypedQuery<Long> countDivorcedQuery = entityManager.createNamedQuery("Persoane.DivorcedNr", Long.class);
            float countDivorced = countDivorcedQuery.getSingleResult();

            TypedQuery<Long> countTotalQuery = entityManager.createNamedQuery("Persoane.TotalNr", Long.class);
            float countTotal = countTotalQuery.getSingleResult();

            divorceRate = (countDivorced / countTotal) * 100;

            transaction.commit();
        }finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.clear();
            entityManagerFactory.close();
        }
        return divorceRate + " %";
    }

    public List<Persoane> peopleOver18(char sex){
        List<Persoane> result = null;
        if (sex == 'm'){
            result = queryOperations.parameterQuery("Persoane.SelectM18",LocalDate.now().minusYears(18), Persoane.class);
        } else if (sex == 'f'){
            result = queryOperations.parameterQuery("Persoane.SelectF18",LocalDate.now().minusYears(18), Persoane.class);
        } else {
            System.out.println("Ati introdus sexul gresit!");
        }
        return result;
    }

    public List<Persoane> marriedUnder20(){
        return queryOperations.parameterQuery("Persoane.MarriedUnder20",LocalDate.now().minusYears(20) , Persoane.class);
    }
}
