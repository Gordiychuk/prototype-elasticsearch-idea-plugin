package vlgo.intellij.plugin.elasticsearch;


import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

import java.util.*;


@State(name = "ElasticSearchConfiguration", storages = @Storage(file = "$PROJECT_CONFIG_DIR$/elasticSearchSettings.xml"))
public class ElasticsearchServersSetting implements PersistentStateComponent<ElasticsearchServersSetting> {
    private Map<UUID, ElasticSearchSetting> serverIdToSetting = new LinkedHashMap<UUID, ElasticSearchSetting>();

    public static ElasticsearchServersSetting getInstance(Project project) {
        return ServiceManager.getService(project, ElasticsearchServersSetting.class);
    }

    public Collection<ElasticSearchSetting> getSettings() {
        return Collections.unmodifiableCollection(serverIdToSetting.values());
    }

    public ElasticSearchSetting getSetting(UUID serverId) {
        return serverIdToSetting.get(serverId);
    }

    public void addSetting(ElasticSearchSetting setting) {
        serverIdToSetting.put(setting.getId(), setting);
    }

    public void removeSetting(UUID serverId) {
        serverIdToSetting.remove(serverId);
    }

    @Nullable
    public ElasticsearchServersSetting getState() {
        return this;
    }

    public void loadState(ElasticsearchServersSetting state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}
