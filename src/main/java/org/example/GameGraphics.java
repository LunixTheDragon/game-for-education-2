    package org.example;

    import org.example.logic.Wall;

    import javax.swing.*;
    import java.awt.*;

    public class GameGraphics extends JFrame {
        Draw draw;
        GameLogic logic;
        public GameGraphics(GameLogic logic) throws HeadlessException {

            this.draw = new Draw();
            this.logic = logic;

            setSize(1080, 720);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
            setTitle("Game");

            add(draw);
        }

        public void render(GameLogic logic) {
            this.logic = logic;
            repaint();
        }

        public class Draw extends JPanel{
            @Override
            protected void paintComponent(Graphics g) {
                //if (!logic.isBallCollided()) {
                    g.setColor(logic.getBall().getColor());
                    g.fillOval(logic.getBall().getX(), logic.getBall().getY(), logic.getBall().getWidth(), logic.getBall().getHeight());


                for (Wall wall: logic.getWalls()){
                    g.setColor(wall.getColor());
                    g.drawLine(wall.getCoordStart().x, wall.getCoordStart().y, wall.getCoordEnd().x, wall.getCoordEnd().y);
                }
            }
        }
    }
