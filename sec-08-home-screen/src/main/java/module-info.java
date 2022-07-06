module dmk.jfxamd.home.screen {
  requires javafx.controls;
  requires javafx.fxml;
  requires MaterialFX;
  requires dmk.jfxamd.utilities;
  requires org.kordamp.ikonli.core;
  requires org.kordamp.ikonli.javafx;
  // add icon pack modules
  requires org.kordamp.ikonli.materialdesign2;

  opens dmk.jfxamd.home.screen to javafx.fxml;
  exports dmk.jfxamd.home.screen;
}
