package org.example;

import org.example.logic.Ball;
import org.example.logic.Direction;
import org.example.logic.Wall;

import java.awt.*;
import java.util.ArrayList;

public class GameLogic {
    private Ball ball;
    private boolean ballCollided;
    private ArrayList<Wall> walls;

    public GameLogic() {
        this.ball = null;
        this.walls = new ArrayList<>();
        this.ballCollided=false;
    }

    public void initialize() {

        ball = new Ball(20, 20, 50, 50, Color.BLUE);

        Wall wall1 = new Wall(250, 30, 250, 130, Color.BLACK);
       // Wall wall2 = new Wall(350, 50, 150, 100, Color.BLACK); //200
        walls.add(wall1);
        //walls.add(wall2);
    }

    public void update() {
         // ball.move(5, Direction.RIGHT);
        int wallCollisionRange=5;
        int ballCollisionRange=5;
            Rectangle ballBounds= new Rectangle(ball.getX() - ballCollisionRange, ball.getY() - ballCollisionRange, ball.getWidth() + 2*ballCollisionRange, ball.getHeight()+ 2*ballCollisionRange);
          //1Rectangle ballBounds= ball.getBallRectangle();
          for (Wall wall:walls){
              Rectangle wallBounds= new Rectangle(wall.getCoordStart().x - wallCollisionRange, wall.getCoordStart().y- wallCollisionRange, Math.abs(wall.getCoordEnd().x- wall.getCoordStart().x) + 2* wallCollisionRange, Math.abs(wall.getCoordEnd().y - wall.getCoordStart().y) + 2 * wallCollisionRange);
              //1Rectangle wallBounds= wall.getBounds();
              //System.out.println("Ball bounds: "+ ballBounds);
              //System.out.println("Wall bounds: "+ wallBounds );
              if (ballBounds.intersects(wallBounds)){
                  System.out.println("Collision");

                  ballCollided=true;
                  return;
              }
          }
          ballCollided = false;
    }

    public Ball getBall() {
        return ball;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }
}
