package com.piotrek.sprachekaiser.panels;

import com.piotrek.sprachekaiser.models.Challenge;
import com.piotrek.sprachekaiser.models.ChallengeFilter;
import com.piotrek.sprachekaiser.services.ChallengeService;

import javax.swing.*;
import java.awt.*;

public class RealLifeChallengePanel extends JPanel {

    private JButton backToFilterButton;
    private JLabel challengeLabel;
    private ChallengeService challengeService = new ChallengeService();
    private JButton helpButton;
    private JButton nextChallengeButton;
    private JButton backToMenuButton;

    private JPanel helpPanel;

    private Challenge currentChallenge;
    private JLabel helpLabel;

    private ChallengeFilter currentFilter;


    public RealLifeChallengePanel(Runnable backToFilterAction,
                                  Runnable backToMenuAction)
    {
        setLayout(
                new BoxLayout(this, BoxLayout.Y_AXIS)
        );

        setBackground(
                new Color(240, 234, 218)
        );


        // CREATE COMPONENTS
        challengeLabel = new JLabel("");

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

        backToFilterButton =
                createButton("Back to Filters");

        backToMenuButton =
                createButton("Back to Menu");

// SAME BUTTON SIZE
        setButtonSizes();

        helpPanel = createHelpPanel();


        // CONFIGURE ACTIONS

        configureActions(
                backToFilterAction,
                backToMenuAction
        );

        // ADD COMPONENTS

        add(Box.createVerticalStrut(70));

        add(challengeLabel);

        add(Box.createVerticalStrut(20));

        add(helpButton);

        add(Box.createVerticalStrut(10));

        add(helpPanel);

        add(Box.createVerticalStrut(10));

        add(nextChallengeButton);

        add(Box.createVerticalStrut(10));

        add(backToFilterButton);

        add(Box.createVerticalStrut(10));

        add(backToMenuButton);
    }


    public void setFilter(ChallengeFilter filter) {
        this.currentFilter = filter;
        showRandomChallenge();
    }



    private JPanel createHelpPanel() {

        JPanel panel = new JPanel();

        panel.setLayout(
                new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        panel.setBackground(
                new Color(255, 253, 247)
        );

        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension helpSize = new Dimension(300, 100);

        panel.setPreferredSize(helpSize);
        panel.setMinimumSize(helpSize);
        panel.setMaximumSize(helpSize);

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

        JLabel helpTitle = new JLabel("Useful phrases:");

        helpTitle.setFont(
                new Font("Arial", Font.BOLD, 12)
        );
        helpLabel = new JLabel("");

        helpTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        helpLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

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


    private void configureActions(
            Runnable backToFilterAction,
            Runnable backToMenuAction
    ) {

        backToFilterButton.addActionListener(e ->
                backToFilterAction.run()
        );

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

        nextChallengeButton.addActionListener(e ->
                showRandomChallenge()
        );
    }

    private void showRandomChallenge() {

        currentChallenge =
                challengeService.getRandomChallenge(currentFilter);

        challengeLabel.setText(
                "<html><div style='width:350px; text-align:center;'>"
                        + currentChallenge.getChallenge()
                        + "</div></html>"
        );

        helpLabel.setText(
                formatHelp(currentChallenge.getHelp())
        );

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
