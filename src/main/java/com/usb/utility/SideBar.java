package com.usb.utility;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.util.Duration;

/**
 * Animates a node on and off screen to the left.
 */
public class SideBar extends VBox {
    /**
     * @return a control button to hide and show the sidebar
     */
    public Button getControlButton() {
        return controlButton;
    }

    private final Button controlButton;

    /**
     * creates a sidebar containing a vertical alignment of the given nodes
     */
    public SideBar(final double expandedWidth, final double hiddenWidth, Node... nodes) {
        getStyleClass().add("sidebar");
        this.setPrefWidth(expandedWidth);
        this.setMinWidth(0);

        // create a bar to hide and show.
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(20));
        setSpacing(20);
        getChildren().addAll(nodes);

        // Create Fonts for Indent and Outdent
        FontAwesomeIconView buttonIcon = new FontAwesomeIconView();

        // create a button to hide and show the sidebar.
        controlButton = new Button("", buttonIcon);
        buttonIcon.getStyleClass().add("hide-left");

        // apply the animations when the button is pressed.
        controlButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // create an animation to hide sidebar.
                final Animation hideSidebar = new Transition() {
                    {
                        setCycleDuration(Duration.millis(250));
                    }

                    protected void interpolate(double frac) {
                        if (frac < 1 - (hiddenWidth / expandedWidth)) {
                            final double curWidth = expandedWidth * (1.0 - frac);
                            setPrefWidth(curWidth);
                        }
                    }
                };
                hideSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        //controlButton.setText("Show");
                        buttonIcon.getStyleClass().remove("hide-left");
                        buttonIcon.getStyleClass().add("show-right");
                        for(Node node : nodes) {
                            ToggleButton button = ((ToggleButton)node);
                            button.setText("");
                            button.getGraphic().setStyle("-glyph-size: 25px;-fx-fill: #27C24C");
                        }
                    }
                });

                // create an animation to show a sidebar.
                final Animation showSidebar = new Transition() {
                    {
                        setCycleDuration(Duration.millis(250));
                    }

                    protected void interpolate(double frac) {
                        if (frac > (hiddenWidth / expandedWidth)) {
                            final double curWidth = expandedWidth * frac;
                            setPrefWidth(curWidth);
                        }
                    }
                };
                showSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        //controlButton.setText("Collapse");
                        buttonIcon.getStyleClass().add("hide-left");
                        buttonIcon.getStyleClass().remove("show-right");
                        for(int i=0; i<3;i++) {
                            switch (i){
                                case 0:
                                    ToggleButton button = ((ToggleButton)nodes[i]);
                                    button.setText(PropertiesUtil.getValue("configuration"));
                                    button.getGraphic().setStyle("-glyph-size: 15px;");
                                    break;
                                case 1:
                                    ToggleButton button1 = ((ToggleButton)nodes[i]);
                                    button1.setText(PropertiesUtil.getValue("calibration"));
                                    button1.getGraphic().setStyle("-glyph-size: 15px;");
                                    break;
                                case 2:
                                    ToggleButton button2 = ((ToggleButton)nodes[i]);
                                    button2.setText(PropertiesUtil.getValue("data-download"));
                                    button2.getGraphic().setStyle("-glyph-size: 15px;");
                                    break;
                            }
                        }
                    }
                });

                if (showSidebar.statusProperty().get() == Animation.Status.STOPPED && hideSidebar.statusProperty().get() == Animation.Status.STOPPED) {
                    if (getPrefWidth() == expandedWidth) {
                        hideSidebar.play();
                    } else {
                        showSidebar.play();
                    }
                }
            }
        });
    }
}

