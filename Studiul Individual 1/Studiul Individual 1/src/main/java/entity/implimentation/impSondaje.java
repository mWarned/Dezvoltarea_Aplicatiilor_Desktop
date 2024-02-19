package entity.implimentation;

import entity.Sondaje;
import utils.queries.queryOperations;

import java.util.List;

public class impSondaje implements impHelper<Sondaje>{
    @Override
    public List<Sondaje> findAll() {
        return queryOperations.executeQuery("Sondaje.All", Sondaje.class);
    }

    @Override
    public Sondaje findByID(int id) {
        return queryOperations.findById(id, Sondaje.class);
    }

    @Override
    public void deleteByID(int id) {
        queryOperations.deleteById(id, Sondaje.class);
    }

    @Override
    public void insert(List<Sondaje> elementList) {
        queryOperations.insertList(elementList);
    }

    @Override
    public void insert(Sondaje element) {
        queryOperations.insert(element);
    }
}
