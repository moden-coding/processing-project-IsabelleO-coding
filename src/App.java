import processing.core.*;

public class App extends PApplet {
    float circleX = 250; // starting x-corrdinate for circle
    float circleY = 250; // starting y-corrdinate for circle
    int rectX;
    int rectY;
    int score = 0; //score keeper

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        chooseRandomRectangle();

    }

    public void settings() {
        size(500, 500);
    }

    public void chooseRandomRectangle(){
        int randomRect = (int) random(3); //choose one of four positions for the rectangle
        if (randomRect == 0) { //one position of rectangle
            rectX = 100;
            rectY = 100;
        } else if (randomRect == 1) { //another position of rectangle
            rectX = 250;
            rectY = 100;
        } else if (randomRect == 2) { //another position
            rectX = 100;
            rectY = 250;
        } else if (randomRect == 3) { //another position
            rectX = 250;
            rectY = 250;
        }
    }

    public void draw() {
        background(255);
        rect(rectX, rectY, 150, 150);
        circle(circleX, circleY, 50);
        //if (((circleX - 50) > (rectX)) && ((circleX+50) < (rectX + 150)) && ((circleY - 50) > (rectY)) && ((circleY + 50) < (rectY + 150))) { //check to see if circle overlapps with rectangle if rectangle is in top left corner
        //    System.out.println("they are overlapping");
        //}
        //float closestX = constrain(circleX, rectX, rectX+150); // finds the closes x - corrdinate on the rectangle to the circle
        //float closestY = constrain(circleY, rectY, rectY+150); // finds the closes y - corrdinate on the rectangle to the circle
        //float distance = dist(circleX, circleY, closestX, closestY); // finds distance between circle center and closest rectangle point
        //if (distance <= 50) {
        //    System.out.println("overlapping");
        //}
        if (isCircleInsideRectangle(circleX, circleY, rectX, rectY)) {
            System.out.println("fully inside");
        }

        boolean isCircleInsideRectangle(circleX, circleY, rectX, rectY) {
            return (circleX - 25 >= rectX && //checking leftbounds
                    circleX + 25 <= rectX + 150 && //checking rightbounds
                    circleY - 25 >= rectY && //checking upperbounds
                    circleY + 25 <= rectY + 150); //checking lowerbounds
        }

    }

    public void keyPressed() {
        if (keyCode == UP) {
            circleY -= 10; // move circle up with arrow key
        } else if (keyCode == DOWN) {
            circleY += 10; // move circle down with arrow key
        } else if (keyCode == RIGHT) {
            circleX += 10; // move circle right with arrow key
        } else if (keyCode == LEFT) {
            circleX -= 10; // move circle left with arrow key
        }
    }

    public void mousePressed(){
        setup();
    }
}
