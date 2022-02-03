/*
 * Copyright (c) 2019.
 *
 *  /*
 *  Nour El Houda Tine.
 *  tinenourelhouda@gmail.com
 *  *  All Rights Reserved.
 *  *
 *  * NOTICE:  All information contained herein is, and remains
 *  * the property of Nour El Houda Tine,
 *  * The intellectual and technical concepts contained
 *  * herein are proprietary to Nour El Houda Tine
 *  * and its suppliers and may be covered by U.S. and Foreign Patents,
 *  * patents in process, and are protected by trade secret or copyright law.
 *  * Dissemination of this information or reproduction of this material
 *  * is strictly forbidden unless prior written permission is obtained
 *
 */

package Controllers;

import Model.Configuration;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    //The pane.
    @FXML
    AnchorPane _anchor_pane;
    //the spinners.
    @FXML
    Spinner _columnsSpinner;
    @FXML Spinner _rowsSpinner;
    @FXML Spinner _timeSpinner;
    //the toggels.
    @FXML
    ToggleGroup _operationGroup;
    @FXML
    RadioButton _add;
    @FXML RadioButton _sub;
    @FXML RadioButton _add_sub;
    //the buttons.
    @FXML private Button start;

    protected Configuration _configuration;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Configure the columnSpinner.
        SpinnerValueFactory<Integer> columnsValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 7, 1);
        _columnsSpinner.setValueFactory(columnsValueFactory);

        //Configure the rowSpinner.
        SpinnerValueFactory<Integer> rowValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 25, 2);
        _rowsSpinner.setValueFactory(rowValueFactory);

        //Configure the timeSpinner.
        SpinnerValueFactory<Integer> timeValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1000, 60000, 3000, 1000);
        _timeSpinner.setValueFactory(timeValueFactory);

        _operationGroup = new ToggleGroup();
        _add.setToggleGroup(_operationGroup);
        _sub.setToggleGroup(_operationGroup);
        _add_sub.setToggleGroup(_operationGroup);

    }

    public void set_configuration(Configuration configuration){
        _configuration = configuration;
        _columnsSpinner.getValueFactory().valueProperty().bindBidirectional(configuration._columnsProperty());
        _rowsSpinner.getValueFactory().valueProperty().bindBidirectional(configuration._rowsProperty());
        _timeSpinner.getValueFactory().valueProperty().bindBidirectional(configuration._periodProperty());

    }
}
