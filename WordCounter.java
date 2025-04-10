package code.Alpha.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounter() {
        
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word Count: 0");

        
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(countButton, BorderLayout.WEST);
        bottomPanel.add(resultLabel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        
        countButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText().trim();
        if (text.isEmpty()) {
            resultLabel.setText("Word Count: 0");
        } else {
            
            String[] words = text.split("\\s+");
            resultLabel.setText("Word Count: " + words.length);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounter wc = new WordCounter();
            wc.setVisible(true);
        });
    }
}
