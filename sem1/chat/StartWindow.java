package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class StartWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 150;
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    private final String BACKUP_PATH = "bc.txt";


    private final ChatWindow chatWindow;

    private String server;
    private String login;
    private String password;


    private JTextField serverIPFeald = new JTextField();
    private JTextField serverPortFeald = new JTextField();


    private JLabel loginLabel = new JLabel("Введите ваш логин: ");
    private JTextField loginField = new JTextField();

    private JLabel passwordLabel = new JLabel("Введите ваш пароль:");
    private JTextField passwordField = new JTextField();

    private JLabel serverLabel = new JLabel("Введите адрес сервера и порт для подключения: ");
    private JTextField serverField = new JTextField();
    private JButton buttonConnect = new JButton("Подключиться");
    private JButton exitButton = new JButton("Выход");

    public StartWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String WINDOW_TITLE = "Окно подключения к чату";
        setTitle(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setResizable(false);



        chatWindow = new ChatWindow(); //!this

        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatWindow.setVisible(true);
                setVisible(false);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });




        serverIPFeald.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                serverIPFeald.setText(""); // очищаем поле при получении фокуса
            }
        });

        serverPortFeald.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                serverPortFeald.setText(""); // очищаем поле при получении фокуса
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


        // фейк кнопка для фокуса поля
        JButton fakeButton = new JButton();
        fakeButton.setOpaque(false);
        fakeButton.setContentAreaFilled(false);
        fakeButton.setBorderPainted(false);
        add(fakeButton);


        JPanel labelPanel = new JPanel();
        JPanel menu = new JPanel(new GridLayout(3, 0));

        labelPanel.add(serverLabel);

        menu.add(serverIPFeald);
        serverIPFeald.setText("Введите IP сервера");
        menu.add(serverPortFeald);
        serverPortFeald.setText("Введите порт сервера");
        menu.add(loginField);
        loginField.setText("Введите ваш логин");
        menu.add(passwordField);

        passwordField.setText("Введите ваш пароль");

        menu.add(buttonConnect);
        menu.add(exitButton);

        add(labelPanel, BorderLayout.NORTH);

        add(menu, BorderLayout.SOUTH);






        setVisible(true);

    }


}
