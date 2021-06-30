package com.test;

import java.math.BigDecimal;
import java.util.HashSet;

public class BoardGame {
    private int numberOfGame;
    private Dimension dimension;
    private String name;
    private String colour;
    private BigDecimal price;

    public BoardGame(int numberOfGame,Dimension dimension, String name, String colour, BigDecimal price) {
        this.numberOfGame=numberOfGame;
        this.dimension = dimension;
        this.name = name;
        this.colour = colour;
        this.price = price;
    }

    public int getNumberOfGame() {
        return numberOfGame;
    }

    public String getName() {
        return name;
    }

    public Dimension getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "numberOfGame=" + numberOfGame +
                ", width=" + dimension.getWidth() +
                ", height=" + dimension.getHeight() +
                ", depth=" + dimension.getDepth() +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardGame boardGame = (BoardGame) o;

        if (!dimension.equals(boardGame.dimension)) return false;
        if (!name.equals(boardGame.name)) return false;
        return colour.equals(boardGame.colour);
    }

    @Override
    public int hashCode() {
        int result = dimension.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + colour.hashCode();
        return result;
    }
}
