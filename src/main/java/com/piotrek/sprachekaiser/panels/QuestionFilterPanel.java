package com.piotrek.sprachekaiser.panels;

import com.piotrek.sprachekaiser.models.QuestionFilter;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class QuestionFilterPanel extends JPanel {

    private JComboBox<String> levelComboBox;
    private JComboBox<String> themeComboBox;

    public QuestionFilterPanel(
            Consumer<QuestionFilter> startQuestionAction,
            Runnable backToMenuAction
    ) {

        // CONFIGURE PANEL

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(240, 234, 218));


        // TITLE

        JLabel titleLabel =
                new JLabel("Choose question filters");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        // FILTER OPTIONS

        String[] levels = {
                "All",
                "A1",
                "A2",
                "B1"
        };

        String[] themes = {
                "All themes",
                "PERSONAL",
                "DAILY_LIFE",
                "HOBBIES",
                "FOOD",
                "HOME",
                "TRAVEL",
                "WORK",
                "TECHNOLOGY",
                "EMOTIONS",
                "FUTURE"
        };


        // COMBO BOXES

        levelComboBox = new JComboBox<>(levels);
        themeComboBox = new JComboBox<>(themes);


        // BUTTONS

        JButton startButton =
                createButton("Start Questions");

        JButton backButton =
                createButton("Back to Menu");


        // ACTIONS

        startButton.addActionListener(e -> {

            String selectedLevel =
                    (String) levelComboBox.getSelectedItem();

            String selectedTheme =
                    (String) themeComboBox.getSelectedItem();

            QuestionFilter filter =
                    new QuestionFilter(
                            selectedLevel,
                            selectedTheme
                    );

            startQuestionAction.accept(filter);
        });

        backButton.addActionListener(e ->
                backToMenuAction.run()
        );


        // ADD COMPONENTS

        add(Box.createVerticalStrut(60));

        add(titleLabel);

        add(Box.createVerticalStrut(30));

        add(createFilterRow(
                "Level:",
                levelComboBox
        ));

        add(Box.createVerticalStrut(8));

        add(createFilterRow(
                "Theme:",
                themeComboBox
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
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        0
                )
        );

        row.setOpaque(false);

        Dimension rowSize =
                new Dimension(320, 32);

        row.setPreferredSize(rowSize);
        row.setMinimumSize(rowSize);
        row.setMaximumSize(rowSize);

        JLabel label =
                new JLabel(labelText);

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

        JButton button =
                new JButton(text);

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        button.setFocusPainted(false);

        Dimension size =
                new Dimension(280, 52);

        button.setPreferredSize(size);
        button.setMinimumSize(size);
        button.setMaximumSize(size);

        button.setBackground(
                new Color(255, 253, 247)
        );

        button.setForeground(
                new Color(37, 37, 37)
        );

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(185, 135, 45)
                )
        );

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        return button;
    }
}