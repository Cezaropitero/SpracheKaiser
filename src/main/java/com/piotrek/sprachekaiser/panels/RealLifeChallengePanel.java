package com.piotrek.sprachekaiser.panels;

import com.piotrek.sprachekaiser.models.Challenge;
import com.piotrek.sprachekaiser.services.ChallengeService;

import javax.swing.*;
import java.awt.*;

public class RealLifeChallengePanel extends JPanel {

    private JLabel challengeLabel;
    private ChallengeService challengeService = new ChallengeService();
    private JButton helpButton;
    private JButton nextChallengeButton;
    private JButton backToMenuButton;

    private JPanel helpPanel;

    private Challenge currentChallenge;
    private JLabel helpLabel;


    public RealLifeChallengePanel(Runnable backToMenuAction) {

        // CONFIGURE PANEL
        currentChallenge = challengeService.getRandomChallenge();

        setLayout(
                new BoxLayout(this, BoxLayout.Y_AXIS)
        );

        setBackground(
                new Color(250, 248, 240)
        );


        // CREATE COMPONENTS

        challengeLabel = new JLabel(
                "<html><div style='width:350px; text-align:center;'>"
                        + currentChallenge.getChallenge()
                        + "</div></html>"
        );

        challengeLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        challengeLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        helpButton =
                createButton("Get Help");

        nextChallengeButton =
                createButton("Next Challenge");

        backToMenuButton =
                createButton("Back to Menu");

// SAME BUTTON SIZE
        setButtonSizes();

        helpPanel = createHelpPanel();


        // CONFIGURE ACTIONS

        configureActions(backToMenuAction);

        // ADD COMPONENTS

        add(Box.createVerticalStrut(70));

        add(challengeLabel);

        add(Box.createVerticalStrut(20));

        add(helpButton);

        add(Box.createVerticalStrut(10));

        add(helpPanel);

    //    add(Box.createVerticalStrut(10));

        add(nextChallengeButton);

        add(Box.createVerticalStrut(10));

        add(backToMenuButton);
    }

    private JPanel createHelpPanel() {

        JPanel panel = new JPanel();

        panel.setLayout(
                new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        panel.setBackground(
                new Color(250, 248, 240)
        );

        // CENTER THE WHOLE HELP BLOCK
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension helpSize = new Dimension(300, 100);
        panel.setPreferredSize(helpSize);
        panel.setMaximumSize(helpSize);


        // TITLE

        JLabel helpTitle = new JLabel("Useful phrases:");

        helpTitle.setFont(
                new Font("Arial", Font.BOLD, 12)
        );


        // HELP

        helpLabel = new JLabel(
                formatHelp(currentChallenge.getHelp())
        );


        // TEXT INSIDE THE BLOCK → LEFT

        helpTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        helpLabel.setAlignmentX(Component.LEFT_ALIGNMENT);


        // ADD COMPONENTS

        panel.add(helpTitle);
        panel.add(Box.createVerticalStrut(3));
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


    private JButton createButton(String text) {

        JButton button = new JButton(text);

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        button.setFocusPainted(false);

        return button;
    }


    private void configureActions(
            Runnable backToMenuAction
    ) {

        backToMenuButton.addActionListener(e ->
                backToMenuAction.run()
        );
        helpButton.addActionListener(e -> {

            boolean isVisible = helpPanel.isVisible();

            helpPanel.setVisible(!isVisible);

            if (isVisible) {
                helpButton.setText("Get Help");
            } else {
                helpButton.setText("Hide Help");
            }
        });
        nextChallengeButton.addActionListener(e -> {
            showRandomChallenge();
        });

    }

    private void showRandomChallenge() {

        currentChallenge = challengeService.getRandomChallenge();

        challengeLabel.setText(
                "<html><div style='width:350px; text-align:center;'>"
                        + currentChallenge.getChallenge()
                        + "</div></html>"
        );

        helpLabel.setText(
                formatHelp(currentChallenge.getHelp())
        );

        // Schowaj help przy nowym challenge
        helpPanel.setVisible(false);
        helpButton.setText("Get Help");
    }
    private void setButtonSizes() {

        Dimension buttonSize =
                nextChallengeButton.getPreferredSize();

        helpButton.setMaximumSize(buttonSize);
        nextChallengeButton.setMaximumSize(buttonSize);
        backToMenuButton.setMaximumSize(buttonSize);
    }
}
