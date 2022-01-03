module scvh {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires com.google.common;

    opens br.edu.ifs.academico.application to javafx.fxml;
    opens br.edu.ifs.academico.controllers to javafx.fxml;
    opens br.edu.ifs.academico.controllers.administrative to javafx.fxml;
    opens br.edu.ifs.academico.utils to javafx.fxml;
    
    opens br.edu.ifs.academico.model.entities;

    exports br.edu.ifs.academico.utils.enums;
    
    exports br.edu.ifs.academico.application;
    exports br.edu.ifs.academico.controllers;
    exports br.edu.ifs.academico.controllers.administrative;
    exports br.edu.ifs.academico.utils;
    
    exports br.edu.ifs.academico.model.entities;
    exports br.edu.ifs.academico.model.interfaces;
}
