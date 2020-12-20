package sibsutis.labyrinth.core;

/**
 * Класс лабиринта
 */
public class Labyrinth {
    private int width;
    private int height;
    private int[][] core;

    public Labyrinth(int width, int height, int[][] core) {
        this.width = width;
        this.height = height;
        this.core = core;
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

    public int[][] getCore() {
        return core;
    }

    public void setCore(int[][] core) {
        this.core = core;
    }
}
