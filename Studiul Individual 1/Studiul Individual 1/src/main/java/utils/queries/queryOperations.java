package utils.queries;

import jakarta.persistence.*;
import utils.HelperInterface;

import java.util.ArrayList;
import java.util.List;

public class queryOperations {
    public static <T extends HelperInterface> List<T> executeQuery(String query, Class dbClass) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<T> entityList = new ArrayList<>();

        try {
            transaction.begin();

            TypedQuery<T> namedQuerry = entityManager.createNamedQuery(query, dbClass);
            entityList = new ArrayList<T>(namedQuerry.getResultList());

            transaction.commit();
        }finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.clear();
            entityManagerFactory.close();
        }
        return entityList;
    }

    public static <T extends HelperInterface> void queryUpdate(String query) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

            Query namedQuerry = entityManager.createNamedQuery(query);
            namedQuerry.executeUpdate();

            transaction.commit();
        }finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.clear();
            entityManagerFactory.close();
        }
    }

    public static <T extends HelperInterface, K> List<T> parameterQuery(String query, K parameter, Class dbClass) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<T> entityList = new ArrayList<>();

        try {
            transaction.begin();

            TypedQuery<T> namedQuerry = entityManager.createNamedQuery(query, dbClass);
            namedQuerry.setParameter(1, parameter);
            entityList = new ArrayList<T>(namedQuerry.getResultList());

            transaction.commit();
        }finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.clear();
            entityManagerFactory.close();
        }
        return entityList;
    }

    public static <T extends HelperInterface, K, R> List<T> twoParametersQuery(String query, K parameterOne, R parameterTwo, Class dbClass) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<T> entityList = new ArrayList<>();

        try {
            transaction.begin();

            TypedQuery<T> namedQuerry = entityManager.createNamedQuery(query, dbClass);
            namedQuerry.setParameter(1, parameterOne);
            namedQuerry.setParameter(2, parameterTwo);
            entityList = new ArrayList<T>(namedQuerry.getResultList());

            transaction.commit();
        }finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.clear();
            entityManagerFactory.close();
        }
        return entityList;
    }

    public static <T extends HelperInterface> T findById(int id, Class dbClass) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        T entity;

        try {
            transaction.begin();

            entity = (T) entityManager.find(dbClass, id);

            transaction.commit();
        }finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.clear();
            entityManagerFactory.close();
        }
        return entity;
    }

    public static <T extends HelperInterface> void insertList(List<T> entityList) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            for(int i = 0; i< entityList.size(); i ++){
                entityManager.persist(entityList.get(i));
                if(i % 20 == 0){
                    entityManager.flush();
                    entityManager.clear();
                }
            }

            transaction.commit();
        }finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.clear();
            entityManagerFactory.close();
        }

    }
    public static <T extends HelperInterface> void insert(T entity) {
        insertList(List.of(entity));
    }

    public static <T extends HelperInterface> void deleteById(int id, Class dbClass) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            entityManager.remove(entityManager.find(dbClass, id));
            entityManager.flush();

            transaction.commit();
        }finally {
            if(transaction.isActive()) transaction.rollback();
            entityManager.clear();
            entityManagerFactory.close();
        }

    }
}
