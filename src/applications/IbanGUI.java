package applications;

import iban.CountryCode;
import iban.Iban;
import iban.IbanException;
import iban.IbanImpl;
import misc.MDIChild;
import misc.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 7/10/2016.
 */
public class IbanGUI extends MDIChild
{
    private JPanel panel1;
    private JPanel topPanel;
    private JTextField textKTO;
    private JTextField textBLZ;
    private JButton calculateIban;
    private JLabel outputIban;
    private JComboBox<String> comboCountry;
    private JLabel outputBIC;
    private JButton clipbrdButton;

    private void initCombo ()
    {
        for (CountryCode cd : CountryCode.values())
        {
            comboCountry.addItem(cd.toString());
        }
        this.setContentPane(panel1);
        comboCountry.setSelectedItem(CountryCode.COUNTRY_CODE_GERMAN.toString());
    }


    public IbanGUI ()
    {
        super();
        initCombo();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("IBAN Tool");
        setSize(500, 300);
        setVisible(true);
        calculateIban.addActionListener(e -> execute());
        clipbrdButton.addActionListener(e -> toClipBoard());
    }

    private void toClipBoard ()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("KTO: ").append(textKTO.getText()).append("\r\n");
        sb.append("BLZ: ").append(textBLZ.getText()).append("\r\n");
        sb.append("Country: ").append(comboCountry.getSelectedItem()).append("\r\n");
        sb.append("IBAN: ").append(outputIban.getText()).append("\r\n");
        sb.append("BIC: ").append(outputBIC.getText()).append("\r\n");

        Tools.toClipBoard(sb.toString());
    }

    private void execute ()
    {
        String kto = textKTO.getText();
        String blz = textBLZ.getText();
        String country = (String) comboCountry.getSelectedItem();
        try
        {
            Iban iban = new IbanImpl(country, blz, kto);
            outputIban.setText(iban.toString());
            outputBIC.setText(iban.getBic());
        }
        catch (IbanException e)
        {
            outputIban.setText(e.getMessage());
            outputBIC.setText("Error");
        }

        System.out.println(kto);
        System.out.println(blz);
        System.out.println(country);
    }

    @Override
    public void initAfterDeserialization ()
    {

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
    private void $$$setupUI$$$ ()
    {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        panel1.setBackground(new Color(-15009758));
        topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        topPanel.setBackground(new Color(-1700082));
        topPanel.setMinimumSize(new Dimension(0, 100));
        topPanel.setPreferredSize(new Dimension(4, 100));
        topPanel.setRequestFocusEnabled(false);
        panel1.add(topPanel, BorderLayout.NORTH);
        topPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null));
        textKTO = new JTextField();
        textKTO.setText("");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(textKTO, gbc);
        final JLabel label1 = new JLabel();
        label1.setForeground(new Color(-16777216));
        label1.setText("KTO:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(label1, gbc);
        calculateIban = new JButton();
        calculateIban.setLabel("Do Calc");
        calculateIban.setText("Do Calc");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(calculateIban, gbc);
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(-16777216));
        label2.setText("BLZ:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(label2, gbc);
        textBLZ = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(textBLZ, gbc);
        final JLabel label3 = new JLabel();
        label3.setForeground(new Color(-16777216));
        label3.setText("Country");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(label4, gbc);
        comboCountry = new JComboBox();
        comboCountry.setMinimumSize(new Dimension(1000, 31));
        comboCountry.setPreferredSize(new Dimension(70, 31));
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(comboCountry, gbc);
        clipbrdButton = new JButton();
        clipbrdButton.setLabel("toClip");
        clipbrdButton.setText("toClip");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(clipbrdButton, gbc);
        outputIban = new JLabel();
        outputIban.setBackground(new Color(-16777216));
        Font outputIbanFont = this.$$$getFont$$$("Arial", -1, 28, outputIban.getFont());
        if (outputIbanFont != null)
        {
            outputIban.setFont(outputIbanFont);
        }
        outputIban.setForeground(new Color(-855544));
        outputIban.setHorizontalAlignment(0);
        outputIban.setOpaque(true);
        outputIban.setPreferredSize(new Dimension(36, 50));
        outputIban.setText("Label");
        panel1.add(outputIban, BorderLayout.CENTER);
        outputBIC = new JLabel();
        outputBIC.setBackground(new Color(-15987184));
        Font outputBICFont = this.$$$getFont$$$("Arial", -1, 24, outputBIC.getFont());
        if (outputBICFont != null)
        {
            outputBIC.setFont(outputBICFont);
        }
        outputBIC.setForeground(new Color(-1));
        outputBIC.setHorizontalAlignment(0);
        outputBIC.setOpaque(true);
        outputBIC.setPreferredSize(new Dimension(36, 60));
        outputBIC.setText("Label");
        panel1.add(outputBIC, BorderLayout.SOUTH);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$ (String fontName, int style, int size, Font currentFont)
    {
        if (currentFont == null)
        {
            return null;
        }
        String resultName;
        if (fontName == null)
        {
            resultName = currentFont.getName();
        }
        else
        {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1'))
            {
                resultName = fontName;
            }
            else
            {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$ ()
    {
        return panel1;
    }
}
