package crossAndNull;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    static public final int WINDOW_HEIGHT = 240;
    static public final int WINDOW_WIDTH = 320;
    static public int sliderSizeValue = 3;
    static public int sliderWinValue = 3;
    static public boolean modeValue = false;

    JLabel labelMode = new JLabel("Выберите режим игры:");

    JRadioButton humanVsHumanButton = new JRadioButton("Человек против Человека", true);
    JRadioButton humanVsCPU = new JRadioButton("Человек против Машины", false);

    ButtonGroup topButtonGroup = new ButtonGroup();

    JLabel labelSize = new JLabel(String.format("Установите размер поля: %d", sliderSizeValue));
    JSlider sliderSize = new JSlider(3, 10, sliderSizeValue);

    JLabel labelWin = new JLabel(String.format("Установите длину для победы: %d", sliderWinValue));
    JSlider sliderWin = new JSlider(3, 10, sliderWinValue);

    JPanel grid = new JPanel(new GridLayout(4, 1));

    JPanel top = new JPanel(new GridLayout(2, 1));
    JPanel topButton = new JPanel(new GridLayout(2, 1));
    JPanel middle = new JPanel(new GridLayout(2, 1));
    JPanel bottom = new JPanel(new GridLayout(2, 1));

    JButton buttonStart = new JButton("Запуск игры");

    SettingWindow(GameWindow gameWindow) {
        setTitle("Окно настроек");
        setLocation(gameWindow.getLocation().x, gameWindow.getLocation().y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        topButtonGroup.add(humanVsHumanButton);
        topButtonGroup.add(humanVsCPU);
        topButton.add(humanVsHumanButton);
        topButton.add(humanVsCPU);

        top.add(labelMode);
        top.add(topButton);

        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderSizeValue = sliderSize.getValue();
                labelSize.setText(String.format("Установите размер поля: %d", sliderSizeValue));
            }
        });
        middle.add(labelSize);
        middle.add(sliderSize);

        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderWinValue = sliderWin.getValue();
                labelWin.setText(String.format("Установите длину для победы: %d", sliderWinValue));
            }
        });
        bottom.add(labelWin);
        bottom.add(sliderWin);

        grid.add(top);
        grid.add(middle);
        grid.add(bottom);
        grid.add(buttonStart);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeValue = humanVsHumanButton.isSelected();
                gameWindow.startNewGame(modeValue, sliderSizeValue, sliderSizeValue, sliderWinValue);

                setVisible(false);
            }
        });

        add(grid);
    }


}
