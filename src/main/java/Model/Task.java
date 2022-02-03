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

import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Task extends TimerTask{
    private Configuration _configuration;
    private int _result;
    private int _counter;
    private Random _random;

    public static boolean resultReady;

    private Timer _timer;

    private Text _text;

    private AudioClip _sound;

    public void set_timer(Timer _timer) {
        this._timer = _timer;
    }

    public void set_text(Text text) {
        this._text = text;

    }

    public Task(Configuration configuration) {
        _configuration = configuration;
        _result = 0;
        _counter = 0;
        _random = new Random();
        Task.resultReady = false;

        String soundResourceName = "Audio/A-Tone-His_Self-1266414414.wav";
        URL soundSourceResource = getClass().getClassLoader().getResource(soundResourceName);
        this._sound = new AudioClip(soundSourceResource.toExternalForm());
    }

    @Override
    public void run() {
        if (_counter > _configuration.get_rows()-1){
            Task.resultReady = true;
            _text.setText("");
            _timer.cancel();
            _timer.purge();
        }else {
            int next_number;
            do {
                next_number = _random.nextInt((int) (Math.pow(10, _configuration.get_columns())));
            } while (next_number == 0);

            if (_configuration.get_operation() == 0) {

                System.out.println("+" + next_number);
                updateText("+" + next_number);
                _result = _result + next_number;
                if (_configuration.is_volume()) {
                    _sound.play();
                }
            } else if (_configuration.get_operation() == 1) {

                System.out.println("+" + next_number);
                updateText("+" + next_number);
                _result = _result + next_number;
                if (_configuration.is_volume()) {
                    _sound.play();
                }
            } else if (_configuration.get_operation() == 2) {

                if (_counter == 0) {
                    next_number *= 10;
                    System.out.println("+" + next_number);
                    updateText("+" + next_number);
                    _result = _result + next_number;
                } else {
                    System.out.println("-" + next_number);
                    updateText("-" + next_number);
                    _result = _result - next_number;
                }
                if (_configuration.is_volume()) {
                    _sound.play();
                }
            } else if (_configuration.get_operation() == 3) {
                int bound = (int) Math.pow(10, _configuration.get_columns())- 1;
                int half = bound /2;
                if ( _result < half ){
                    //TODO: addition.
                    int rest = bound - _result;
                    do{
                        next_number = _random.nextInt((int) Math.pow(10, _configuration.get_columns())- 1);
                    }while(next_number == 0);

                    System.out.println("+"+next_number);
                    updateText("+"+next_number);
                    _result = _result + next_number;
                }else{
                    //TODO: subtraction.
                    do{
                        next_number = _random.nextInt((int) Math.pow(10, _configuration.get_columns()));
                    }while (_result - next_number < 0 || next_number == 0);
                    System.out.println("-"+next_number);
                    updateText("-"+next_number);
                    _result = _result - next_number;
                }
                if (_configuration.is_volume()){
                    _sound.play();
                }


            }else if (_configuration.get_operation() == 4){
                int bound = (int) Math.pow(10, _configuration.get_columns())- 1;
                int half = bound /2;
                if ( _result < half ){
                    //TODO: addition.
                    int rest = bound - _result;
                    do{
                        next_number = _random.nextInt(rest);
                    }while(next_number == 0);

                    System.out.println("+"+next_number);
                    updateText("+"+next_number);
                    _result = _result + next_number;
                }else{
                    //TODO: subtraction.
                    do{
                        next_number = _random.nextInt((int) Math.pow(10, _configuration.get_columns()));
                    }while (_result - next_number < 0 || next_number == 0);
                    System.out.println("-"+next_number);
                    updateText("-"+next_number);
                    _result = _result - next_number;
                }
                if (_configuration.is_volume()){
                    _sound.play();
                }
            }
        }
        _counter++;
    }

    public int result(){
        _text.setFill(Color.CRIMSON);
        _text.setStyle("-fx-font-size: 180pt");
        _text.setText(""+_result);
        return _result;
    }

    public boolean resultReady(){
        return Task.resultReady;
    }
    public void resetResutl(){
        Task.resultReady = false;
    }

    public void updateText(String number){
        _text.setFill(Color.MIDNIGHTBLUE);
        _text.setStyle("-fx-font-size: 150pt");
        _text.setText(""+number);
    }
}
