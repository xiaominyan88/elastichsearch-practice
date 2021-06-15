package es.original;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class ESDocQueryRange extends AbstractESOperation {

    public ESDocQueryRange(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {
        SearchRequest request = new SearchRequest();
        request.indices("userexample");
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
        rangeQuery.gte(10);
        rangeQuery.lte(40);
        SearchSourceBuilder query = new SearchSourceBuilder().query(rangeQuery);
        request.source(query);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        return response;
    }
}
