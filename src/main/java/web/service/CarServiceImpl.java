package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private static int carId;
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++carId, "BMW", "3"));
        cars.add(new Car(++carId, "Mazda", "CX-9"));
        cars.add(new Car(++carId, "Audi", "A8"));
        cars.add(new Car(++carId, "KIA", "Optima"));
        cars.add(new Car(++carId, "Tesla", "model Y"));
    }

    public List<Car> showCars(Integer count) {
        if (count == null || count > cars.size()) {
            return cars;
        }
        return new ArrayList<>(cars.subList(0, count));
    }

}
