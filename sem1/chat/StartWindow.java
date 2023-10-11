package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StartWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 150;
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    private static final String BACKUP_PATH = "bc.txt";
    private static final String MSG_CONNECTION = "Вошел пользователь ";

    private ChatWindow chatWindow;

    private String server;
    private String port;
    private String login;
    private String password;
    private final JTextField serverIPField = new JTextField("Введите IP сервера");
    private final JTextField serverPortField = new JTextField("Введите порт сервера");
    private final JTextField loginField = new JTextField("Введите ваш логин");
    private final JTextField passwordField = new JTextField("Введите ваш пароль");
    private final JButton buttonConnect = new JButton("Подключиться");
    private final JButton exitButton = new JButton("Выход");

    public StartWindow() {
        initializeUI();
        setupEventHandlers();
    }

    private void initializeUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Окно подключения к чату");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setResizable(false);

        chatWindow = new ChatWindow(this);

        // фейк кнопка для фокуса поля
        JButton fakeButton = new JButton();
        fakeButton.setOpaque(false);
        fakeButton.setContentAreaFilled(false);
        fakeButton.setBorderPainted(false);
        add(fakeButton);

        JPanel labelPanel = new JPanel();
        labelPanel.add(new JLabel("Введите адрес сервера и порт для подключения: "));

        JPanel menu = new JPanel(new GridLayout(3, 0));
        menu.add(serverIPField);
        menu.add(serverPortField);
        menu.add(loginField);
        menu.add(passwordField);
        menu.add(buttonConnect);
        menu.add(exitButton);

        add(labelPanel, BorderLayout.NORTH);
        add(menu, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void setupEventHandlers() {
        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        serverIPField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                serverIPField.setText(""); // очищаем поле при получении фокуса
            }
        });

        serverPortField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                serverPortField.setText(""); // очищаем поле при получении фокуса
            }
        });
        loginField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                loginField.setText(""); // очищаем поле при получении фокуса
            }
        });
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setText(""); // очищаем поле при получении фокуса
            }
        });
    }

    private void connectToServer() {
        server = serverIPField.getText();
        port = serverPortField.getText();
        login = loginField.getText();
        password = passwordField.getText();

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat(" yyyy.MM.dd'-'HH:mm");
        String msg = MSG_CONNECTION + login + formatForDateNow.format(dateNow);
        Logger.writeToFile(BACKUP_PATH, msg + '\n');
        chatWindow.setVisible(true);
        setVisible(false);
    }

    public String getLogin() {
        return login;
    }

    public String getBACKUP_PATH() {
        return BACKUP_PATH;
    }

}
