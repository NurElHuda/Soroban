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
import Model.Task;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

public class Controller implements Initializable {

    @FXML private AnchorPane _start_pane;
    @FXML private AnchorPane _film_pane;

    @FXML private Text _text;

    @FXML private JFXDrawer _drawer;

    @FXML private JFXHamburger _hamburger;

    //The Model
    private Configuration _configuration;
    private Task counter;
    private Timer timer;

    private SidePanelController sidePanelController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("View/side_pan.fxml"));
            Pane side_pane = loader.load();
            sidePanelController = loader.getController();
            _drawer.setSidePane(side_pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
        HamburgerSlideCloseTransition burgerTask = new HamburgerSlideCloseTransition(_hamburger);
        burgerTask.setRate(-1);

        _hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask.setRate(burgerTask.getRate() * -1);
            burgerTask.play();

            if (_drawer.isClosed()) {
                _drawer.open();
            }
            else {
                _drawer.close();
            }
        });

        _drawer.open();

        sidePanelController._start_button.setOnMouseClicked(event -> {
            start();
            _drawer.close();
        });

        modelInit();

        spinnerInit();
        operationInit();
        volumeInit();

        _film_pane.setOnMouseClicked(event -> {
            System.out.println("here!");
            if (Task.resultReady){
                _text.setText(""+counter.result());
                counter.resetResutl();
            }else{
                start();
                _drawer.close();
            }
        });
    }

    public void modelInit(){
        _configuration = new Configuration();

    }

    public void spinnerInit(){
        //Bind the spinners.
        SpinnerValueFactory<Integer> columnsValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 7, 1);
        sidePanelController._columnsSpinner.setValueFactory(columnsValueFactory);
        columnsValueFactory.valueProperty().addListener((observable, oldValue, newValue) -> {
            _configuration.set_columns(newValue);
        });

        SpinnerValueFactory<Integer> rowValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 100, 2);
        sidePanelController._rowsSpinner.setValueFactory(rowValueFactory);
        rowValueFactory.valueProperty().addListener((observable, oldValue, newValue) -> {
            _configuration.set_rows(newValue);
        });

        SpinnerValueFactory<Integer> timeValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(300, 60000, 500, 100);
        sidePanelController._timeSpinner.setValueFactory(timeValueFactory);
        timeValueFactory.valueProperty().addListener((observable, oldValue, newValue) -> {
            _configuration.set_period(newValue);
        });

        _configuration.set_columns(columnsValueFactory.getValue());
        _configuration.set_rows(rowValueFactory.getValue());
        _configuration.set_period(timeValueFactory.getValue());

    }

    public void operationInit(){
        ToggleGroup _operationGroup = new ToggleGroup();
        sidePanelController._add.setToggleGroup(_operationGroup);
        sidePanelController._sub.setToggleGroup(_operationGroup);
        sidePanelController._add_sub.setToggleGroup(_operationGroup);
        sidePanelController._level_one.setToggleGroup(_operationGroup);

        _configuration.set_operation(1);

        _operationGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) ->  {
            if(sidePanelController._add.isSelected()){
                _configuration.set_operation(1);
                System.out.println("1");
            }else  if(sidePanelController._sub.isSelected()){
                _configuration.set_operation(2);
                System.out.println("2");
            }else  if(sidePanelController._add_sub.isSelected()){
                _configuration.set_operation(3);
                System.out.println("3");
            }else if (sidePanelController._level_one.isSelected()){
                _configuration.set_operation(4);
                System.out.println("4");
            }
        });
    }

    public void volumeInit(){
        ToggleGroup _volumeGroup = new ToggleGroup();
        sidePanelController._volume_button.setToggleGroup(_volumeGroup);
        sidePanelController._mute_button.setToggleGroup(_volumeGroup);

        _volumeGroup.selectToggle(sidePanelController._volume_button);

        _volumeGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(sidePanelController._volume_button.isSelected()){
                _configuration.set_volume(true);
                System.out.println("volume.");
            }else if(sidePanelController._mute_button.isSelected()){
                _configuration.set_volume(false);
                System.out.println("mute.");
            }
        });

    }


    public void start(){
        timer = new Timer();
        counter = new Task(_configuration);
        counter.set_timer(timer);
        counter.set_text(_text);
        System.out.println(""+_configuration.get_columns());
        System.out.println(""+_configuration.get_rows());
        System.out.println(""+_configuration.get_period());
        timer.schedule(counter, 0, _configuration.get_period());
    }

    public void result(){
        if (Task.resultReady){
            _text.setText(""+counter.result());
        }
    }

}
