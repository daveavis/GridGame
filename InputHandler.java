import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Write a description of class InputHandler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InputHandler implements InputProcessor
{
    public static int key;  // which key was pressed
    
    @Override
    public boolean keyDown(int keycode) 
    {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) 
    {
        key = keycode;
        return true;  // the event was handled
    }

    @Override
    public boolean keyTyped(char character) 
    {

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) 
    {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) 
    {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) 
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) 
    {
        return false;
    }

    @Override
    public boolean scrolled(int amount) 
    {
        return false;
    }
}
