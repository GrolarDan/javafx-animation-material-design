module dmk.jfxamd.home.screen {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires dmk.jfxamd.utilities;

    opens dmk.jfxamd.home.screen to javafx.fxml;
    exports dmk.jfxamd.home.screen;
}
