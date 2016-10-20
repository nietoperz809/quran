import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/*
 * Created by JFormDesigner on Mon Jul 25 21:04:15 CEST 2016
 */



/**
 * @author unknown
 */
public class RegExerGUI extends JInternalFrame {
    public RegExerGUI() {
        initComponents();
    }

    private void sourceTextValueChanged(TextEvent e) {
        // TODO add your code here
    }

    private void regexTextValueChanged(TextEvent e) {
        // TODO add your code here
    }

    private void replaceTextValueChanged(TextEvent e) {
        // TODO add your code here
    }

    private void check_case_insensitiveItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void check_multilineItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void check_dotallItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void check_unicode_caseItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void check_canon_eqItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new Label();
        label2 = new Label();
        source = new TextField();
        regex = new TextField();
        textOut = new TextArea();
        label3 = new Label();
        replace = new TextField();
        check_case_insensitive = new Checkbox();
        check_multiline = new Checkbox();
        check_dotall = new Checkbox();
        check_unicode_case = new Checkbox();
        check_canon_eq = new Checkbox();
        button1 = new Button();

        //======== this ========
        setTitle("RegExer");
        setName("RegExer");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Source Text");

        //---- label2 ----
        label2.setText("RegEx");

        //---- source ----
        source.addTextListener(new TextListener() {
            public void textValueChanged(TextEvent e) {
                sourceTextValueChanged(e);
            }
        });

        //---- regex ----
        regex.addTextListener(new TextListener() {
            public void textValueChanged(TextEvent e) {
                regexTextValueChanged(e);
            }
        });

        //---- textOut ----
        textOut.setEditable(false);
        textOut.setText("Welcome to REGEXER!");

        //---- label3 ----
        label3.setText("Replace");

        //---- replace ----
        replace.addTextListener(new TextListener() {
            public void textValueChanged(TextEvent e) {
                replaceTextValueChanged(e);
            }
        });

        //---- check_case_insensitive ----
        check_case_insensitive.setLabel("CASE_INSENSITIVE");
        check_case_insensitive.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                check_case_insensitiveItemStateChanged(e);
            }
        });

        //---- check_multiline ----
        check_multiline.setLabel("MULTILINE");
        check_multiline.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                check_multilineItemStateChanged(e);
            }
        });

        //---- check_dotall ----
        check_dotall.setLabel("DOTALL");
        check_dotall.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                check_dotallItemStateChanged(e);
            }
        });

        //---- check_unicode_case ----
        check_unicode_case.setLabel("UNICODE_CASE");
        check_unicode_case.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                check_unicode_caseItemStateChanged(e);
            }
        });

        //---- check_canon_eq ----
        check_canon_eq.setLabel("CANON_EQ");
        check_canon_eq.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                check_canon_eqItemStateChanged(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup()
                        .add(textOut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(10, 10, 10)
                            .add(check_case_insensitive, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(check_multiline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(check_dotall, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(check_unicode_case, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(check_canon_eq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .add(0, 14, Short.MAX_VALUE))
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(contentPaneLayout.createParallelGroup()
                                .add(label1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .add(label2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .add(label3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .add(contentPaneLayout.createParallelGroup()
                                .add(source, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(regex, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(replace, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                        .add(label1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(source, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(label2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(regex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup()
                        .add(replace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(label3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.CENTER)
                        .add(check_case_insensitive, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(check_multiline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(check_dotall, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(check_unicode_case, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .add(check_canon_eq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(textOut, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addContainerGap())
        );

        //---- button1 ----
        button1.setLabel("button1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private Label label1;
    private Label label2;
    private TextField source;
    private TextField regex;
    private TextArea textOut;
    private Label label3;
    private TextField replace;
    private Checkbox check_case_insensitive;
    private Checkbox check_multiline;
    private Checkbox check_dotall;
    private Checkbox check_unicode_case;
    private Checkbox check_canon_eq;
    private Button button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
