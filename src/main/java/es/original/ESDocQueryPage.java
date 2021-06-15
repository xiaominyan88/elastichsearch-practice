package es.original;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class ESDocQueryPage extends AbstractESOperation {

    public ESDocQueryPage(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {

        SearchRequest request = new SearchRequest();
        request.indices("userexample");
        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        query.from(2);
        query.size(2);
        request.source(query);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        return response;

    }
}
