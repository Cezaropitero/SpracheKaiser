package com.piotrek.sprachekaiser.panels;

import com.piotrek.sprachekaiser.models.Question;
import com.piotrek.sprachekaiser.services.QuestionService;
import com.piotrek.sprachekaiser.models.QuestionFilter;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {

    private QuestionService questionService = new QuestionService();
    private Question currentQuestion;
    private QuestionFilter currentFilter;
    private JLabel questionLabel;
    private JLabel translationLabel;
    private JLabel helpLabel;
    private JButton backToFilterButton;


    private JButton helpButton;
    private JButton nextQuestionButton;
    private JButton backToMenuButton;

    private JPanel helpPanel;


    public QuestionPanel(
            Runnable backToFilterAction,
            Runnable backToMenuAction
    ) {

        // CONFIGURE QUESTION PANEL

        setLayout(
                new BoxLayout(this, BoxLayout.Y_AXIS)
        );

        setBackground(
                new Color(240, 234, 218)
        );

        currentQuestion = questionService.getRandomQuestion();
        // CREATE COMPONENTS

        questionLabel = createQuestionLabel();

        helpButton = createButton("Get Help");
        helpPanel = createHelpPanel();

        nextQuestionButton = createButton("Next Question");
        backToFilterButton = createButton("Back to Filters");
        backToMenuButton = createButton("Back to Menu");


        // CONFIGURE COMPONENTS

        configureQuestionActions(
                backToFilterAction,
                backToMenuAction
        );

      //  setQuestionButtonSizes();


        // ADD COMPONENTS

        addComponents();
    }

    public void setFilter(QuestionFilter filter) {
        this.currentFilter = filter;
        showRandomQuestion();
    }

    private JLabel createQuestionLabel() {


        JLabel questionLabel = new JLabel(
                currentQuestion.getQuestion()
        );

        questionLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        questionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        return questionLabel;
    }


    private JPanel createHelpPanel() {

        JPanel panel = createPanel();

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(210, 201, 180)
                        ),
                        BorderFactory.createEmptyBorder(
                                10, 12, 10, 12
                        )
                )
        );

        // cały blok Help na środku
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // stała szerokość bloku
        Dimension helpSize = new Dimension(300, 140);
        panel.setPreferredSize(helpSize);
        panel.setMaximumSize(helpSize);


        // ENGLISH TITLE

        JLabel translationTitle = new JLabel("English:");
        translationTitle.setFont(
                new Font("Arial", Font.BOLD, 12)
        );


        // ENGLISH TRANSLATION

        translationLabel = new JLabel(
                currentQuestion.getEnglishMeaning()
        );


        // HELP TITLE

        JLabel helpTitle = new JLabel("Useful phrases:");
        helpTitle.setFont(
                new Font("Arial", Font.BOLD, 12)
        );


        // GERMAN HELP

        helpLabel = new JLabel(
                formatHelp(currentQuestion.getHelp())
        );


        // TEKST DO LEWEJ

        translationTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        translationLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        helpTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        helpLabel.setAlignmentX(Component.LEFT_ALIGNMENT);


        // ADD COMPONENTS

        panel.add(translationTitle);
        panel.add(translationLabel);

        panel.add(Box.createVerticalStrut(10));

        panel.add(helpTitle);
        panel.add(helpLabel);

        panel.setVisible(false);

        return panel;
    }
    private String formatHelp(String help) {

        return "<html>"
                + "• "
                + help.replace(" | ", "<br>• ")
                + "</html>";
    }


    private JPanel createPanel() {

        JPanel panel = new JPanel();

        panel.setLayout(
                new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        panel.setBackground(
                new Color(255, 253, 247)
        );

        return panel;
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
                new Font("Arial", Font.BOLD, 15)
        );

        return button;
    }
    private void showRandomQuestion() {

        currentQuestion =
                questionService.getRandomQuestion(currentFilter);

        questionLabel.setText(
                currentQuestion.getQuestion()
        );

        translationLabel.setText(
                currentQuestion.getEnglishMeaning()
        );

        helpLabel.setText(
                formatHelp(currentQuestion.getHelp())
        );

        helpPanel.setVisible(false);
        helpButton.setText("Get Help");
    }


    private void configureQuestionActions(
            Runnable backToFilterAction,
            Runnable backToMenuAction
    ) {

        helpButton.addActionListener(e -> {

            boolean isVisible =
                    helpPanel.isVisible();

            helpPanel.setVisible(!isVisible);

            if (isVisible) {
                helpButton.setText("Get Help");
            } else {
                helpButton.setText("Hide Help");
            }
        });


        nextQuestionButton.addActionListener(e ->
                showRandomQuestion()
        );

        backToMenuButton.addActionListener(e ->
                backToMenuAction.run()
        );

        backToFilterButton.addActionListener(e ->
                backToFilterAction.run()
        );

        // Back to Menu zrobimy za chwilę.
        // QuestionPanel nie powinien sam zarządzać CardLayout z MyFrame.
    }

    private void addComponents() {

        add(Box.createVerticalStrut(70));
        add(questionLabel);

        add(Box.createVerticalStrut(30));
        add(helpButton);

        add(Box.createVerticalStrut(10));
        add(helpPanel);

        add(Box.createVerticalStrut(10));
        add(nextQuestionButton);

        add(Box.createVerticalStrut(10));
        add(backToFilterButton);

        add(Box.createVerticalStrut(10));
        add(backToMenuButton);
    }
}
