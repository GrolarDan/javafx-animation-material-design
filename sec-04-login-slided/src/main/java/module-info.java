module dmk.jfxamd.login.slided {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens dmk.jfxamd.login.slided to javafx.fxml;
    exports dmk.jfxamd.login.slided;
}
