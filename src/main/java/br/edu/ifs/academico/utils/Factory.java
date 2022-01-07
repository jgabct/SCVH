package br.edu.ifs.academico.utils;

import br.edu.ifs.academico.utils.components.Component;
import br.edu.ifs.academico.utils.components.ComponentsAdministratorDashboard;
import br.edu.ifs.academico.utils.components.ComponentsNurseDashboard;
import br.edu.ifs.academico.utils.components.ComponentsReceptionistDashboard;
import br.edu.ifs.academico.utils.enums.Post;

import javafx.stage.Stage;

import java.util.HashMap;

public class Factory {

    private final HashMap<Post, Component> mapDashboard = new HashMap<>();

    public Factory(Stage outsideStage) {
        mapDashboard.put(Post.RECEPTIONIST, (Component) new ComponentsReceptionistDashboard(outsideStage));
        mapDashboard.put(Post.ADMINISTRATOR, (Component) new ComponentsAdministratorDashboard(outsideStage));
        mapDashboard.put(Post.NURSE, (Component) new ComponentsNurseDashboard(outsideStage));
    }

    public Manageable getDashboard(Post type) {
        return mapDashboard.get(type);
    }
}
