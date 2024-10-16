package web.service;

import org.springframework.stereotype.Component;
import web.model.Cars;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarsServiceIml implements CarsService {
    private final List<Cars> cars;

    {
        cars = new ArrayList<Cars>();
        cars.add(new Cars(1, "Lamborginy", "Red"));
        cars.add(new Cars(2, "Lada", "White"));
        cars.add(new Cars(4, "Tesla", "Green"));
        cars.add(new Cars(5, "Truck", "Yellow"));
        cars.add(new Cars(6, "BMW", "Black"));
    }


    @Override
    public List<Cars> getCars(int count) {
        List<Cars> CarsByCount = new ArrayList<>();
        if (count <= 5) {
            for (int i = 0; i < count; i++) {
                CarsByCount.add(cars.get(i));
            }
            return CarsByCount;
        } else {
            return cars;
        }
    }
}
