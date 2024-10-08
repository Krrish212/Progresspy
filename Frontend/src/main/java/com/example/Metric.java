package com.example;

import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Metric {

    String name;
    TimeChart chart;
    MetricsPane metricsPane;
    public Metric(String name,TimeChart chart, MetricsPane metricsPane){
        this.name = name;
        this.chart = chart;
        this.metricsPane = metricsPane;
    }

    public TimeChart getChart(){
        return chart;
    }


    public GridPane getPreview(){
       GridPane pane = new GridPane();
       pane.setGridLinesVisible(true);
       pane.setMaxSize(100,100);
       pane.getColumnConstraints().add(new ColumnConstraints(100));
       Text title = new Text(this.name);

       pane.getStylesheets().add("style1.css");
       title.getStyleClass().add("preview-title");
       if(chart.getChart() instanceof LineChart){
           ((LineChart<?, ?>) chart.getChart()).getYAxis().setLabel("");
       }
       pane.add(title,0,0);
       pane.add(chart,0,1);
       pane.setOnMouseClicked(this::onMouseClicked);

       return pane;
    }

    private void onMouseClicked(MouseEvent mouseEvent) {

    }


}
