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

package Model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Configuration {

    private IntegerProperty _columns;
    private IntegerProperty _rows;
    private IntegerProperty _period;
    private IntegerProperty _operation;
    private SimpleBooleanProperty _volume;

    public Configuration() {
        this._columns = new SimpleIntegerProperty();
        this._rows = new SimpleIntegerProperty();
        this._period = new SimpleIntegerProperty();
        this._operation = new SimpleIntegerProperty();
        this._volume = new SimpleBooleanProperty(true);
    }

    public int get_columns() {
        return _columns.get();
    }

    public IntegerProperty _columnsProperty() {
        return _columns;
    }

    public void set_columns(int _columns) {
        this._columns.set(_columns);
    }

    public int get_rows() {
        return _rows.get();
    }

    public  IntegerProperty _rowsProperty() {
        return _rows;
    }

    public void set_rows(int _rows) {
        this._rows.set(_rows);
    }

    public long get_period() {
        return (long) Long.valueOf(_period.getValue());
    }

    public IntegerProperty _periodProperty() {
        return _period;
    }

    public void set_period(int _period) {
        this._period.set(_period);
    }

    public int get_operation() {
        return _operation.get();
    }

    public IntegerProperty _operationProperty() {
        return _operation;
    }

    public void set_operation(int _operation) {
        this._operation.set(_operation);
    }

    public boolean is_volume() {
        return _volume.get();
    }

    public SimpleBooleanProperty _volumeProperty() {
        return _volume;
    }

    public void set_volume(boolean _volume) {
        this._volume.set(_volume);
    }
}
