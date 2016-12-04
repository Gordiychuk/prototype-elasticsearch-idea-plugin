package vlgo.intellij.plugin.elasticsearch.view;

import com.google.common.base.Strings;
import org.apache.commons.lang.StringUtils;
import vlgo.intellij.plugin.elasticsearch.ElasticSearchSetting;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unchecked")
public class ServerConfigurationPanel extends JPanel {
    private JPanel rootPanel;

    private JLabel feedbackLabel;

    private JTextField labelField;
    private JTabbedPane settingTabbedPane;
    private JTextField httpPortField;
    private JTextField hostField;

    public ServerConfigurationPanel() {
        setLayout(new BorderLayout());
        add(rootPanel, BorderLayout.CENTER);

        labelField.setName("labelField");
        feedbackLabel.setName("feedbackLabel");
        settingTabbedPane.setName("tabbedSettings");
    }

    private String getLabel() {
        String label = labelField.getText();
        if (StringUtils.isNotBlank(label)) {
            return label;
        }
        return null;
    }

    public void loadConfigurationData(ElasticSearchSetting settings) {
        labelField.setText(settings.getLabel());
        hostField.setText(settings.getHost());
        httpPortField.setText(settings.getHttpPort());
    }

    public void applyConfigurationData(ElasticSearchSetting settings) {
        settings.setHost(hostField.getText());
        settings.setHttpPort(httpPortField.getText());

        String label = labelField.getText();

        if (Strings.isNullOrEmpty(label)) {
            label = String.format("%s:%s", settings.getHost(), settings.getHttpPort());
        }

        settings.setLabel(label);
    }
}
