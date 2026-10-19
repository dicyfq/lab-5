package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");
        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");
        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);
    }

    private GameShape generateShape() {
        int random = new Random().nextInt(3);

        switch (random) {
            case 0:
                return new Rock();
            case 1:
                return new Scissors();
            default:
                return new Paper();
        }
    }

    private int checkWinner(GameShape player, GameShape computer) {
        // Нічия, якщо фігури одного типу
        if ((player instanceof Rock && computer instanceof Rock) ||
                (player instanceof Scissors && computer instanceof Scissors) ||
                (player instanceof Paper && computer instanceof Paper)) {
            return 0;
        }

        // Випадки, коли перемагає гравець:
        // Камінь б'є Ножиці, Ножиці б'ють Папір, Папір б'є Камінь
        if ((player instanceof Rock && computer instanceof Scissors) ||
                (player instanceof Scissors && computer instanceof Paper) ||
                (player instanceof Paper && computer instanceof Rock)) {
            return 1;
        }

        // В усіх інших випадках перемагає комп'ютер
        return -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameShape computerShape = generateShape();
        GameShape playerShape = null;

        switch (e.getActionCommand()) {
            case "rock":
                playerShape = new Rock();
                break;
            case "paper":
                playerShape = new Paper();
                break;
            case "scissors":
                playerShape = new Scissors();
                break;
        }

        int gameResult = checkWinner(playerShape, computerShape);

        String message = "Вибір гравця: " + playerShape + ". Вибір комп'ютера: " + computerShape + ".\n\n";
        switch (gameResult) {
            case -1:
                    message += "КОМП'ЮТЕР ПЕРЕМІГ!";
                break;
            case 0:
                message += "НІЧИЯ!";
                break;
            case 1:
                message += "ГРАВЕЦЬ ПЕРЕМІГ!";
                break;
        }

        JOptionPane.showMessageDialog(null, message);
    }
}