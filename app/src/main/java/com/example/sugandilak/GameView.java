package com.example.sugandilak;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class GameView extends View {

    //enum de las direcciones que puede tomar el jugador en el laberinto
    public enum Direction{
        UP, DOWN, LEFT, RIGHT, OTRAVEZ
    }

    //las celdas son cada cuadradito del laberinto
    public Cell[][] cells;
    // los cuadraditos del jugador y la casilla de meta
    public Cell player, exit;
    //las columnas y las filas de laberinto
    private static final int COLS = 14, ROWS = 12;
    //la anchura de las paredes del laberinto
    private static final float WALL_THICKNESS = 4;
    //el tamaño y los margenes de cada casilla
    private float cellSize, hMargin, vMargin;
    //los colores de las paredes, el jugador y la casilla de salida
    private Paint wallPaint, playerPaint, exitPaint;
    private Random random;
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //se settea los colores
        wallPaint = new Paint();
        wallPaint.setColor(Color.BLACK);
        wallPaint.setStrokeWidth(WALL_THICKNESS);
        random = new Random();

        playerPaint = new Paint();
        playerPaint.setColor(Color.rgb(80, 134, 193));
        exitPaint = new Paint();
        exitPaint.setColor(Color.rgb(255, 128, 151));

        //ejecutamos la función
        createMaze();
    }

    //función que crea el el camino del laberinto
    private Cell getNeighbour(Cell cell){
        ArrayList<Cell> neighbours = new ArrayList<>();

        //left
        if(cell.col > 0){
            if(!cells[cell.col-1][cell.row].visited){
                neighbours.add(cells[cell.col-1][cell.row]);
            }
        }
        //right
        if(cell.col < COLS-1){
            if(!cells[cell.col+1][cell.row].visited){
                neighbours.add(cells[cell.col+1][cell.row]);
            }
        }
        //top
        if(cell.row > 0){
            if(!cells[cell.col][cell.row-1].visited){
                neighbours.add(cells[cell.col][cell.row-1]);
            }
        }
        //bottom
        if(cell.row < ROWS-1){
            if(!cells[cell.col][cell.row+1].visited){
                neighbours.add(cells[cell.col][cell.row+1]);
            }
        }

        if(neighbours.size()>0){
            int index = random.nextInt(neighbours.size());
            return neighbours.get(index);
        }

        return null;

    }

    //funcion que settea los boleanos de cada casilla, para construir sus paredes
    private void removeWall(Cell current, Cell next){
        if(current.col == next.col && current.row == next.row+1){
            current.topWall = false;
            next.bottomWall = false;
        }

        if(current.col == next.col && current.row == next.row-1){
            current.bottomWall = false;
            next.topWall = false;
        }

        if(current.col == next.col+1 && current.row == next.row){
            current.leftWall = false;
            next.rightWall = false;
        }

        if(current.col == next.col-1 && current.row == next.row){
            current.rightWall = false;
            next.leftWall = false;
        }
    }

    //función que crea el espacio del laberinto con sus casillas
    private void createMaze(){
        Stack<Cell> stack = new Stack<Cell>();
        Cell current, next;

        cells = new Cell[COLS][ROWS];

        for(int x = 0; x<COLS; x++){
            for(int y = 0; y< ROWS; y++){
                cells[x][y] = new Cell(x, y);
            }
        }

        player = cells[0][0];
        exit = cells[COLS-1][ROWS-1];

        current = cells[0][0];
        current.visited = true;
        do {
            next = getNeighbour(current);

            if (next != null) {
                removeWall(current, next);
                stack.push(current);
                current = next;
                current.visited = true;
            } else {
                current = stack.pop();
            }
        }while(!stack.isEmpty());
    }

    //función que dibuja el laberinto
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        canvas.drawColor(Color.rgb(119,221,119));
        Paint paint = new Paint();
        Rect r = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());


        // border
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);
        canvas.drawRect(r, paint);

        int width = getWidth();
        int height = getHeight();

        if(width/height < COLS/ROWS){
            cellSize = width/(COLS+1);
        }else{
            cellSize = height/(ROWS+1);
        }

        hMargin = (width-COLS*cellSize)/2;
        vMargin = (height-ROWS*cellSize)/2;

        canvas.translate(hMargin, vMargin);

        for(int x = 0; x<COLS; x++){
            for(int y = 0; y<ROWS; y++){
                if(cells[x][y].topWall){
                    canvas.drawLine(
                            x*cellSize,
                            y*cellSize,
                            (x+1)*cellSize,
                            y*cellSize,
                            wallPaint);
                }
                if(cells[x][y].bottomWall){
                    canvas.drawLine(
                            x*cellSize,
                            (y+1)*cellSize,
                            (x+1)*cellSize,
                            (y+1)*cellSize,
                            wallPaint);
                }
                if(cells[x][y].leftWall){
                    canvas.drawLine(
                            x*cellSize,
                            y*cellSize,
                            x*cellSize,
                            (y+1)*cellSize,
                            wallPaint);
                }
                if(cells[x][y].rightWall){
                    canvas.drawLine(
                            (x+1)*cellSize,
                            y*cellSize,
                            (x+1)*cellSize,
                            (y+1)*cellSize,
                            wallPaint);
                }
            }
        }

        float margin = cellSize/10;

        canvas.drawRect(player.col*cellSize+margin,
                player.row*cellSize+margin,
                (player.col+1)*cellSize-margin,
                (player.row+1)*cellSize-margin,
                playerPaint);

        canvas.drawRect(exit.col*cellSize+margin,
                exit.row*cellSize+margin,
                (exit.col+1)*cellSize-margin,
                (exit.row+1)*cellSize-margin,
                exitPaint);


    }

    //función que comprueba el movimiento del jugador
    public void movePlayer(Direction direction){
        switch(direction){
            case UP:
                if(!player.topWall){
                    player = cells[player.col][player.row-1];
                }
                break;
            case DOWN:
                if(!player.bottomWall){
                    player = cells[player.col][player.row+1];
                }
                break;
            case LEFT:
                if(!player.leftWall){
                    player = cells[player.col-1][player.row];
                }
                break;
            case RIGHT:
                if(!player.rightWall){
                    player = cells[player.col+1][player.row];
                }
                break;
            case OTRAVEZ:
                player = cells[0][0];
                break;
        }
        invalidate();
    }



    //la clase de la celda o casilla, casa casilla tiene 4 booleanos, que comprueban si tienen o no paredes
    public class Cell{
        boolean
            topWall = true,
            bottomWall = true,
            leftWall = true,
            rightWall = true,
        visited = false;

        public int col, row;

        public Cell(int col, int row) {
            this.col = col;
            this.row = row;
        }


    }
}
