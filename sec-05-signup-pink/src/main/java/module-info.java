module dmk.jfxamd.signup.pink {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens dmk.jfxamd.signup.pink to javafx.fxml;
    exports dmk.jfxamd.signup.pink;
}
