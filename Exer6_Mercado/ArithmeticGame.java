import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.Random;
import javax.swing.border.Border;

public class ArithmeticGame extends JFrame implements ActionListener {

    // --- Theme ---
    private static final Color BG = new Color(245, 248, 252);
    private static final Color CARD = new Color(255, 255, 255);
    private static final Color ACCENT = new Color(53, 132, 228);
    private static final Color GREEN = new Color(34, 197, 94);
    private static final Color RED = new Color(239, 68, 68);

    // --- Game Logic ---
    private final QuestionGenerator generator = new QuestionGenerator();
    private String selectedOperation = "+";
    private GameLevel selectedLevel = GameLevel.LEVEL1;

    // --- Components ---
    private final JTextField answerField = new JTextField(10);
    private final JLabel num1Label = new JLabel("0", SwingConstants.CENTER);
    private final JLabel operatorLabel = new JLabel("+", SwingConstants.CENTER);
    private final JLabel num2Label = new JLabel("0", SwingConstants.CENTER);
    private final JLabel correctScoreLabel = new JLabel("0", SwingConstants.CENTER);
    private final JLabel incorrectScoreLabel = new JLabel("0", SwingConstants.CENTER);
    private final JButton submitButton = new JButton("SUBMIT");
    private final JButton continueButton = new JButton("CONTINUE");
    private final JButton exitButton = new JButton("EXIT");
    private final ButtonGroup operationGroup = new ButtonGroup();
    private final ButtonGroup levelGroup = new ButtonGroup();

    // --- State ---
    private int correctCount = 0;
    private int incorrectCount = 0;

