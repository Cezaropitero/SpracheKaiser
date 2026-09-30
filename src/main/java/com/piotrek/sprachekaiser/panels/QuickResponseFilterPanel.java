package com.piotrek.sprachekaiser.panels;

import com.piotrek.sprachekaiser.models.QuickResponseFilter;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class QuickResponseFilterPanel extends JPanel {

    private JComboBox<String> themeComboBox;
    private JComboBox<String> difficultyComboBox;

    public QuickResponseFilterPanel(
            Consumer<QuickResponseFilter> startResponseAction,
            Runnable backToMenuAction
    ) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(240, 234, 218));

        JLabel titleLabel =
                new JLabel("Choose response filters");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        String[] themes = {
                "All themes",
                "SHOPPING",
                "FOOD",
                "TRAVEL",
                "SOCIAL",
                "DAILY_LIFE",
                "WORK"
        };

        String[] difficulties = {
                "All",
                "EASY",
                "MEDIUM",
                "HARD"
        };


        themeComboBox = new JComboBox<>(themes);
        difficultyComboBox = new JComboBox<>(difficulties);


        JButton startButton =
                createButton("Start Responses");

        JButton backButton =
                createButton("Back to Menu");


        startButton.addActionListener(e -> {

            String selectedTheme =
                    (String) themeComboBox.getSelectedItem();

            String selectedDifficulty =
                    (String) difficultyComboBox.getSelectedItem();

            QuickResponseFilter filter =
                    new QuickResponseFilter(
                            selectedTheme,
                            selectedDifficulty
                    );

            startResponseAction.accept(filter);
        });


        backButton.addActionListener(e ->
                backToMenuAction.run()
        );


        add(Box.createVerticalStrut(60));
        add(titleLabel);

        add(Box.createVerticalStrut(30));

        add(createFilterRow(
                "Theme:",
                themeComboBox
        ));

        add(Box.createVerticalStrut(8));

        add(createFilterRow(
                "Difficulty:",
                difficultyComboBox
        ));

        add(Box.createVerticalStrut(30));

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
