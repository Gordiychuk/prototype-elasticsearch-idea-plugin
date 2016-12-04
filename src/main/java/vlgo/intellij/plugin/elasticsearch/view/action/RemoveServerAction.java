package vlgo.intellij.plugin.elasticsearch.view.action;


import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class RemoveServerAction extends AnAction {
    public RemoveServerAction() {
        super("Delete", "Delete remote ElasticSearch server", AllIcons.General.Remove);
    }

    public void actionPerformed(AnActionEvent e) {

    }
}
