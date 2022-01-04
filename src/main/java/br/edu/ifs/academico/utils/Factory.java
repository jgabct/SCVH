package br.edu.ifs.academico.utils;

import br.edu.ifs.academico.utils.components.Component;
import br.edu.ifs.academico.utils.components.ComponentsAdministratorDashboard;
import br.edu.ifs.academico.utils.components.ComponentsNurseDashboard;
import br.edu.ifs.academico.utils.components.ComponentsReceptionistDashboard;
import br.edu.ifs.academico.utils.enums.EmployeeType;

import javafx.stage.Stage;

import java.util.HashMap;

public class Factory {

    private final HashMap<EmployeeType, Component> mapDashboard = new HashMap<>();

    public Factory(Stage outsideStage) {
        mapDashboard.put(EmployeeType.RECEPTIONIST, (Component) new ComponentsReceptionistDashboard(outsideStage));
        mapDashboard.put(EmployeeType.ADMINISTRATOR, (Component) new ComponentsAdministratorDashboard(outsideStage));
        mapDashboard.put(EmployeeType.NURSE, (Component) new ComponentsNurseDashboard(outsideStage));
    }

    public Manageable getDashboard(EmployeeType type) {
        return mapDashboard.get(type);
    }
}
