import processing.core.*;
import java.util.*;

public class App extends PApplet {
    float circleX = 220; // starting x-corrdinate for circle
    float circleY = 220; // starting y-corrdinate for circle
    int score = 0; // score keeper
    int color1 = color(125, 286, 255); // lines 8-11 are possible colors
    int color2 = color(34, 139, 34);
    int color3 = color(252, 142, 172);
    int color4 = color(255, 215, 0);
    int color5 = color(255, 0, 255);
    int color6 = color(255, 219, 88);
    int color7 = color(57, 255, 20);
    int color8 = color(173, 216, 230);
    int color9 = color(128, 0, 0);
    int color10 = color(238, 130, 238);
    int color11 = color(255, 127, 80);
    int color12 = color(80, 200, 120);
    int color13 = color(75, 0, 130);
    int color14 = color(128, 128, 0);
    int color15 = color(255, 255, 204);
    int color16 = color(204, 85, 0);
    int circleColor; // the color of the circle
    ArrayList<Integer> colors; // making a list of colors that the rectangles can be
    boolean up, down, right, left; // making booleans for direction of circle
    float rectX0 = 100, rectY0 = 100; // defining position of rectangles
    float rectX1 = 160, rectY1 = 100;
    float rectX2 = 220, rectY2 = 100;
    float rectX3 = 280, rectY3 = 100;
    float rectX4 = 100, rectY4 = 160;
    float rectX5 = 160, rectY5 = 160;
    float rectX6 = 220, rectY6 = 160;
    float rectX7 = 280, rectY7 = 160;
    float rectX8 = 100, rectY8 = 220;
    float rectX9 = 160, rectY9 = 220;
    float rectX10 = 220, rectY10 = 220;
    float rectX11 = 280, rectY11 = 220;
    float rectX12 = 100, rectY12 = 280;
    float rectX13 = 160, rectY13 = 280;
    float rectX14 = 220, rectY14 = 280;
    float rectX15 = 280, rectY15 = 280;
    float overlappingRectX; // postition of the rectangle that the circle shares a color with that the
                            // circle has to overlap with
    float overlappingRectY;
    boolean scoreable;
    int stage = 0;
    float timer;
    float exponent = -2.1f; // x-value in exponential equation
    boolean timeOn = true; // track when time is counting down verses when it has reached 0 and should stop
    int endingButtonColor = color(42, 82, 190); // setting color to single integer value
    int startingButtonColor = color(255, 0, 255); // setting color to single integer value
    float circleDiameter = 30; // use variable so only have to change in one place
    float rectWidth = 60; // same reason as line 53
    float rectHeight = 60; // same reason as line 53

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        if (score == 0) {
            timer = 30;
        } else if (score > 0) {
            exponent += 0.1; // increasing x-value so that y-value(timer) decreases
            timer = (float) Math.pow((1.0 / 5), exponent); // equaiton for decreasing timer
        }
        scoreable = true;
        colors = new ArrayList<>(); // setting up aray list
        colors.add(color1);
        colors.add(color2);
        colors.add(color3);
        colors.add(color4);
        colors.add(color5);
        colors.add(color6);
        colors.add(color7);
        colors.add(color8);
        colors.add(color9);
        colors.add(color10);
        colors.add(color11);
        colors.add(color12);
        colors.add(color13);
        colors.add(color14);
        colors.add(color15);
        colors.add(color16);
        Collections.shuffle(colors);

        circleX = 220; // setting circle back to original position
        circleY = 220;

