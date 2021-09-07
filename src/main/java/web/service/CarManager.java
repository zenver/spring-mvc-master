package web.service;

import org.springframework.stereotype.Component;
import web.controller.CarController;
import web.model.Car;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarManager {

    private static List<Car> carList;

    @PostConstruct
    private void loadData(){

        Car car1 = new Car("Lada", "Sinii", 2007);
        Car car2 = new Car("Ford", "Green", 1999);
        Car car3 = new Car("Audi", "Korichnevii", 2017);
        Car car4 = new Car("Mini", "Belii", 2011);
        Car car5 = new Car("AstonMartin", "Grey", 2009);

        carList = new ArrayList<>();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);

    }

    public List<Car> getCarList(int quantity) {
        CarController carController = new CarController();
        return carList.stream().limit(quantity).collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return carList;
    }
}