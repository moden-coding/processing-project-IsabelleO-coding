import processing.core.*;
import java.util.*;

public class App extends PApplet {
    float circleX = 250; //starting x-corrdinate for circle
    float circleY = 250; //starting y-corrdinate for circle
    int score = 0; //score keeper
    int color1 = color(125, 286, 255); //lines 8-11 are possible colors
    int color2 = color(34, 139, 34);
    int color3 = color(252, 142, 172);
    int color4 = color(255, 215, 0);
    int circleColor; //the color of the circle
    ArrayList<Integer> colors = new ArrayList<>(); //making a list of colors that the rectangles can be
    boolean up, down, right, left; //making booleans for direction of circle

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        // chooseRandomRectangle();
        colors.add(color1);
        colors.add(color2);
        colors.add(color3);
        colors.add(color4);
        Collections.shuffle(colors);

        int randomColor = (int)random(4); //generating a random color for the circle from the list of colors
        if (randomColor == 0) {
            circleColor = colors.get(0);
        }
        if (randomColor == 1) {
            circleColor = colors.get(1);
        }
        if (randomColor == 2) {
            circleColor = colors.get(2);
        }
        if (randomColor == 3) {
            circleColor = colors.get(3);
        }
    }

    public void settings() {
        size(500, 500);
    }

    // public void chooseRandomRectangle() {
    // int randomRect1 = (int)random(4); // choose one of four positions for the
    // rectangle
    // if (randomRect1 == 0) { // one position of rectangle
    // rectX = 100;
    // rectY = 100;
    // } else if (randomRect1 == 1) { // another position of rectangle
    // rectX = 250;
    // rectY = 100;
    // } else if (randomRect1 == 2) { // another position
    // rectX = 100;
    // rectY = 250;
    // } else if (randomRect1 == 3) { // another position
    // rectX = 250;
    // rectY = 250;
    // }
    // }

    public void draw() {
        background(0);
        fill(colors.get(0));
        rect(100, 100, 150, 150);
        fill(colors.get(1));
        rect(250, 100, 150, 150);
        fill(colors.get(2));
        rect(100, 250, 150, 150);
        fill(colors.get(3));
        rect(250, 250, 150, 150);
        fill(circleColor);
        circle(circleX, circleY, 50);
        // if (isCircleInsideRectangle(circleX, circleY, rect1X, rect1Y)) {
        // System.out.println("fully inside");
        // }
        if (up) {
            circleY -= 5;
        } if (down) {
            circleY += 5;
        } if (right) {
            circleX += 5;
        } if (left) {
            circleX -= 5;
        }
    }

    public boolean isCircleInsideRectangle(float cX, float cY, int rX, int rY) { // chat GPT
        return (cX - 25 >= rX && // checking leftbounds
                cX + 25 <= rX + 150 && // checking rightbounds
                cY - 25 >= rY && // checking upperbounds
                cY + 25 <= rY + 150); // checking lowerbounds
    }

    public void keyPressed() {
        if (keyCode == UP) {
            up = true;
        } else if (keyCode == DOWN) {
            down = true;
        } else if (keyCode == RIGHT) {
            right = true;
        } else if (keyCode == LEFT) {
            left = true;
        }
    }

    public void keyReleased() {
        if (keyCode == UP) {
            up = false;
        } else if (keyCode == DOWN) {
            down = false;
        } else if (keyCode == RIGHT) {
            right = false;
        } else if (keyCode == LEFT) {
            left = false;
        }
    }

    public void mousePressed() {
        setup();
    }
}