    public ArithmeticGame() {
        installNimbusLaf();
        setTitle("Arithmetic Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(BG);
        setLayout(new BorderLayout());

        add(createTopArea(), BorderLayout.CENTER);
        add(createBottomArea(), BorderLayout.SOUTH);

        configureButtons();
        generateNewQuestion();

        setMinimumSize(new Dimension(900, 560));
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);

        // scale fonts on resize (keep simple)
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                scaleUI();
            }
        });
    }

    // --- Top area: header + equation + right-side buttons ---
    private JPanel createTopArea() {
        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.setBackground(BG);
        topContainer.setBorder(BorderFactory.createEmptyBorder(18, 24, 12, 24));

        JLabel header = new JLabel("Practice Your Arithmetic!", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 32));
        header.setForeground(new Color(30, 41, 59));
        topContainer.add(header, BorderLayout.NORTH);

        // Use BoxLayout for tighter horizontal arrangement
        JPanel center = new JPanel();
        center.setBackground(BG);
        center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(18, 0, 0, 0));

        // Equation panel
        JPanel equationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 8));
        equationPanel.setBackground(BG);

        styleNumberLabel(num1Label);
        styleNumberLabel(num2Label);

        operatorLabel.setFont(new Font("SansSerif", Font.BOLD, 48));
        operatorLabel.setOpaque(false);

        JLabel equals = new JLabel("=", SwingConstants.CENTER);
        equals.setFont(new Font("SansSerif", Font.BOLD, 48));

        styleAnswerField();

        equationPanel.add(num1Label);
        equationPanel.add(operatorLabel);
        equationPanel.add(num2Label);
        equationPanel.add(equals);
        equationPanel.add(answerField);

        // Right column for buttons
        JPanel rightCol = new JPanel();
        rightCol.setBackground(BG);
        rightCol.setLayout(new BoxLayout(rightCol, BoxLayout.Y_AXIS));
        rightCol.setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 0)); // tighter spacing

        submitButton.setMaximumSize(new Dimension(220, 70));
        submitButton.setPreferredSize(new Dimension(220, 70));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel bottomButtonsRow = new JPanel(new GridLayout(1, 2, 10, 0));
        bottomButtonsRow.setBackground(BG);
        bottomButtonsRow.setMaximumSize(new Dimension(220, 60));
        bottomButtonsRow.setPreferredSize(new Dimension(220, 60));
        continueButton.setPreferredSize(new Dimension(100, 60));
        exitButton.setPreferredSize(new Dimension(100, 60));
        bottomButtonsRow.add(continueButton);
        bottomButtonsRow.add(exitButton);

        rightCol.add(Box.createVerticalStrut(8));
        rightCol.add(submitButton);
        rightCol.add(Box.createVerticalStrut(10));
        rightCol.add(bottomButtonsRow);

        // Add both to a tight horizontal layout
        center.add(Box.createHorizontalGlue());
        center.add(equationPanel);
        center.add(Box.createHorizontalStrut(30)); // small gap between equation & buttons
        center.add(rightCol);
        center.add(Box.createHorizontalGlue());

        topContainer.add(center, BorderLayout.CENTER);
        return topContainer;
    }

    // --- Bottom area: left (operations/levels) and right (score) ---
    private JPanel createBottomArea() {
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(BG);
        bottom.setBorder(BorderFactory.createEmptyBorder(12, 24, 18, 24));

        // left: operations and levels side by side
        JPanel left = new JPanel(new GridLayout(1, 2, 28, 0));
        left.setBackground(BG);
        left.add(createOperationPanel());
        left.add(createLevelPanel());
        bottom.add(left, BorderLayout.WEST);

        // right: score, aligned to bottom-right
        JPanel scoreContainer = new JPanel(new BorderLayout());
        scoreContainer.setBackground(BG);
        scoreContainer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel scoreBox = new JPanel(new GridLayout(2, 2, 10, 8));
        scoreBox.setBackground(BG);
        scoreBox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(203, 213, 225)), "SCORE:"),
                BorderFactory.createEmptyBorder(12, 18, 12, 18)));

        JLabel correctTitle = new JLabel("CORRECT", SwingConstants.CENTER);
        JLabel incorrectTitle = new JLabel("INCORRECT", SwingConstants.CENTER);
        styleScoreLabel(correctScoreLabel, new Color(0, 150, 0), new Color(187, 247, 208));
        styleScoreLabel(incorrectScoreLabel, new Color(200, 0, 0), new Color(254, 202, 202));

        scoreBox.add(correctTitle);
        scoreBox.add(incorrectTitle);
        scoreBox.add(correctScoreLabel);
        scoreBox.add(incorrectScoreLabel);

        // Wrap the score box to align bottom-right like the screenshot
        JPanel rightWrap = new JPanel(new BorderLayout());
        rightWrap.setBackground(BG);
        rightWrap.add(scoreBox, BorderLayout.SOUTH);

        bottom.add(rightWrap, BorderLayout.EAST);

        return bottom;
    }

    private JPanel createOperationPanel() {
        JPanel opPanel = new JPanel(new GridLayout(6, 1, 6, 6));
        opPanel.setBackground(CARD);
        opPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(203, 213, 225)),
                "OPERATIONS"));
        String[] ops = { "+", "-", "*", "/", "%" };
        String[] names = { "ADDITION (+)", "SUBTRACTION (-)", "MULTIPLICATION (*)", "DIVISION (/)", "MODULO (%)" };
        for (int i = 0; i < ops.length; i++) {
            JRadioButton rb = new JRadioButton(names[i]);
            rb.setActionCommand(ops[i]);
            rb.setFont(new Font("SansSerif", Font.PLAIN, 16));
            rb.setBackground(CARD);
            rb.addActionListener(this::handleControlSelection);
            operationGroup.add(rb);
            opPanel.add(rb);
            if (ops[i].equals(selectedOperation))
                rb.setSelected(true);
        }
        return opPanel;
    }

    private JPanel createLevelPanel() {
        JPanel lvlPanel = new JPanel(new GridLayout(6, 1, 6, 6));
        lvlPanel.setBackground(CARD);
        lvlPanel.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(203, 213, 225)), "LEVELS"));
        for (GameLevel gl : GameLevel.values()) {
            JRadioButton rb = new JRadioButton("LEVEL " + gl.name().substring(5) + " (" + gl.getDisplay() + ")");
            rb.setActionCommand(gl.name());
            rb.setFont(new Font("SansSerif", Font.PLAIN, 16));
            rb.setBackground(CARD);
            rb.addActionListener(this::handleControlSelection);
            levelGroup.add(rb);
            lvlPanel.add(rb);
            if (gl == selectedLevel)
                rb.setSelected(true);
        }
        return lvlPanel;
    }

    // --- Styling helpers ---
    private void styleNumberLabel(JLabel l) {
        l.setFont(new Font("SansSerif", Font.BOLD, 48));
        l.setOpaque(true);
        l.setBackground(CARD);
        l.setBorder(BorderFactory.createCompoundBorder(createShadowBorder(),
                BorderFactory.createLineBorder(new Color(203, 213, 225), 2)));
        l.setPreferredSize(new Dimension(140, 90));
    }

    private void styleAnswerField() {
        answerField.setFont(new Font("SansSerif", Font.BOLD, 48));
        answerField.setHorizontalAlignment(SwingConstants.CENTER);
        answerField.setBorder(
                BorderFactory.createCompoundBorder(createShadowBorder(), BorderFactory.createLineBorder(ACCENT, 2)));
        answerField.setPreferredSize(new Dimension(220, 90));
        answerField.addActionListener(e -> submitButton.doClick());
    }

    private void styleScoreLabel(JLabel label, Color textColor, Color borderColor) {
        label.setFont(new Font("SansSerif", Font.BOLD, 28));
        label.setForeground(textColor);
        label.setOpaque(true);
        label.setBackground(CARD);
        label.setBorder(BorderFactory.createLineBorder(borderColor));
        label.setPreferredSize(new Dimension(80, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private static Border createShadowBorder() {
        return BorderFactory.createMatteBorder(0, 0, 6, 6, new Color(0, 0, 0, 28));
    }

    private void configureButtons() {
        // SUBMIT (big blue)
        styleActionButton(submitButton, ACCENT);
        submitButton.addActionListener(this);

        // CONTINUE (green) and EXIT (red) side-by-side
        styleActionButton(continueButton, GREEN);
        continueButton.addActionListener(e -> {
            generateNewQuestion();
            continueButton.setEnabled(false);
            submitButton.setEnabled(true);
            answerField.setText("");
            answerField.requestFocusInWindow();
        });
        continueButton.setEnabled(false); // initially disabled per screenshot behavior

        styleActionButton(exitButton, RED);
        exitButton.addActionListener(e -> {
            int opt = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit",
                    JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION)
                System.exit(0);
        });
    }

    private void styleActionButton(JButton b, Color bg) {
        b.setBackground(bg);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFont(new Font("SansSerif", Font.BOLD, 18));
        b.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // --- Logic ---
    private void handleControlSelection(ActionEvent e) {
        String cmd = e.getActionCommand();
        if ("+-*/%".contains(cmd))
            selectedOperation = cmd;
        else
            selectedLevel = GameLevel.valueOf(cmd);
        operatorLabel.setText(selectedOperation);
        generateNewQuestion();
    }

    private void generateNewQuestion() {
        generator.generateQuestion(selectedOperation, selectedLevel);
        num1Label.setText(String.valueOf(generator.getNum1()));
        num2Label.setText(String.valueOf(generator.getNum2()));
        operatorLabel.setText(generator.getOperator());
        answerField.setText("");
        answerField.requestFocusInWindow();
        submitButton.setEnabled(true);
        continueButton.setEnabled(false);
    }

    private void checkAnswer() {
        try {
            int user = Integer.parseInt(answerField.getText().trim());
            boolean correct = (user == generator.getCorrectAnswer());
            JOptionPane.showMessageDialog(this,
                    correct ? "✅ Correct! Well done!"
                            : "❌ Incorrect. The correct answer is " + generator.getCorrectAnswer(),
                    "Result", correct ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
            updateScore(correct);
            // lock submit until user continues (mirrors screenshot flow)
            submitButton.setEnabled(false);
            continueButton.setEnabled(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid whole number.", "Input Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateScore(boolean correct) {
        if (correct)
            correctScoreLabel.setText(String.valueOf(++correctCount));
        else
            incorrectScoreLabel.setText(String.valueOf(++incorrectCount));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton)
            checkAnswer();
    }

    private void scaleUI() {
        // keep scaling modest to preserve relative sizes
        int w = getWidth();
        int base = Math.max(16, Math.min(getHeight(), w) / 20);
        Font numFont = new Font("SansSerif", Font.BOLD, Math.max(36, base + 16));
        num1Label.setFont(numFont);
        num2Label.setFont(numFont);
        operatorLabel.setFont(numFont);
        answerField.setFont(numFont);
        correctScoreLabel.setFont(new Font("SansSerif", Font.BOLD, Math.max(18, base)));
        incorrectScoreLabel.setFont(new Font("SansSerif", Font.BOLD, Math.max(18, base)));
    }

    private static void installNimbusLaf() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName()))
                    UIManager.setLookAndFeel(info.getClassName());
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ArithmeticGame::new);
    }
}

// --- Helper Classes ---
enum GameLevel {
    LEVEL1(1, 100), LEVEL2(101, 500), LEVEL3(501, 1000);

    private final int min, max;

    GameLevel(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public String getDisplay() {
        return min + "-" + max;
    }
}

class QuestionGenerator {
    private final Random random = new Random();
    private int num1, num2, correctAnswer;
    private String operator = "+";

    public void generateQuestion(String op, GameLevel level) {
        operator = op;
        int min = level.getMin(), max = level.getMax();
        switch (op) {
            case "+" -> {
                num1 = r(min, max);
                num2 = r(min, max);
                correctAnswer = num1 + num2;
            }
            case "-" -> {
                num1 = r(min, max);
                num2 = r(min, max);
                if (num2 > num1) {
                    int t = num1;
                    num1 = num2;
                    num2 = t;
                }
                correctAnswer = num1 - num2;
            }
            case "*" -> {
                num1 = r(min, max);
                num2 = r(min, max);
                correctAnswer = num1 * num2;
            }
            case "/" -> {
                num2 = Math.max(1, r(min, max));
                int q = Math.max(1, r(min, max / Math.max(1, num2)));
                num1 = num2 * q;
                correctAnswer = num1 / num2;
            }
            case "%" -> {
                num2 = Math.max(1, r(min, max));
                num1 = r(min, max);
                correctAnswer = num1 % num2;
            }
        }
    }

    private int r(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public String getOperator() {
        return operator;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
