package es.spring.config;

import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@ConfigurationProperties(prefix = "elasticsearch")
@Configuration
@Data
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    private String address;

    private int port;

    private String schema;

    @Override
    public RestHighLevelClient elasticsearchClient() {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost(address, port, schema))
        );
        return esClient;
    }
}
