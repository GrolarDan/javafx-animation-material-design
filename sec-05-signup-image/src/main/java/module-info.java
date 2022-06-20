module dmk.jfxamd.signup.image {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens dmk.jfxamd.signup.image to javafx.fxml;
    exports dmk.jfxamd.signup.image;
}
