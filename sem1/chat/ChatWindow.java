package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private final JTextField entryField = new JTextField("Поле для ввода сообщений");
    private final JTextArea fieldView = new JTextArea();
    private final JButton sendButton = new JButton("Отправить");
    private final JButton backButton = new JButton("Назад");
    private final StartWindow startWindow;

    public ChatWindow(StartWindow startWindow) {
        this.startWindow = startWindow;
        initializeUI();
        setupEventHandlers();
    }

    private void initializeUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(startWindow);

        loadChatHistory();

        fieldView.setEditable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(new JScrollPane(fieldView),BorderLayout.CENTER);

        mainPanel.add(entryField, BorderLayout.SOUTH);

        //entryField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        entryField.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));

        add(mainPanel);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(sendButton);
        buttonPanel.add(backButton);
        return buttonPanel;
    }

    private void setupEventHandlers() {
        backButton.addActionListener(e -> {
            startWindow.setVisible(true);
            setVisible(false);
        });

        entryField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                entryField.setText(""); // очищаем поле при получении фокуса
            }
        });

        entryField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    logMessage();
                }
            }
        });

        sendButton.addActionListener(e -> logMessage());
    }

    private void loadChatHistory() {
        try {
            String chatHistory = Logger.readFromFile(startWindow.getBACKUP_PATH());
            fieldView.append(chatHistory);
        } catch (Exception e) {
            System.err.println("Failed to load chat history: " + e.getMessage());
        }
    }

    private void logMessage() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd'-'HH:mm");
        String msg = formatForDateNow.format(dateNow) + " " + startWindow.getLogin() + ": " + entryField.getText() + '\n';
        Logger.writeToFile(startWindow.getBACKUP_PATH(), msg);
        fieldView.append(msg);
        entryField.setText("");
    }
}
