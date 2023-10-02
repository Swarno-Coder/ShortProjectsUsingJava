import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempConverter extends JFrame {
    private JTextField textField;
    private JButton celsiusButton;
    private JButton fahrenheitButton;

    public TempConverter() {
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);

        textField = new JTextField(10);
        celsiusButton = new JButton("To Celsius");
        fahrenheitButton = new JButton("To Fahrenheit");

        celsiusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tempFahr = Integer.parseInt(textField.getText());
                textField.setText(String.valueOf((tempFahr - 32) * 5 / 9));
            }
        });

        fahrenheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tempCels = Integer.parseInt(textField.getText());
                textField.setText(String.valueOf(tempCels * 9 / 5 + 32));
            }
        });

        setLayout(new FlowLayout());
        add(textField);
        add(celsiusButton);
        add(fahrenheitButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TempConverter().setVisible(true);
            }
        });
    }
}

