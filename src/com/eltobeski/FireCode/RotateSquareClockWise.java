package com.eltobeski.FireCode;

import static com.eltobeski.FireCode.FlipItVertical.flipItVerticalAxis;
import static com.eltobeski.FireCode.RotateCounterClockwise.transpose;


//TODO PLEASE UNDERSTAND THIS!!!!
public class RotateSquareClockWise {
    public static void rotateSquareImageCW(int[][] matrix) {
        transpose(matrix);
        flipItVerticalAxis(matrix);
    }
}
