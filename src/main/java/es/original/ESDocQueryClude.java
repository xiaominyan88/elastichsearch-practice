package es.original;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class ESDocQueryClude extends AbstractESOperation {

    public ESDocQueryClude(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {

        SearchRequest request = new SearchRequest();
        request.indices("userexample");
        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        String[] includes = {"name","age"};
        String[] excludes = {};
        query.fetchSource(includes,excludes);
        request.source(query);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        return response;
    }
}
