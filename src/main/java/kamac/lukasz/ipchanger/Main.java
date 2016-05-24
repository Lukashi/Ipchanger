package kamac.lukasz.ipchanger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * Created by kamacl on 23.05.2016.
 */

public class Main {

    private JButton setIPButton;
    private JButton resetToDefaultButton;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField cfg1Ip;
    private JTextField cfg1Mask;
    private JTextField cfg1Gateway;
    private JTextField cfg2Ip;
    private JTextField cfg2Mask;
    private JTextField cfg2Gateway;
    private JTextField cfg3Ip;
    private JTextField cfg3Mask;
    private JTextField cfg3Gateway;
    private JTextField cfg4Ip;
    private JTextField cfg4Mask;
    private JTextField cfg4Gateway;
    private JTextField cfg5Ip;
    private JTextField cfg5Mask;
    private JTextField cfg5Gateway;
    private JTextField cfg6Ip;
    private JTextField cfg6Mask;
    private JTextField cfg6Gateway;
    private JTextField cfg7Ip;
    private JTextField cfg7Mask;
    private JTextField cfg7Gateway;
    private JTextField cfg8Ip;
    private JTextField cfg8Mask;
    private JTextField cfg8Gateway;
    private JTextField cfg9Ip;
    private JTextField cfg9Mask;
    private JTextField cfg9Gateway;
    private JTextField cfg10Gateway;
    private JTextField cfg10Ip;
    private JTextField cfg10Mask;
    private JButton setIPButton2;
    private JButton setIPButton3;
    private JButton setIPButton4;
    private JButton setIPButton5;
    private JButton setIPButton6;
    private JButton setIPButton7;
    private JButton setIPButton8;
    private JButton setIPButton9;
    private JButton setIPButton10;
    private JTabbedPane tabbedPane2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().panel1);
        frame.setPreferredSize(new Dimension(600,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Main() {
        setIPButton.addActionListener(e -> {
            Config config = new Config();
            getData1(config);
            executeSetIpCommand(config);
        });
        setIPButton2.addActionListener(e -> {
            Config config = new Config();
            getData2(config);
            executeSetIpCommand(config);
        });
        setIPButton3.addActionListener(e -> {
            Config config = new Config();
            getData3(config);
            executeSetIpCommand(config);
        });
        setIPButton4.addActionListener(e -> {
            Config config = new Config();
            getData4(config);
            executeSetIpCommand(config);
        });
        setIPButton5.addActionListener(e -> {
            Config config = new Config();
            getData5(config);
            executeSetIpCommand(config);
        });
        setIPButton6.addActionListener(e -> {
            Config config = new Config();
            getData6(config);
            executeSetIpCommand(config);
        });
        setIPButton7.addActionListener(e -> {
            Config config = new Config();
            getData7(config);
            executeSetIpCommand(config);
        });
        ;
        setIPButton8.addActionListener(e -> {
            Config config = new Config();
            getData8(config);
            executeSetIpCommand(config);
        });
        ;
        setIPButton9.addActionListener(e -> {
            Config config = new Config();
            getData9(config);
            executeSetIpCommand(config);
        });
        ;
        setIPButton10.addActionListener(e -> {
            Config config = new Config();
            getData10(config);
            executeSetIpCommand(config);
        });
        resetToDefaultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeResetCommand();
            }
        });
    }

    private void executeSetIpCommand(Config config) {
        // System.getProperty("os.name")
        //String addressName = "Local Area Connection";
        String addressName = "Ethernet";
        executeCommand("netsh interface ip set address name=\"" + addressName + "\" static " + config.getIp() + " " + config.getMask() + " " + config.getGateway());
    }

    private void executeResetCommand() {
        String addressName = "Ethernet";
        executeCommand("netsh interface ip set address name=\"" + addressName + "\" source=dhcp");
    }

    private void executeCommand(String command) {
        System.out.println("About to execute [" + command + "]");
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("CMD", "/C", command);
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process process = processBuilder.start();
            process.waitFor(5, TimeUnit.SECONDS);
            int exitValue = process.exitValue();
            if (exitValue != 0) {
                showFailureAlert();
            } else {
                showSuccessAlert();
            }
        } catch (Exception e) {
            showFailureAlert();
        }
    }

    private void showFailureAlert() {
        JOptionPane.showMessageDialog(null, "Exception occurred while trying to set the ip.");
    }


    private void showSuccessAlert() {
        JOptionPane.showMessageDialog(null, "IP successfuly changed");
    }

    public void getData1(Config data) {
        data.setIp(cfg1Ip.getText());
        data.setMask(cfg1Mask.getText());
        data.setGateway(cfg1Gateway.getText());
    }

    public void getData2(Config data) {
        data.setIp(cfg2Ip.getText());
        data.setMask(cfg2Mask.getText());
        data.setGateway(cfg2Gateway.getText());
    }

    public void getData3(Config data) {
        data.setIp(cfg3Ip.getText());
        data.setMask(cfg3Mask.getText());
        data.setGateway(cfg3Gateway.getText());
    }

    public void getData4(Config data) {
        data.setIp(cfg4Ip.getText());
        data.setMask(cfg4Mask.getText());
        data.setGateway(cfg4Gateway.getText());
    }

    public void getData5(Config data) {
        data.setIp(cfg5Ip.getText());
        data.setMask(cfg5Mask.getText());
        data.setGateway(cfg5Gateway.getText());
    }

    public void getData6(Config data) {
        data.setIp(cfg6Ip.getText());
        data.setMask(cfg6Mask.getText());
        data.setGateway(cfg6Gateway.getText());
    }

    public void getData7(Config data) {
        data.setIp(cfg7Ip.getText());
        data.setMask(cfg7Mask.getText());
        data.setGateway(cfg7Gateway.getText());
    }

    public void getData8(Config data) {
        data.setIp(cfg8Ip.getText());
        data.setMask(cfg8Mask.getText());
        data.setGateway(cfg8Gateway.getText());
    }

    public void getData9(Config data) {
        data.setIp(cfg9Ip.getText());
        data.setMask(cfg9Mask.getText());
        data.setGateway(cfg9Gateway.getText());
    }

    public void getData10(Config data) {
        data.setIp(cfg10Ip.getText());
        data.setMask(cfg10Mask.getText());
        data.setGateway(cfg10Gateway.getText());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        tabbedPane1 = new JTabbedPane();
        tabbedPane1.putClientProperty("html.disable", Boolean.FALSE);
        panel1.add(tabbedPane1, BorderLayout.NORTH);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Configuration1", panel2);
        setIPButton = new JButton();
        setIPButton.setFont(new Font(setIPButton.getFont().getName(), Font.BOLD, 14));
        setIPButton.setText("Set IP");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(setIPButton, gbc);
        final JLabel label1 = new JLabel();
        label1.setFont(new Font(label1.getFont().getName(), Font.BOLD, 14));
        label1.setText("IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label1, gbc);
        cfg1Ip = new JTextField();
        cfg1Ip.setName("cfg1Ip");
        cfg1Ip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cfg1Ip, gbc);
        final JLabel label2 = new JLabel();
        label2.setFont(new Font(label2.getFont().getName(), Font.BOLD, 14));
        label2.setText("Mask");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label2, gbc);
        cfg1Mask = new JTextField();
        cfg1Mask.setName("cfg1Mask");
        cfg1Mask.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cfg1Mask, gbc);
        final JLabel label3 = new JLabel();
        label3.setFont(new Font(label3.getFont().getName(), Font.BOLD, 14));
        label3.setText("Gateway");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label3, gbc);
        cfg1Gateway = new JTextField();
        cfg1Gateway.setName("cfg1Gateway");
        cfg1Gateway.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(cfg1Gateway, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Config2", panel3);
        setIPButton2 = new JButton();
        setIPButton2.setFont(new Font(setIPButton2.getFont().getName(), Font.BOLD, 14));
        setIPButton2.setText("Set IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(setIPButton2, gbc);
        final JLabel label4 = new JLabel();
        label4.setFont(new Font(label4.getFont().getName(), Font.BOLD, 14));
        label4.setText("IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label4, gbc);
        cfg2Ip = new JTextField();
        cfg2Ip.setName("IP");
        cfg2Ip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(cfg2Ip, gbc);
        final JLabel label5 = new JLabel();
        label5.setFont(new Font(label5.getFont().getName(), Font.BOLD, 14));
        label5.setText("Mask");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label5, gbc);
        cfg2Mask = new JTextField();
        cfg2Mask.setName("MASK");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(cfg2Mask, gbc);
        final JLabel label6 = new JLabel();
        label6.setFont(new Font(label6.getFont().getName(), Font.BOLD, 14));
        label6.setText("Gateway");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label6, gbc);
        cfg2Gateway = new JTextField();
        cfg2Gateway.setName("Gateway");
        cfg2Gateway.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(cfg2Gateway, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Config3", panel4);
        setIPButton3 = new JButton();
        setIPButton3.setFont(new Font(setIPButton3.getFont().getName(), Font.BOLD, 14));
        setIPButton3.setText("Set IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(setIPButton3, gbc);
        final JLabel label7 = new JLabel();
        label7.setFont(new Font(label7.getFont().getName(), Font.BOLD, 14));
        label7.setText("IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel4.add(label7, gbc);
        cfg3Ip = new JTextField();
        cfg3Ip.setName("IP");
        cfg3Ip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(cfg3Ip, gbc);
        final JLabel label8 = new JLabel();
        label8.setFont(new Font(label8.getFont().getName(), Font.BOLD, 14));
        label8.setText("Mask");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel4.add(label8, gbc);
        cfg3Mask = new JTextField();
        cfg3Mask.setName("MASK");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(cfg3Mask, gbc);
        final JLabel label9 = new JLabel();
        label9.setFont(new Font(label9.getFont().getName(), Font.BOLD, 14));
        label9.setText("Gateway");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel4.add(label9, gbc);
        cfg3Gateway = new JTextField();
        cfg3Gateway.setName("Gateway");
        cfg3Gateway.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(cfg3Gateway, gbc);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Config4", panel5);
        setIPButton4 = new JButton();
        setIPButton4.setFont(new Font(setIPButton4.getFont().getName(), Font.BOLD, 14));
        setIPButton4.setText("Set IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(setIPButton4, gbc);
        final JLabel label10 = new JLabel();
        label10.setFont(new Font(label10.getFont().getName(), Font.BOLD, 14));
        label10.setText("IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(label10, gbc);
        cfg4Ip = new JTextField();
        cfg4Ip.setName("IP");
        cfg4Ip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(cfg4Ip, gbc);
        final JLabel label11 = new JLabel();
        label11.setFont(new Font(label11.getFont().getName(), Font.BOLD, 14));
        label11.setText("Mask");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(label11, gbc);
        cfg4Mask = new JTextField();
        cfg4Mask.setName("MASK");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(cfg4Mask, gbc);
        final JLabel label12 = new JLabel();
        label12.setFont(new Font(label12.getFont().getName(), Font.BOLD, 14));
        label12.setText("Gateway");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel5.add(label12, gbc);
        cfg4Gateway = new JTextField();
        cfg4Gateway.setName("Gateway");
        cfg4Gateway.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(cfg4Gateway, gbc);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Config5", panel6);
        setIPButton5 = new JButton();
        setIPButton5.setFont(new Font(setIPButton5.getFont().getName(), Font.BOLD, 14));
        setIPButton5.setText("Set IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(setIPButton5, gbc);
        final JLabel label13 = new JLabel();
        label13.setFont(new Font(label13.getFont().getName(), Font.BOLD, 14));
        label13.setText("IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel6.add(label13, gbc);
        cfg5Ip = new JTextField();
        cfg5Ip.setName("IP");
        cfg5Ip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(cfg5Ip, gbc);
        final JLabel label14 = new JLabel();
        label14.setFont(new Font(label14.getFont().getName(), Font.BOLD, 14));
        label14.setText("Mask");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel6.add(label14, gbc);
        cfg5Mask = new JTextField();
        cfg5Mask.setName("MASK");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(cfg5Mask, gbc);
        final JLabel label15 = new JLabel();
        label15.setFont(new Font(label15.getFont().getName(), Font.BOLD, 14));
        label15.setText("Gateway");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel6.add(label15, gbc);
        cfg5Gateway = new JTextField();
        cfg5Gateway.setName("Gateway");
        cfg5Gateway.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel6.add(cfg5Gateway, gbc);
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Config6", panel7);
        setIPButton6 = new JButton();
        setIPButton6.setFont(new Font(setIPButton6.getFont().getName(), Font.BOLD, 14));
        setIPButton6.setText("Set IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(setIPButton6, gbc);
        final JLabel label16 = new JLabel();
        label16.setFont(new Font(label16.getFont().getName(), Font.BOLD, 14));
        label16.setText("IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel7.add(label16, gbc);
        cfg6Ip = new JTextField();
        cfg6Ip.setName("IP");
        cfg6Ip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(cfg6Ip, gbc);
        final JLabel label17 = new JLabel();
        label17.setFont(new Font(label17.getFont().getName(), Font.BOLD, 14));
        label17.setText("Mask");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel7.add(label17, gbc);
        cfg6Mask = new JTextField();
        cfg6Mask.setName("MASK");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(cfg6Mask, gbc);
        final JLabel label18 = new JLabel();
        label18.setFont(new Font(label18.getFont().getName(), Font.BOLD, 14));
        label18.setText("Gateway");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel7.add(label18, gbc);
        cfg6Gateway = new JTextField();
        cfg6Gateway.setName("Gateway");
        cfg6Gateway.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(cfg6Gateway, gbc);
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Config7", panel8);
        setIPButton7 = new JButton();
        setIPButton7.setFont(new Font(setIPButton7.getFont().getName(), Font.BOLD, 14));
        setIPButton7.setText("Set IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel8.add(setIPButton7, gbc);
        final JLabel label19 = new JLabel();
        label19.setFont(new Font(label19.getFont().getName(), Font.BOLD, 14));
        label19.setText("IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel8.add(label19, gbc);
        cfg7Ip = new JTextField();
        cfg7Ip.setName("IP");
        cfg7Ip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel8.add(cfg7Ip, gbc);
        final JLabel label20 = new JLabel();
        label20.setFont(new Font(label20.getFont().getName(), Font.BOLD, 14));
        label20.setText("Mask");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel8.add(label20, gbc);
        cfg7Mask = new JTextField();
        cfg7Mask.setName("MASK");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel8.add(cfg7Mask, gbc);
        final JLabel label21 = new JLabel();
        label21.setFont(new Font(label21.getFont().getName(), Font.BOLD, 14));
        label21.setText("Gateway");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel8.add(label21, gbc);
        cfg7Gateway = new JTextField();
        cfg7Gateway.setName("Gateway");
        cfg7Gateway.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel8.add(cfg7Gateway, gbc);
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Config8", panel9);
        setIPButton8 = new JButton();
        setIPButton8.setFont(new Font(setIPButton8.getFont().getName(), Font.BOLD, 14));
        setIPButton8.setText("Set IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel9.add(setIPButton8, gbc);
        final JLabel label22 = new JLabel();
        label22.setFont(new Font(label22.getFont().getName(), Font.BOLD, 14));
        label22.setText("IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel9.add(label22, gbc);
        cfg8Ip = new JTextField();
        cfg8Ip.setName("IP");
        cfg8Ip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel9.add(cfg8Ip, gbc);
        final JLabel label23 = new JLabel();
        label23.setFont(new Font(label23.getFont().getName(), Font.BOLD, 14));
        label23.setText("Mask");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel9.add(label23, gbc);
        cfg8Mask = new JTextField();
        cfg8Mask.setName("MASK");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel9.add(cfg8Mask, gbc);
        final JLabel label24 = new JLabel();
        label24.setFont(new Font(label24.getFont().getName(), Font.BOLD, 14));
        label24.setText("Gateway");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel9.add(label24, gbc);
        cfg8Gateway = new JTextField();
        cfg8Gateway.setName("Gateway");
        cfg8Gateway.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel9.add(cfg8Gateway, gbc);
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Confgi9", panel10);
        setIPButton9 = new JButton();
        setIPButton9.setFont(new Font(setIPButton9.getFont().getName(), Font.BOLD, 14));
        setIPButton9.setText("Set IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel10.add(setIPButton9, gbc);
        final JLabel label25 = new JLabel();
        label25.setFont(new Font(label25.getFont().getName(), Font.BOLD, 14));
        label25.setText("IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel10.add(label25, gbc);
        cfg9Ip = new JTextField();
        cfg9Ip.setName("IP");
        cfg9Ip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel10.add(cfg9Ip, gbc);
        final JLabel label26 = new JLabel();
        label26.setFont(new Font(label26.getFont().getName(), Font.BOLD, 14));
        label26.setText("Mask");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel10.add(label26, gbc);
        cfg9Mask = new JTextField();
        cfg9Mask.setName("MASK");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel10.add(cfg9Mask, gbc);
        final JLabel label27 = new JLabel();
        label27.setFont(new Font(label27.getFont().getName(), Font.BOLD, 14));
        label27.setText("Gateway");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel10.add(label27, gbc);
        cfg9Gateway = new JTextField();
        cfg9Gateway.setName("Gateway");
        cfg9Gateway.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel10.add(cfg9Gateway, gbc);
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Config10", panel11);
        setIPButton10 = new JButton();
        setIPButton10.setFont(new Font(setIPButton10.getFont().getName(), Font.BOLD, 14));
        setIPButton10.setText("Set IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel11.add(setIPButton10, gbc);
        final JLabel label28 = new JLabel();
        label28.setFont(new Font(label28.getFont().getName(), Font.BOLD, 14));
        label28.setText("IP");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel11.add(label28, gbc);
        cfg10Ip = new JTextField();
        cfg10Ip.setName("IP");
        cfg10Ip.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel11.add(cfg10Ip, gbc);
        final JLabel label29 = new JLabel();
        label29.setFont(new Font(label29.getFont().getName(), Font.BOLD, 14));
        label29.setText("Mask");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel11.add(label29, gbc);
        cfg10Mask = new JTextField();
        cfg10Mask.setName("MASK");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel11.add(cfg10Mask, gbc);
        final JLabel label30 = new JLabel();
        label30.setFont(new Font(label30.getFont().getName(), Font.BOLD, 14));
        label30.setText("Gateway");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel11.add(label30, gbc);
        cfg10Gateway = new JTextField();
        cfg10Gateway.setName("Gateway");
        cfg10Gateway.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel11.add(cfg10Gateway, gbc);
        resetToDefaultButton = new JButton();
        resetToDefaultButton.setFont(new Font(resetToDefaultButton.getFont().getName(), Font.BOLD, 14));
        resetToDefaultButton.setText("Reset to default");
        panel1.add(resetToDefaultButton, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
