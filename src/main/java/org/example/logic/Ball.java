package org.example.logic;

import java.awt.*;

public class Ball {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Ball(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isCollided (Rectangle otherObject) {
        return getBallRectangle().intersects(otherObject);
    }
    public Rectangle getBallRectangle(){
        return new Rectangle(x, y, width, height);
    }

    public void move(int steps, Direction direction) {
        switch (direction) {
            case LEFT -> {
                this.x -= steps;
            }
            case RIGHT -> {
                this.x += steps;
            }
            case UP -> {
                this.y -= steps;
            }
            case DOWN -> {
                this.y += steps;
            }
        }
    }
}
