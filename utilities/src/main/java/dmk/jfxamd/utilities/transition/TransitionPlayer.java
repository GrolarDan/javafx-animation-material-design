package dmk.jfxamd.utilities.transition;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.Transition;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransitionPlayer {

  private final List<TransitionBuilder<?>> builderList = new ArrayList<>();

  public <T extends Transition> void add(TransitionBuilder<T> builder) {
    log.info("Added builder: {}", builder);
    builderList.add(builder);
  }

  public void play() {
    log.info("Start play - size: {}", builderList.size());
    if (builderList.isEmpty()) {
      return;
    }

    buildNext(builderList.get(0), 1).play();
  }

  private Transition buildNext(TransitionBuilder<?> current, int nextIndex) {
    if (nextIndex < builderList.size()) {
      var nextTransitionBuild = buildNext(builderList.get(nextIndex), nextIndex + 1);
      current.withOnFinishedHandler(actionEvent -> nextTransitionBuild.play());
    }
    return current.build();
  }
}
