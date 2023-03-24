package Homeworks.HWL5;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;

/*
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. 
 * И вывести Доску. 
 * Пример вывода доски 8x8
0x000000
0000x000
00x00000
 */
public class task3 {
    public static void main(String[] args) {
        int size = 8;
        QueensBoards queensBoards = new QueensBoards(size);
        System.out.printf("Всего вариантов решений для доски %dх%d: %d \n", size, size,
                queensBoards.getCountVariants());
        System.out.println("Один из возможных вариантов решений для доски 8х8:");
        System.out.println(queensBoards.getRandomVariant().forPrint());
    }
}

class QueensBoards {
    /* класс Доски со всеми ферзями */
    private List<ChessBoard> variants;

    public QueensBoards(int size) {
        this.variants = new LinkedList<ChessBoard>();
        getDecision(size);
    }

    public void getDecision(int size) {
        /* метод получения вариантов досок со всеми ферзями */
        ChessBoard chessBoard = new ChessBoard(size);
        PossibleCages possibleCages = new PossibleCages(size);
        getDecision(chessBoard, possibleCages, 0, size);
    }

    private void getDecision(ChessBoard chessBoard, PossibleCages possibleCages, int rowNumber, int size) {
        /* метод получения вариантов досок со всеми ферзями */
        if (rowNumber == size) {
            this.variants.add(chessBoard);
            return;
        }
        for (int column = 0; column < size; column++) {
            if (possibleCages.getPossibleCage(rowNumber, column)) {
                ChessBoard newBoard = new ChessBoard(chessBoard);
                newBoard.setQueen(rowNumber, column, true);
                PossibleCages nextPossibleCages = new PossibleCages(possibleCages);
                setImpossibleCages(rowNumber, column, nextPossibleCages, size);
                getDecision(newBoard, nextPossibleCages, rowNumber + 1, size);
            }
        }
    }

    public int getCountVariants() {
        /* метод получения количества вариантов досок со всеми ферзями */
        return this.variants.size();
    }

    public ChessBoard getRandomVariant() {
        /* метод получения одного рандомного из всех вариантов досок со всеми ферзями */
        Random rand = new Random();
        return this.variants.get(rand.nextInt(this.variants.size()));
    }

    private void setImpossibleCages(int row, int column, PossibleCages possibleCages, int size) {
        /*
         * метод обозначения клеток, на которые нельзя установить остальные фигуры
         * ферзей,
         * относительно указанного места с координатами row и column, на котором стоит
         * текущий ферзь
         */
        setImpossibleRow(row, possibleCages, size);
        setImpossibleColumn(column, possibleCages, size);
        setImpossibleDiagonal(row, -1, column, -1, possibleCages, size);
        setImpossibleDiagonal(row, 1, column, 1, possibleCages, size);
        setImpossibleDiagonal(row, 1, column, -1, possibleCages, size);
        setImpossibleDiagonal(row, -1, column, 1, possibleCages, size);
    }

    private void setImpossibleRow(int row, PossibleCages possibleCages, int size) {
        /*
         * метод обозначения клеток по горизонтали (строке), на которые нельзя
         * установить остальные фигуры ферзей,
         * относительно указанного места с координатами row и column, на котором стоит
         * текущий ферзь
         */
        for (int j = 0; j < size; j++) {
            possibleCages.setImpossible(row, j, false);
        }
    }

    private void setImpossibleColumn(int column, PossibleCages possibleCages, int size) {
        /*
         * метод обозначения клеток по вертикали (столбцу), на которые нельзя установить
         * остальные фигуры ферзей,
         * относительно указанного места с координатами row и column, на котором стоит
         * текущий ферзь
         */
        for (int i = 0; i < size; i++) {
            possibleCages.setImpossible(i, column, false);
        }
    }

    private void setImpossibleDiagonal(int row, int rowI, int column, int columnI, PossibleCages possibleCages,
            int size) {
        /*
         * метод обозначения клеток по диагонали (в зависимости от значений rowI и
         * columnI),
         * на которые нельзя установить остальные фигуры ферзей,
         * относительно указанного места с координатами row и column, на котором стоит
         * текущий ферзь
         */
        while ((row >= 0 && row < size) && (column >= 0 && column < size)) {
            possibleCages.setImpossible(row, column, false);
            row += rowI;
            column += columnI;
        }
    }
}

class ChessBoard {
    /* класс Доска */
    int size;
    boolean[][] chessBoard;

    public ChessBoard(int size) {
        this.size = size;
        this.chessBoard = new boolean[size][size];
    }

    public ChessBoard(ChessBoard oldChessBoard) {
        this.size = oldChessBoard.size;
        this.chessBoard = new boolean[size][size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.chessBoard[i][j] = oldChessBoard.chessBoard[i][j];
            }
        }
    }

    public void setQueen(int row, int column, boolean value) {
        /* метод установки ферзя */
        this.chessBoard[row][column] = value;
    }

    public String forPrint() {
        /* метод преобразования доски в строку для вывода на печать */
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                result.append((this.chessBoard[i][j] ? "1" : "0") + "\t");
            }
            result.append("\n");
        }
        return result.toString();
    }

}

class PossibleCages extends ChessBoard {
    /* наследник базового класса Доска */
    public PossibleCages(int size) {
        super(size);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.chessBoard[i][j] = true;
            }
        }
    }

    public PossibleCages(PossibleCages oldChessBoard) {
        super(oldChessBoard);
    }

    public boolean getPossibleCage(int row, int column) {
        /*
         * метод получения значения (true или false) - возможности установки ферзя
         * в указанной клетке с координатами row и column
         */
        return this.chessBoard[row][column];
    }

    public void setImpossible(int row, int column, boolean value) {
        /*
         * метод установки (обозначения) значения (false) - невозможности установки
         * ферзя
         * в указанную клетку с координатами row и column
         */
        if (this.chessBoard[row][column] != value)
            this.chessBoard[row][column] = value;
    }
}