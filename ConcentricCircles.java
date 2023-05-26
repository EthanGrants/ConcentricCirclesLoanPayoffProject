import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
/** ConcentricCircles.java - Concentric Circles
 * <p>Problem Statement: Using recursive techniques, create a program to solve 
 *                       concentric circles
 * </p>
 * 
 * <p>Algorithm: <br />
 * 1. Create main class <br/>
 * 2. Create a private diameter,x and y, instantiate the variables <br/>
 * 3. Create a paint method, setting it to be drawn, its coordinates and to have a diameter
 * 4. Create a left circle method,use a color created from the constructor class, and then
 *    use a recursion method. Set the color, and fill the oval, then have an if statement
 *    that decreases the diameter by 20 pixels when it is bigger than 20. Repeat for the
 *    right circle method, but decrease the diameter by 10 percent. <br/>
 * 5. In main, create the jframe, its title, location, close operation,size, center it
 *    and make it visible. <br/>
 * 6. Compile and test. <br/>
 * 
 * </p>
 * 
 *   @author Ethan Grant
 *   @version Module 14, Hw 1
 */
public class ConcentricCircles extends JFrame {
    // create private variables
    private int diameter;
    private int x;
    private int y;
    // Instantiate variable
    public ConcentricCircles(int diameter) {
        this.diameter = diameter;
        this.x = x;
        this.y = y;
    }
    // The two circles to be drawn
    public void paint(Graphics canvas) {
        drawLeft(canvas, 150, 200, diameter);
        drawRight(canvas, 450, 200, diameter);
    }
    
    // Create pattern for left circle
    /**
     * Creates left circle with decreased diameter through recursion
     * post-condition - create circle with desired parameters
     * @param canvas draw the circle
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param diameter the diameter of the circle
     * @return returns the statement
     */
    private void drawLeft(Graphics canvas, int x, int y, int diameter) {
        Color circleColor = new Color(diameter,diameter, diameter);
        canvas.setColor(circleColor);
        canvas.fillOval(x - diameter / 2, y - diameter / 2, diameter, diameter);
        // decrease diameter by 20 pixels
        if (diameter > 20) {
            diameter -= 20;
            drawLeft(canvas,x,y,diameter);
        }
        return;
    }
    // Create pattern for right circle
    /**
     * Creates right circle with decreased diameter through recursion
     * post-condition - create circle with desired parameters
     * @param canvas draw the circle
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param diameter the diameter of the circle
     * @return returns the statement
     */
    private void drawRight(Graphics canvas, int x, int y, int diameter) {
        Color circleColor = new Color(diameter,diameter, diameter);
        canvas.setColor(circleColor);
        canvas.fillOval(x - diameter / 2, y - diameter / 2, diameter, diameter);
        // decrease diameter by 0.1%
        if (diameter > 20) {
            diameter -= diameter * 0.10;
            drawRight(canvas,x,y,diameter);
        }
        return;
    }
    public static void main(String[] args) {
        // Create the JFrame and set its size, title, close operation, and location.
        ConcentricCircles frame = new ConcentricCircles(255);
        frame.setSize(600,400);
        // set the title in upper-left corner
        frame.setTitle("Concentric Circles");
        // close when X is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // center JFrame on user's screen
        frame.setLocationRelativeTo(null);
        // Make it visible
        frame.setVisible(true);
    }
}