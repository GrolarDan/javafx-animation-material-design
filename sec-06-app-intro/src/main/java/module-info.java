module dmk.jfxamd.app.intro {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens dmk.jfxamd.app.intro to javafx.fxml;
    exports dmk.jfxamd.app.intro;
}
