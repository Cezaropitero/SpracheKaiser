package com.piotrek.sprachekaiser;

import com.piotrek.sprachekaiser.panels.*;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);

    MyFrame() {

        // CREATE PANELS

        JPanel mainMenuPanel = new MainMenuPanel(
                () -> cardLayout.show(mainPanel, "QUESTION_FILTER"),
                () -> cardLayout.show(mainPanel, "QUICK_RESPONSE_FILTER"),
                () -> cardLayout.show(mainPanel, "CHALLENGE_FILTER")
        );

        QuestionPanel questionPanel = new QuestionPanel(
                () -> cardLayout.show(mainPanel, "QUESTION_FILTER"),
                () -> cardLayout.show(mainPanel, "MENU")
        );

        JPanel questionFilterPanel = new QuestionFilterPanel(

                filter -> {
                    questionPanel.setFilter(filter);
                    cardLayout.show(mainPanel, "QUESTION");
                },

                () -> cardLayout.show(mainPanel, "MENU")
        );

        QuickResponsePanel quickResponsePanel =
                new QuickResponsePanel(
                        () -> cardLayout.show(mainPanel, "QUICK_RESPONSE_FILTER"),
                        () -> cardLayout.show(mainPanel, "MENU")
                );

        JPanel quickResponseFilterPanel =
                new QuickResponseFilterPanel(

                        filter -> {
                            quickResponsePanel.setFilter(filter);
                            cardLayout.show(mainPanel, "QUICK_RESPONSE");
                        },

                        () -> cardLayout.show(mainPanel, "MENU")
                );

        RealLifeChallengePanel realLifeChallengePanel =
                new RealLifeChallengePanel(
                        () -> cardLayout.show(mainPanel, "CHALLENGE_FILTER"),
                        () -> cardLayout.show(mainPanel, "MENU")
                );

        JPanel realLifeChallengeFilterPanel =
                new RealLifeChallengeFilterPanel(

                        filter -> {
                            realLifeChallengePanel.setFilter(filter);
                            cardLayout.show(mainPanel, "CHALLENGE");
                        },

                        () -> cardLayout.show(mainPanel, "MENU")
                );



        // ADD PANELS

        mainPanel.add(mainMenuPanel, "MENU");
        mainPanel.add(questionFilterPanel, "QUESTION_FILTER");
        mainPanel.add(questionPanel, "QUESTION");
        mainPanel.add(quickResponseFilterPanel, "QUICK_RESPONSE_FILTER");
        mainPanel.add(quickResponsePanel, "QUICK_RESPONSE");
        mainPanel.add(realLifeChallengePanel, "CHALLENGE");
        mainPanel.add(realLifeChallengeFilterPanel, "CHALLENGE_FILTER");


        // CONFIGURE FRAME
        this.add(mainPanel);

        this.setTitle("SpracheKaiser");
        this.setResizable(false);
        this.setSize(500, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/images/crown.jpg")
        );

        this.setIconImage(icon.getImage());

        this.setVisible(true);
    }
}