import org.jetbrains.annotations.NotNull;

public class Button implements View {

    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(@NotNull State state) {
        View.super.restoreState(state);
    }

    public class ButtonState implements State {

    }
}
