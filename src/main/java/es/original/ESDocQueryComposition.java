package es.original;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class ESDocQueryComposition extends AbstractESOperation {

    public ESDocQueryComposition(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {
        SearchRequest request = new SearchRequest();
        request.indices("userexample");
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(QueryBuilders.matchQuery("sex","male"));
        boolQuery.mustNot(QueryBuilders.matchQuery("age",30));
        SearchSourceBuilder query = new SearchSourceBuilder().query(boolQuery);
        request.source(query);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        return response;
    }

}
