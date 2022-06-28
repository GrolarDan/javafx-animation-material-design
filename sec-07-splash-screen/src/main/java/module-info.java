module dmk.jfxamd.splash.screen {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens dmk.jfxamd.splash.screen to javafx.fxml;
    exports dmk.jfxamd.splash.screen;
}
