package com.piotrek.sprachekaiser.panels;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class RealLifeChallengeFilterPanel extends JPanel {

    private JComboBox<String> themeComboBox;
    private JComboBox<String> practicalityComboBox;
    private JComboBox<String> difficultyComboBox;
    private JComboBox<String> engagementComboBox;

    public RealLifeChallengeFilterPanel(
            Consumer<String> startChallengeAction,
            Runnable backToMenuAction
    ) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(240, 234, 218));

        JLabel titleLabel = new JLabel("Choose challenge filters");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] themes = {
                "All themes",
                "HOME",
                "CITY",
                "COMPUTER",
                "TRAVEL"
        };

        String[] practicality = {
                "All",
                "LOW",
                "MEDIUM",
                "HIGH"
        };

        String[] difficulties = {
                "All",
                "EASY",
                "MEDIUM",
                "HARD"
        };

        String[] engagement = {
                "All",
                "LOW",
                "MEDIUM",
                "HIGH"
        };

        themeComboBox = new JComboBox<>(themes);
        practicalityComboBox = new JComboBox<>(practicality);
        difficultyComboBox = new JComboBox<>(difficulties);
        engagementComboBox = new JComboBox<>(engagement);

        JComboBox<String> practicalityComboBox =
                new JComboBox<>(practicality);

        JComboBox<String> difficultyComboBox =
                new JComboBox<>(difficulties);

        JComboBox<String> engagementComboBox =
                new JComboBox<>(engagement);
        themeComboBox.setMaximumSize(
                new Dimension(280, 40)
        );
        themeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startButton = createButton("Start Challenge");
        JButton backButton = createButton("Back to Menu");

        startButton.addActionListener(e -> {

            String selectedTheme =
                    (String) themeComboBox.getSelectedItem();

            startChallengeAction.accept(selectedTheme);
        });

        backButton.addActionListener(e ->
                backToMenuAction.run()
        );

        add(Box.createVerticalStrut(40));
        add(titleLabel);

        add(Box.createVerticalStrut(25));

        add(createFilterRow(
                "Theme:",
                themeComboBox
        ));

        add(Box.createVerticalStrut(5));

        add(createFilterRow(
                "Practicality:",
                practicalityComboBox
        ));

        add(Box.createVerticalStrut(5));

        add(createFilterRow(
                "Difficulty:",
                difficultyComboBox
        ));

        add(Box.createVerticalStrut(5));

        add(createFilterRow(
                "Engagement:",
                engagementComboBox
        ));

        add(Box.createVerticalStrut(20));

        add(startButton);

        add(Box.createVerticalStrut(10));

        add(backButton);
    }
    private JPanel createFilterRow(
            String labelText,
            JComboBox<String> comboBox
    ) {

        JPanel row = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 10, 0)
        );

        row.setOpaque(false);

        Dimension rowSize = new Dimension(320, 32);

        row.setPreferredSize(rowSize);
        row.setMinimumSize(rowSize);
        row.setMaximumSize(rowSize);

        JLabel label = new JLabel(labelText);

        label.setPreferredSize(
                new Dimension(100, 32)
        );

        comboBox.setPreferredSize(
                new Dimension(180, 32)
        );

        row.add(label);
        row.add(comboBox);

        return row;
    }
    private JButton createButton(String text) {

        JButton button = new JButton(text);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFocusPainted(false);

        Dimension size = new Dimension(280, 52);

        button.setPreferredSize(size);
        button.setMinimumSize(size);
        button.setMaximumSize(size);

        button.setBackground(new Color(255, 253, 247));
        button.setForeground(new Color(37, 37, 37));

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(185, 135, 45)
                )
        );

        button.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        return button;
    }
}