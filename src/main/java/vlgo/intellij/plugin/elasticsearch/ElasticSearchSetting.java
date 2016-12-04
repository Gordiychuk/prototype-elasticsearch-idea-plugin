package vlgo.intellij.plugin.elasticsearch;


import java.util.UUID;

public class ElasticSearchSetting {
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_HTTP_PORT = "9200";

    private UUID id;
    private String label;
    private String host = DEFAULT_HOST;
    private String httpPort = DEFAULT_HTTP_PORT;

    public ElasticSearchSetting(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(String httpPort) {
        this.httpPort = httpPort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElasticSearchSetting that = (ElasticSearchSetting) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
