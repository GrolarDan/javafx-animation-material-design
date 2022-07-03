module dmk.jfxamd.splash.screen {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires transitive dmk.jfxamd.utilities;

    opens dmk.jfxamd.splash.screen to javafx.fxml;
    exports dmk.jfxamd.splash.screen;
}
