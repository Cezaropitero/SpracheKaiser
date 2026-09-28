package com.piotrek.sprachekaiser.panels;

import com.piotrek.sprachekaiser.models.QuickResponse;
import com.piotrek.sprachekaiser.services.QuickResponseService;

import javax.swing.*;
import java.awt.*;

public class QuickResponsePanel extends JPanel {

    private final QuickResponseService quickResponseService =
            new QuickResponseService();

    private QuickResponse currentResponse;

    private JLabel situationLabel;
    private JLabel difficultyLabel;
    private JLabel helpLabel;
    private JLabel exampleLabel;

    private JButton helpButton;
    private JButton exampleButton;
    private JButton nextResponseButton;
    private JButton backToMenuButton;

    private JPanel helpPanel;
    private JPanel examplePanel;

    public QuickResponsePanel(Runnable backToMenuAction) {

        // CONFIGURE PANEL

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(240, 234, 218));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        currentResponse = quickResponseService.getRandomResponse();

        // CREATE COMPONENTS

        difficultyLabel = createLabel(
                "Level: " + currentResponse.getDifficulty()
        );

        situationLabel = createLabel(
                formatText(currentResponse.getSituation())
        );
        situationLabel.setFont(new Font("Arial", Font.BOLD, 18));

        helpButton = createButton("Get Help");
        exampleButton = createButton("Show Example");
        nextResponseButton = createButton("Next Response");
        backToMenuButton = createButton("Back to Menu");

        helpLabel = createLabel(
                formatText(currentResponse.getHelp())
        );
        helpPanel = createHiddenPanel(helpLabel);

        exampleLabel = createLabel(
                formatText(currentResponse.getExampleAnswer())
        );
        examplePanel = createHiddenPanel(exampleLabel);

        // CONFIGURE ACTIONS

        configureActions(backToMenuAction);

        // ADD COMPONENTS

        add(difficultyLabel);
        add(Box.createVerticalStrut(15));
        add(situationLabel);

        add(Box.createVerticalStrut(20));
        add(helpButton);
        add(Box.createVerticalStrut(10));
        add(helpPanel);

        add(Box.createVerticalStrut(10));

        add(exampleButton);
        add(Box.createVerticalStrut(10));
        add(examplePanel);

        add(Box.createVerticalStrut(10));

        add(nextResponseButton);

        add(Box.createVerticalStrut(10));

        add(backToMenuButton);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
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

    private JPanel createHiddenPanel(JLabel label) {
        JPanel panel = new JPanel();

        panel.setLayout(
                new BoxLayout(panel, BoxLayout.Y_AXIS)
        );

        panel.setBackground(
                new Color(255, 253, 247)
        );

        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension size = new Dimension(300, 90);
        panel.setPreferredSize(size);
        panel.setMinimumSize(size);
        panel.setMaximumSize(size);

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

        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(label);

        panel.setVisible(false);

        return panel;
    }

    private String formatText(String text) {
        return "<html><div style='width: 290px; text-align: center;'>"
                + text.replace(" | ", "<br>")
                + "</div></html>";
    }

    private void configureActions(Runnable backToMenuAction) {

        helpButton.addActionListener(e -> {
            boolean showHelp = !helpPanel.isVisible();

            helpPanel.setVisible(showHelp);
            helpButton.setText(showHelp ? "Hide Help" : "Get Help");

            revalidate();
            repaint();
        });

        exampleButton.addActionListener(e -> {
            boolean showExample = !examplePanel.isVisible();

            examplePanel.setVisible(showExample);
            exampleButton.setText(
                    showExample ? "Hide Example" : "Show Example"
            );

            revalidate();
            repaint();
        });

        nextResponseButton.addActionListener(e -> showNextResponse());

        backToMenuButton.addActionListener(e -> backToMenuAction.run());
    }

    private void showNextResponse() {
        currentResponse = quickResponseService.getRandomResponse();

        situationLabel.setText(
                formatText(currentResponse.getSituation())
        );
        difficultyLabel.setText(
                "Level: " + currentResponse.getDifficulty()
        );
        helpLabel.setText(
                formatText(currentResponse.getHelp())
        );
        exampleLabel.setText(
                formatText(currentResponse.getExampleAnswer())
        );

        // Po zmianie sytuacji chowamy pomoc i przykład.
        helpPanel.setVisible(false);
        examplePanel.setVisible(false);

        helpButton.setText("Get Help");
        exampleButton.setText("Show Example");

        revalidate();
        repaint();
    }
}
