package net.mooctest;

public final class BoundaryFill_Test {

    public static int getPixel(int[][] image, int x, int y) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length) {
            return -1;
        }
        return image[x][y];
    }

    public static void putPixel(int[][] image, int x, int y, int newColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length) {
            return;
        }
        image[x][y] = newColor;
    }

    public static void boundaryFill(int[][] image, int x, int y, int newColor, int boundaryColor) {
        int oldColor = getPixel(image, x, y);
        if (oldColor == newColor || oldColor == boundaryColor) {
            return;
        }
        putPixel(image, x, y, newColor);
        boundaryFill(image, x + 1, y, newColor, boundaryColor);
        boundaryFill(image, x - 1, y, newColor, boundaryColor);
        boundaryFill(image, x, y + 1, newColor, boundaryColor);
        boundaryFill(image, x, y - 1, newColor, boundaryColor);
    }

    public static void printImageArray(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] image = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 3, 3, 3, 3, 0, 0},
            {0, 3, 0, 0, 3, 0, 0},
            {0, 3, 0, 0, 3, 3, 3},
            {0, 3, 3, 3, 0, 0, 3},
            {0, 0, 0, 3, 0, 0, 3},
            {0, 0, 0, 3, 3, 3, 3},
        };
        boundaryFill(image, 2, 2, 5, 3);
        printImageArray(image);
    }
}
