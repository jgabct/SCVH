module scvh {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens br.edu.ifs.academico.application to javafx.fxml;
    opens br.edu.ifs.academico.controllers to javafx.fxml;
    opens br.edu.ifs.academico.utils to javafx.fxml;

    exports br.edu.ifs.academico.application;
    exports br.edu.ifs.academico.controllers;
    exports br.edu.ifs.academico.utils;
}
