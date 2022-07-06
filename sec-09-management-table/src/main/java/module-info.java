module dmk.jfxamd.management.table {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires VirtualizedFX;
    requires static lombok;
    requires dmk.jfxamd.utilities;
    requires javafaker;
    requires java.sql;
    requires java.xml;

    opens dmk.jfxamd.management.table to javafx.fxml;
    exports dmk.jfxamd.management.table;
}
