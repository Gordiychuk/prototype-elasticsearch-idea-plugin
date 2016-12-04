package vlgo.intellij.plugin.elasticsearch.view;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class ElasticSearchToolWindowFactory implements ToolWindowFactory {
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        final ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        final ElasticSearchToolWindowContent elasticsearchContent = new ElasticSearchToolWindowContent(project);
        Content content = contentFactory.createContent(elasticsearchContent, null, false);
        toolWindow.getContentManager().addContent(content);
    }
}
