module dmk.jfxamd.management.table {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    opens dmk.jfxamd.management.table to javafx.fxml;
    exports dmk.jfxamd.management.table;
}
