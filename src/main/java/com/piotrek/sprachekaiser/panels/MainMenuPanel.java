package com.piotrek.sprachekaiser.panels;
import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    public MainMenuPanel(
            Runnable questionAction,
            Runnable quickResponseAction,
            Runnable challengeAction
    ) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(240, 234, 218));

        JLabel titleLabel = new JLabel("SpracheKaiser");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descriptionLabel =
                new JLabel("Learn and practice German. Choose an option:");

        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton randomQuestionButton =
                createButton("Random Question");

        JButton quickResponseButton =
                createButton("Quick Response");

        JButton realLifeChallengeButton =
                createButton("Real-Life Challenge");

        JButton exitButton =
                createButton("Exit");

        // ACTIONS
        randomQuestionButton.addActionListener(e ->
                questionAction.run()
        );

        quickResponseButton.addActionListener(e ->
                quickResponseAction.run()
        );

        realLifeChallengeButton.addActionListener(e ->
                challengeAction.run()
        );

        exitButton.addActionListener(e ->
                System.exit(0)
        );

        // COMPONENTS
        add(Box.createVerticalStrut(30));
        add(titleLabel);

        add(Box.createVerticalStrut(10));
        add(descriptionLabel);

        add(Box.createVerticalStrut(25));
        add(randomQuestionButton);

        add(Box.createVerticalStrut(10));
        add(quickResponseButton);

        add(Box.createVerticalStrut(10));
        add(realLifeChallengeButton);

        add(Box.createVerticalStrut(10));
        add(exitButton);
    }

    private JButton createButton(String text) {

        JButton button = new JButton(text);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFocusPainted(false);

        Dimension size = new Dimension(280, 52);
        button.setPreferredSize(size);
        button.setMinimumSize(size);
        button.setMaximumSize(size);

        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(new Color(255, 253, 247));

        button.setBorder(BorderFactory.createLineBorder(
                new Color(210, 201, 180)
        ));
        button.setForeground(new Color(37, 37, 37));

        button.setBorder(BorderFactory.createLineBorder(
                new Color(185, 135, 45)
        ));

        button.setFont(new Font("Arial", Font.BOLD, 15));

        return button;
    }
}
