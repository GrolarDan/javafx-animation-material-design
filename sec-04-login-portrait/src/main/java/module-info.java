module dmk.jfxamd.login.portrait {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires MaterialFX;

    opens dmk.jfxamd.login.portrait to javafx.fxml;
    exports dmk.jfxamd.login.portrait;
}
