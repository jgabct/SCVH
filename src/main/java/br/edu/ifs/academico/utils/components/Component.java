package br.edu.ifs.academico.utils.components;

import br.edu.ifs.academico.utils.Manageable;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public abstract class Component implements Manageable {
    private Stage insideStage;

    private final List<Node> buttonsList = new ArrayList<>();
    private final List<Node> paneButtonsList = new ArrayList<>();

    public Component(Stage outsideStage){
        setInsideStage(outsideStage);
    }

    public List<Node> getButtonsList() {
        return buttonsList;
    }

    public List<Node> getPaneButtonsList() {
        return paneButtonsList;
    }

    public Integer getWidthButton() {
        return 120;
    }

    public Integer getHeightButton() {
        return 40;
    }

    public void setInsideStage(Stage outsideStage) {
        this.insideStage = outsideStage;
    }

    public Stage getInsideStage( ) {
        return this.insideStage;
    }

    protected abstract void initializeComponents();

}
