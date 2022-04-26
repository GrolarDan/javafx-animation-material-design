module dmk.jfxamd.login.media {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires MaterialFX;

    opens dmk.jfxamd.login.media to javafx.fxml;
    exports dmk.jfxamd.login.media;
}
