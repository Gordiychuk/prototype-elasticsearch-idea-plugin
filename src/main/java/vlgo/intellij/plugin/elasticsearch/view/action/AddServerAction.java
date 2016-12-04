package vlgo.intellij.plugin.elasticsearch.view.action;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import vlgo.intellij.plugin.elasticsearch.ElasticSearchSetting;
import vlgo.intellij.plugin.elasticsearch.ElasticsearchServersSetting;
import vlgo.intellij.plugin.elasticsearch.view.ConfigurationDialog;

import java.util.UUID;


public class AddServerAction extends AnAction {

    public AddServerAction() {
        super("Add", "Add remote ElasticSearch server", AllIcons.General.Add);
    }

    public void actionPerformed(AnActionEvent e) {
        ElasticSearchSetting setting = new ElasticSearchSetting(UUID.randomUUID());
        ConfigurationDialog dialog = new ConfigurationDialog(setting);
        dialog.setTitle("Add ElasticSearch server");
        dialog.show();
        if (!dialog.isOK()) {
            return;
        }

        ElasticsearchServersSetting settingsGroup =
                ElasticsearchServersSetting.getInstance(e.getProject());

        settingsGroup.addSetting(setting);
    }
}
