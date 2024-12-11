package stacklab;

import java.util.*;

public class UndoRedoPainter extends Painter
{
    private Stack<Circle> undoHistory = new Stack<>();

    // Called when the user pushes the Undo button.
    void undo()
    {
        Stack<Circle> history = getHistory();

        if (!history.empty()) {
            Circle circle = history.pop();
            undoHistory.push(circle);
            repaint();
        }
    }

    // Called when the user pushes the Redo button.
    void redo()
    {
        if (!undoHistory.empty()) {
            Circle circle = undoHistory.pop();
            getHistory().push(circle);
            repaint();
        }
    }

    public static void main(String[] args)
    {
        new UndoRedoPainter().setVisible(true);
    }
}
