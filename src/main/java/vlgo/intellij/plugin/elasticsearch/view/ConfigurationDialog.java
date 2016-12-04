package vlgo.intellij.plugin.elasticsearch.view;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;
import vlgo.intellij.plugin.elasticsearch.ElasticSearchSetting;

import javax.swing.*;


public class ConfigurationDialog extends DialogWrapper {
    private ServerConfigurationPanel serverConfigurationPanel;
    private ElasticSearchSetting settings;

    public ConfigurationDialog(ElasticSearchSetting setting) {
        super(true);
        this.settings = setting;

        init();
    }

    @Nullable
    protected JComponent createCenterPanel() {
        serverConfigurationPanel = new ServerConfigurationPanel();
        serverConfigurationPanel.loadConfigurationData(settings);
        return serverConfigurationPanel;
    }

    @Override
    protected void doOKAction() {
        serverConfigurationPanel.applyConfigurationData(settings);
        super.doOKAction();
    }
}
