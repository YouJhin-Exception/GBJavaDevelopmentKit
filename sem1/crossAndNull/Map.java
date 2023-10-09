package crossAndNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {
    public int panelWidth;
    public int panelHeight;
    public int cellHeight;
    public int cellWidth;
    public int sizeX;
    public int sizeY;

    private int winLength;

    private int[][] field;  // 0 - пусто, 1 - крестик, 2 - нолик
    private boolean isCrossTurn;  // флаг для определения чья очередь

    Map(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;


        field = new int[sizeX][sizeY];

        isCrossTurn = true;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e.getX(), e.getY());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();
        cellHeight = panelHeight / this.sizeX;
        cellWidth = panelWidth / this.sizeY;

        g.setColor(Color.BLACK);
        for (int h = 0; h < this.sizeX; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int h = 0; h < this.sizeY; h++) {
            int x = h * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        repaint();

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (field[i][j] == 1) {
                    drawCross(g, i, j);
                } else if (field[i][j] == 2) {
                    drawNull(g, i, j);
                }
            }
        }
    }

    void startNewGame(boolean mode, int size_x, int size_y, int win_len) {
        sizeX = size_x;
        sizeY = size_y;
        winLength = win_len;
        field = new int[sizeX][sizeY];
        isCrossTurn = true;  // начинаем с крестиков
        repaint();
    }

    private void handleMouseClick(int x, int y) {
        if (!isCellEmpty(x, y)) {
            return;  // если ячейка уже занята
        }

        int cellX = x / cellWidth;
        int cellY = y / cellHeight;

        field[cellX][cellY] = isCrossTurn ? 1 : 2;  // заполняем ячейку

        if (checkWin(isCrossTurn ? 1 : 2)) {
            JOptionPane.showMessageDialog(this, "Победа игрока " + (isCrossTurn ? "Крестиков" : "Ноликов"));
            resetGame();
        } else if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "Ничья!");
            resetGame();
        } else {
            isCrossTurn = !isCrossTurn;  // меняем очередь игрока
        }

        repaint();  // перерисовываем поле

    }
    private void resetGame() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                field[i][j] = 0;
            }
        }
        isCrossTurn = true;  // начинаем с крестиков
        repaint();
    }



    private void drawCross(Graphics g, int i, int j) {
        // отрисовка крестика
    }

    private void drawNull(Graphics g, int i, int j) {
        // отрисовка нолика
    }

    private boolean checkWin(int player) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (checkDirection(i, j, 1, 0, player) ||  // проверка по горизонтали
                        checkDirection(i, j, 0, 1, player) ||  // проверка по вертикали
                        checkDirection(i, j, 1, 1, player) ||  // проверка по диагонали \
                        checkDirection(i, j, 1, -1, player)) {  // проверка по диагонали /
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int startX, int startY, int dirX, int dirY, int player) {
        int count = 0;
        for (int i = 0; i < winLength; i++) {
            int x = startX + i * dirX;
            int y = startY + i * dirY;
            if (x >= 0 && x < sizeX && y >= 0 && y < sizeY && field[x][y] == player) {
                count++;
            } else {
                break;
            }
        }
        return count == winLength;
    }


    private boolean isCellEmpty(int x, int y) {
        // проверка свободной ячейки
        return false;
    }

    private boolean isBoardFull() {
        //проверка заполнености поля
        return false;
    }


}
