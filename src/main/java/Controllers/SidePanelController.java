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

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SidePanelController implements Initializable {
    @FXML public Spinner<Integer> _columnsSpinner;

    @FXML public Spinner<Integer> _rowsSpinner;

    @FXML public Spinner<Integer> _timeSpinner;

    @FXML public RadioButton _add;

    @FXML public RadioButton _sub;

    @FXML public RadioButton _add_sub;

    @FXML public RadioButton _level_one;

    @FXML public RadioButton _volume_button;

    @FXML public RadioButton _mute_button;

    @FXML public Button _start_button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