        int randomColor = (int) random(16); // generating a random color for the circle from the list of colors
        if (randomColor == 0) {
            circleColor = colors.get(0);
            overlappingRectX = rectX0; // sets the overlappingRect variable to the value of the rectangle that is the
                                       // same color as the circle so that I can use the overlappingRect variable to
                                       // check if circle and rect are overlapping later
            overlappingRectY = rectY0;
        }
        if (randomColor == 1) {
            circleColor = colors.get(1);
            overlappingRectX = rectX1;
            overlappingRectY = rectY1;
        }
        if (randomColor == 2) {
            circleColor = colors.get(2);
            overlappingRectX = rectX2;
            overlappingRectY = rectY2;
        }
        if (randomColor == 3) {
            circleColor = colors.get(3);
            overlappingRectX = rectX3;
            overlappingRectY = rectY3;
        }
        if (randomColor == 4) {
            circleColor = colors.get(4);
            overlappingRectX = rectX4;
            overlappingRectY = rectY4;
        }
        if (randomColor == 5) {
            circleColor = colors.get(5);
            overlappingRectX = rectX5;
            overlappingRectY = rectY5;
        }
        if (randomColor == 6) {
            circleColor = colors.get(6);
            overlappingRectX = rectX6;
            overlappingRectY = rectY6;
        }
        if (randomColor == 7) {
            circleColor = colors.get(7);
            overlappingRectX = rectX7;
            overlappingRectY = rectY7;
        }
        if (randomColor == 8) {
            circleColor = colors.get(8);
            overlappingRectX = rectX8;
            overlappingRectY = rectY8;
        }
        if (randomColor == 9) {
            circleColor = colors.get(9);
            overlappingRectX = rectX9;
            overlappingRectY = rectY9;
        }
        if (randomColor == 10) {
            circleColor = colors.get(10);
            overlappingRectX = rectX10;
            overlappingRectY = rectY10;
        }
        if (randomColor == 11) {
            circleColor = colors.get(11);
            overlappingRectX = rectX11;
            overlappingRectY = rectY11;
        }
        if (randomColor == 12) {
            circleColor = colors.get(12);
            overlappingRectX = rectX12;
            overlappingRectY = rectY12;
        }
        if (randomColor == 13) {
            circleColor = colors.get(13);
            overlappingRectX = rectX13;
            overlappingRectY = rectY13;
        }
        if (randomColor == 14) {
            circleColor = colors.get(14);
            overlappingRectX = rectX14;
            overlappingRectY = rectY14;
        }
        if (randomColor == 15) {
            circleColor = colors.get(15);
            overlappingRectX = rectX15;
            overlappingRectY = rectY15;
        }
    }

    public void settings() {
        size(440, 500);
    }

    public void draw() {
        if (stage == 0) { // setting up start screen
            background(255);
            fill(0);
            textSize(40);
            textAlign(CENTER, CENTER);
            text("Welcome to my game!", 220, 50);
            textSize(30);
            text("Here's what you need to know", 220, 100);
            textSize(20);
            text("Control the circle using the arrow keys", 220, 150);
            text("Make sure to do all this before time runs out!", 220, 250);
            text("Move the circle to fully overlapp with the square", 220, 200);
            text("of the same color", 220, 220);
            textSize(15);
            textAlign(CENTER, CENTER);
            text("Click magenta botton to continue to game", 220, 332);
            fill(255, 0, 255);
            circle(220, 390, 75);
        }
        if (stage == 1) {
            if (timeOn) {
                timer -= .02; // makes countdown
            }
            if (timer <= 0) {
                timeOn = false; // stopes timer from decreasing
                stage = 2; // calls end screen
            }
            background(0);
            fill(255, 255, 255);
            textSize(20);
            textAlign(LEFT, CENTER);
            text("Countdown: " + timer, 10, 25);
            text("Score: " + score, 10, 50);
            drawSquares();
            fill(circleColor);
            circle(circleX, circleY, circleDiameter);
            if (scoreable == true && !(timer == 0)
                    && isCircleInsideRectangle(circleX, circleY, overlappingRectX, overlappingRectY)) { // if circle and
                                                                                                        // rectangle are
                                                                                                        // overlapping
                                                                                                        // do
                                                                                                        // what is in
                                                                                                        // this
                                                                                                        // if statement
                score += 1; // increase score by 1 when overlapping (shouldnt be in draw because it
                            // constantly increases score it doesn't just increase it once per overlap)

                scoreable = false;
                setup();
                // make other rectangles that are not the overlapping one disapear (once I
                // establish a timer I want these rectangles to disapear once timer runs out)
            }
            if (up) { // lines 81-88 moves circle around
                circleY -= 5;
            }
            if (down) {
                circleY += 5;
            }
            if (right) {
                circleX += 5;
            }
            if (left) {
                circleX -= 5;
            }
        }
        if (stage == 2) {
            background(255);
            fill(42, 82, 190);
            circle(250, 400, 75);
            fill(0);
            textSize(60);
            textAlign(CENTER, BOTTOM); // centers text
            text("Oh no! You lost :(", 220, 200);
            textSize(50);
            textAlign(CENTER, TOP); // centers text
            text("Score: " + score, 220, 200);
            textSize(25);
            textAlign(CENTER, BOTTOM);
            text("Click blue button to restart", 220, 350);
        }
    }

    public void drawSquares() { // draws the 16 squares I have on my screen
        int rectX = 100;
        int rectY = 100;
        for (int assignedRect = 0; assignedRect < colors.size(); assignedRect++) {
            fill(colors.get(assignedRect));
            rect(rectX, rectY, rectWidth, rectHeight);
            rectX += 60;
            if (assignedRect % 4 == 3) {
                rectY += 60;
                rectX = 100;
            }
        }
    }

    public boolean isCircleInsideRectangle(float cX, float cY, float rX, float rY) { // chat GPT but I understand,
                                                                                     // checking to see if circle is
                                                                                     // fully inside rectangle
        return (cX - (circleDiameter / 2) >= rX && // checking leftbounds
                cX + (circleDiameter / 2) <= rX + rectWidth && // checking rightbounds
                cY - (circleDiameter / 2) >= rY && // checking upperbounds
                cY + (circleDiameter / 2) <= rY + rectHeight); // checking lowerbounds
    }

    public void keyPressed() { // lines 99-107 uses if functions to make movment smoother when pressing on keys
        if (keyCode == UP) {
            up = true;
        } else if (keyCode == DOWN) {
            down = true;
        } else if (keyCode == RIGHT) {
            right = true;
        } else if (keyCode == LEFT) {
            left = true;
        }
        if (key == ' ') {
            stage = 2;
        }
    }

    public void keyReleased() { // lines 111-119 uses if functions to make stopping smother when not pressing on
                                // keys
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

    public void mousePressed() { // defines what happens when I press on a colored button on the start screen and
                                 // end screen (one is the start the game the other is to restart the game)
        if (stage == 2) {
            if (get(mouseX, mouseY) == endingButtonColor) {
                exponent = -2.1f;
                score = 0;
                timeOn = true;
                setup();
                stage = 1;
            }
        } else if (stage == 0) {
            if (get(mouseX, mouseY) == startingButtonColor) {
                stage = 1;
            }
        }
    }
}
