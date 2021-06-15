package es.original;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class ESDocQuery extends AbstractESOperation {

    public ESDocQuery(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {

        SearchRequest request = new SearchRequest();

        request.indices("userexample");

        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));

        //request.source(new SearchSourceBuilder().query(QueryBuilders.matchQuery("name","xiao")));

        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        return response;
    }
}
