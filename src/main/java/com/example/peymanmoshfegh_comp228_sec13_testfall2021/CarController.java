package com.example.peymanmoshfegh_comp228_sec13_testfall2021;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarController {

    public TextField carID;
    public TextField make;
    public TextField model;
    public TextField b_year;
    public TextField price;

    public Button Add;

    public TextField minPrice;
    public TextField maxPrice;
    public TextField fromYear;
    public TextField toYear;
    public TextField Model;
    public TextField Make;

    public Button Filter;

    public Button Delete;

    public TableView<Car> table;
    public TableColumn<Car, String> carID_c;
    public TableColumn<Car, String> carMake_c;
    public TableColumn<Car, String> model_c;
    public TableColumn<Car, String> year_c;
    public TableColumn<Car, String> price_c;

    public ArrayList<Integer> carsToDelete = new ArrayList<>();

    public void Add_f(MouseEvent mouseEvent) throws SQLException {
        CarModel.insertCar(
                Integer.parseInt(carID.getText()),
                make.getText(),
                model.getText(),
                Integer.parseInt(b_year.getText()),
                Integer.parseInt(price.getText()));
    }

    public void Filter_f(MouseEvent mouseEvent) throws SQLException {
        String priceQuery = minPrice.getText().equals("") ? "1=1" :
                "(price BETWEEN " + minPrice.getText() + " AND " + maxPrice.getText() + ")";
        String yearQuery = fromYear.getText().equals("") ? "1=1" :
                "(b_year BETWEEN " + fromYear.getText() + " AND " + toYear.getText() + ")";
        String makeQuery = Make.getText().equals("") ? "1=1" : "MAKE='" + Make.getText() + "'";
        String modelQuery = Model.getText().equals("") ? "1=1" : "MODEL='" + Model.getText() + "'";
        String query = "SELECT *\n" +
                "FROM cars\n" +
                "WHERE " + priceQuery + " AND " + yearQuery + " AND " +
                makeQuery + " AND " + modelQuery;
        System.out.println(query);

        ResultSet resultSet = CarModel.query(query);
        ArrayList<Car> arrL = new ArrayList<>();
        carsToDelete.clear();
        while (resultSet.next()) {
            Car car = new Car();
            Integer x = Integer.parseInt(resultSet.getString("carID"));
            car.setCarID(x);
            carsToDelete.add(x);

            car.setMake(resultSet.getString("make"));
            car.setModel(resultSet.getString("model"));
            car.setB_year(Integer.parseInt(resultSet.getString("b_year")));
            car.setPrice(Integer.parseInt(resultSet.getString("price")));

            arrL.add(car);
        }

        table.getItems().clear();
        carID_c.setCellValueFactory(new PropertyValueFactory<>("carID"));
        carMake_c.setCellValueFactory(new PropertyValueFactory<>("make"));
        model_c.setCellValueFactory(new PropertyValueFactory<>("model"));
        year_c.setCellValueFactory(new PropertyValueFactory<>("b_year"));
        price_c.setCellValueFactory(new PropertyValueFactory<>("price"));

        for (Car c: arrL) {
            table.getItems().add(c);
        }
    }

    public void Delete_f(MouseEvent mouseEvent) throws SQLException {
        String str = carsToDelete.toString();
        String str2 = str.substring(1, str.length() - 1);
        String query = "delete from cars\n" +
                "where carID in (" + str2 + ")";
        System.out.println(query);
        CarModel.query(query);
        table.getItems().clear();
    }
}