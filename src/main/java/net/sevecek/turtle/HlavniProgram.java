package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

import javax.swing.*;

public class HlavniProgram {

    Turtle zofka;

    public void main(String[] args) {
         zofka = new Turtle();

         zofka.setLocation(800,450);
         drawLocomotive();

        zofka.setLocation(400, 450);
        drawSnowman(100);

         zofka.setLocation(200,350);
         drawIceCream(300, 30);





    }
    public void drawLocomotive(){
        double base = 100;
        double triagle = base*1.5;
        double firstP = 3*base;
        double wheelDistance1 = 3*base/4;
        double wheelDistance2 = (firstP-5*base/3);
        double smallWheel = base/2;
        double bigWheel = base;

        zofka.turnLeft(180+45);
        drawIsoscelesTriangle(triagle,90);
        zofka.turnRight(45);
        zofka.move(triagle*0.6);
        zofka.turnRight(180);

        drawRectangle(triagle, firstP);
        zofka.turnRight(90);
        zofka.move(wheelDistance1);
        drawCircle(smallWheel);
        zofka.move(wheelDistance2);
        drawCircle(smallWheel);
        zofka.move(firstP-wheelDistance1-wheelDistance2);
        zofka.turnLeft(90);
        drawRectangle(3*bigWheel, 2*bigWheel);
        drawCircle(bigWheel);

    }

    public void drawSnowman(double baseRadius){
        double bellyRadius = baseRadius*0.75;
        double headRadius = baseRadius*0.5;
        double handRadius = baseRadius*0.25;
        zofka.turnRight(90);
        drawCircle(baseRadius);
        zofka.turnRight(180);
        drawCircle(bellyRadius);

        zofka.penUp();
        zofka.turnRight(45);
        zofka.move(Math.sqrt(2*Math.pow(bellyRadius,2)));
        zofka.turnLeft(90+45);
        zofka.penDown();
        drawCircle(handRadius);

        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(2*bellyRadius);
        zofka.turnLeft(90);
        zofka.penDown();

        drawCircle(handRadius);

        zofka.penUp();
        zofka.turnLeft(45);
        zofka.move(Math.sqrt(2*Math.pow(bellyRadius,2)));
        zofka.turnLeft(45);
        zofka.penDown();

        drawCircle(headRadius);
        zofka.turnRight(90);
    }


    public void drawIceCream(double coneSide, double coneAngle){
        zofka.turnRight(180);
        drawIsoscelesTriangle(coneSide,coneAngle);
        zofka.turnRight(coneAngle/2);
        double gammaHalfInRad = degToRad(coneAngle/2);
        double iceCreamRadius = computeSideC(coneSide,coneAngle)/(2*Math.cos(gammaHalfInRad));
        drawCircle(iceCreamRadius);
        zofka.turnRight(180-coneAngle/2);
    }


    public double degToRad(double angle){
        double inRadians = angle* Math.PI/180;
        return inRadians;
    }

    public void drawIsoscelesTriangle(double sideA, double topAngle) {
        double sideC = computeSideC(sideA, topAngle);
        double alphaAngle = (180-topAngle)/2;

        zofka.turnRight(90-alphaAngle);
        zofka.move(sideA);
        zofka.turnRight(180-topAngle);
        zofka.move(sideA);
        zofka.turnRight(180-alphaAngle);
        zofka.move(sideC);
        zofka.turnRight(90);

    }
    public double computeSideC(double sideA, double topAngle){
        double sideC = Math.sqrt(2* Math.pow(sideA,2) - 2*Math.pow(sideA,2)*Math.cos(topAngle* Math.PI/180));
        return sideC;
    }

    public void drawRectangle(double sideA, double sideB) {
        for (int i = 0; i < 2; i++) {
            zofka.move(sideA);
            zofka.turnRight(90);
            zofka.move(sideB);
            zofka.turnRight(90);
        }

    }

    public void drawSquare(double side) {
        drawRectangle(side, side);
    }

    public void drawCircle(double radius) {
        double angle = Math.floor(200/radius);
        double step = computeSideC(radius, angle);

        for (int i = 0; i < 360/angle; i++) {
            zofka.move(step);
            zofka.turnRight(angle);
        }

    }
}
