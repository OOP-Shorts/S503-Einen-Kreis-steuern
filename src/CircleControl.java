import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.KeyPressedEvent;
import de.ur.mi.oop.events.KeyReleasedEvent;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class CircleControl extends GraphicsApp {

    private Circle circle;
    private boolean shouldMoveUp = false;
    private boolean shouldMoveDown = false;
    private boolean shouldMoveLeft = false;
    private boolean shouldMoveRight = false;

    @Override
    public void initialize() {
        setCanvasSize(500, 500);
        circle = new Circle(getWidth() / 2, getHeight() / 2, 50, Colors.RED);
    }

    @Override
    public void draw() {
        drawBackground(Colors.BLACK);
        int xMovement = 0;
        int yMovement = 0;
        if (shouldMoveUp) {
            yMovement--;
        }
        if (shouldMoveDown) {
            yMovement++;
        }
        if (shouldMoveLeft) {
            xMovement--;
        }
        if (shouldMoveRight) {
            xMovement++;
        }
        circle.move(xMovement, yMovement);
        circle.draw();
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        super.onKeyPressed(event);
        switch (event.getKeyCode()) {
            case KeyPressedEvent.VK_UP:
                shouldMoveUp = true;
                break;
            case KeyPressedEvent.VK_DOWN:
                shouldMoveDown = true;
                break;
            case KeyPressedEvent.VK_LEFT:
                shouldMoveLeft = true;
                break;
            case KeyPressedEvent.VK_RIGHT:
                shouldMoveRight = true;
                break;
            default:
                break;
        }
    }

    @Override
    public void onKeyReleased(KeyReleasedEvent event) {
        super.onKeyReleased(event);
        switch (event.getKeyCode()) {
            case KeyPressedEvent.VK_UP:
                shouldMoveUp = false;
                break;
            case KeyPressedEvent.VK_DOWN:
                shouldMoveDown = false;
                break;
            case KeyPressedEvent.VK_LEFT:
                shouldMoveLeft = false;
                break;
            case KeyPressedEvent.VK_RIGHT:
                shouldMoveRight = false;
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("CircleControl");
    }
}
