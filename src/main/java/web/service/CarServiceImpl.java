package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl {
    private static int CAR_ID;
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CAR_ID, "BMW", "3"));
        cars.add(new Car(++CAR_ID, "Mazda", "CX-9"));
        cars.add(new Car(++CAR_ID, "Audi", "A8"));
        cars.add(new Car(++CAR_ID, "KIA", "Optima"));
        cars.add(new Car(++CAR_ID, "Tesla", "model Y"));
    }

    public List<Car> index() {
        return cars;
    }

    public Car show(int id) {
        return cars.stream().filter(car -> car.getId() == id).findAny().orElse(null);
    }
}
