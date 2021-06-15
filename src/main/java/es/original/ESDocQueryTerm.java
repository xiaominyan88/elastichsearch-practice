package es.original;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class ESDocQueryTerm extends AbstractESOperation {

    public ESDocQueryTerm(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {

        SearchRequest request = new SearchRequest();
        request.indices("userexample");
        SearchSourceBuilder builders = new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 33));
        request.source(builders);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        return response;

    }
}
