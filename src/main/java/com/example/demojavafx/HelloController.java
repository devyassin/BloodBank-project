package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private Circle myCircle;
    private double y;
    private double x;
    public void Up(ActionEvent e){
      myCircle.setCenterY(y-=10);
    }
    public void Down(ActionEvent e){
        myCircle.setCenterY(y+=10);
    }
    public void Left(ActionEvent e){
        myCircle.setCenterX(x-=10);
    }
    public void Right(ActionEvent e){
        myCircle.setCenterX(x+=10);
    }
}