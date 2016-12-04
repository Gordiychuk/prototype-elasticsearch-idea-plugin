package vlgo.intellij.plugin.elasticsearch;


import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class ElasticsearchComponent extends AbstractProjectComponent {
    protected ElasticsearchComponent(Project project) {
        super(project);
    }

    @NotNull
    public String getComponentName() {
        return "elasticsearch";
    }

    public void projectOpened() {
    }

    public void projectClosed() {
    }
}
