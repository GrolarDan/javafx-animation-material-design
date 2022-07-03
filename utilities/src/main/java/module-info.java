module dmk.jfxamd.utilities {
  requires javafx.base;
  requires javafx.graphics;
  requires static lombok;
  requires org.slf4j;

  exports dmk.jfxamd.utilities.transition;
  exports dmk.jfxamd.utilities.callback;
  exports dmk.jfxamd.utilities.common;
}