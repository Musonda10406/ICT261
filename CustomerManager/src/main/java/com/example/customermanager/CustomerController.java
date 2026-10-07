package com.example.customermanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerController {

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<String> provinceBox;

    @FXML
    private Button saveButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Label statusLabel;

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TableColumn<Customer, String> provinceColumn;

    private final ObservableList<Customer> customers =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        provinceBox.getItems().addAll(
                "Central",
                "Copperbelt",
                "Eastern",
                "Luapula",
                "Lusaka",
                "Muchinga",
                "Northern",
                "North-Western",
                "Southern",
                "Western"
        );

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        provinceColumn.setCellValueFactory(
                new PropertyValueFactory<>("province")
        );

        customerTable.setItems(customers);

        nameField.requestFocus();

        saveButton.setDefaultButton(true);
    }

    @FXML
    private void handleSave() {

        String name = nameField.getText().trim();

        if (name.isEmpty()) {

            statusLabel.setText(
                    "Enter the customer name."
            );

            nameField.requestFocus();

            return;
        }

        String province = provinceBox.getValue();

        if (province == null) {

            statusLabel.setText(
                    "Choose a province."
            );

            provinceBox.requestFocus();

            return;
        }

        Customer customer =
                new Customer(name, province);

        customers.add(customer);

        statusLabel.setText(
                "Customer saved."
        );

        nameField.clear();

        provinceBox.setValue(null);

        nameField.requestFocus();
    }

    @FXML
    private void handleDelete() {

        Customer selected =
                customerTable
                        .getSelectionModel()
                        .getSelectedItem();

        if (selected == null) {

            statusLabel.setText(
                    "Select a customer first."
            );

            return;
        }

        ButtonType delete =
                new ButtonType("Delete");

        Alert confirmation =
                new Alert(
                        Alert.AlertType.CONFIRMATION,
                        "Delete the selected customer?",
                        delete,
                        ButtonType.CANCEL
                );

        confirmation.setTitle(
                "Confirm deletion"
        );

        confirmation.setHeaderText(
                "Delete Customer"
        );

        if (confirmation.showAndWait()
                .orElse(ButtonType.CANCEL)
                == delete) {

            customers.remove(selected);

            statusLabel.setText(
                    "Customer deleted."
            );
        }
    }
}