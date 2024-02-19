package entity.implimentation;

import utils.HelperInterface;

import java.util.List;

public interface impHelper <T extends HelperInterface> {
    List<T> findAll();
    T findByID(int id);
    void deleteByID(int id);
    void insert(List<T> elementList);
    void insert(T element);
}
