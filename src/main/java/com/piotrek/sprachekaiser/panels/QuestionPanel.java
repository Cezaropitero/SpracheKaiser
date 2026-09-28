package org.example.panels;

import org.example.models.Question;
import org.example.services.QuestionService;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {

    private QuestionService questionService = new QuestionService();
    private Question currentQuestion;
    private JLabel questionLabel;
    private JLabel translationLabel;
    private JLabel helpLabel;

    private JButton helpButton;
    private JButton nextQuestionButton;
    private JButton backToMenuButton;

    private JPanel helpPanel;


    public QuestionPanel(Runnable backToMenuAction) {

        // CONFIGURE QUESTION PANEL

        setLayout(
                new BoxLayout(this, BoxLayout.Y_AXIS)
        );

        setBackground(
                new Color(250, 248, 240)
        );

        currentQuestion = questionService.getRandomQuestion();
        // CREATE COMPONENTS

        questionLabel = createQuestionLabel();

        helpButton = createButton("Get Help");
        helpPanel = createHelpPanel();

        nextQuestionButton = createButton("Next Question");
        backToMenuButton = createButton("Back to Menu");


        // CONFIGURE COMPONENTS

        configureQuestionActions(backToMenuAction);

        setQuestionButtonSizes();


        // ADD COMPONENTS

        addComponents();
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

        // cały blok Help na środku
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // stała szerokość bloku
        Dimension helpSize = new Dimension(300, 120);
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
                new Color(250, 248, 240)
        );

        return panel;
    }


    private JButton createButton(String text) {

        JButton button = new JButton(text);

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        button.setFocusPainted(false);

        return button;
    }


    private void configureQuestionActions(Runnable backToMenuAction) {

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


        nextQuestionButton.addActionListener(e -> {
            currentQuestion = questionService.getRandomQuestion();

            questionLabel.setText(
                    currentQuestion.getQuestion()
            );
            translationLabel.setText(
                    currentQuestion.getEnglishMeaning()
            );

            helpLabel.setText(
                    formatHelp(currentQuestion.getHelp())
            );

            // Schowaj help
            helpPanel.setVisible(false);

            // Przywróć napis na przycisku
            helpButton.setText("Get Help");
        });

        backToMenuButton.addActionListener(e ->
                backToMenuAction.run()
        );

        // Back to Menu zrobimy za chwilę.
        // QuestionPanel nie powinien sam zarządzać CardLayout z MyFrame.
    }


    private void setQuestionButtonSizes() {

        Dimension buttonSize =
                nextQuestionButton.getPreferredSize();

        helpButton.setMaximumSize(buttonSize);
        nextQuestionButton.setMaximumSize(buttonSize);
        backToMenuButton.setMaximumSize(buttonSize);
    }


    private void addComponents() {

        add(Box.createVerticalStrut(70));
        add(questionLabel);

        add(Box.createVerticalStrut(30));
        add(helpButton);

        add(Box.createVerticalStrut(10));
        add(helpPanel);

    //    add(Box.createVerticalStrut(20));
        add(nextQuestionButton);

        add(Box.createVerticalStrut(10));
        add(backToMenuButton);
    }
}
