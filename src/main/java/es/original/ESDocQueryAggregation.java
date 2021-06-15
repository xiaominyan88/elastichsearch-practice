package es.original;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class ESDocQueryAggregation extends AbstractESOperation {

    public ESDocQueryAggregation(String address,int port,String schema){
        super(address, port, schema);
    }

    @Override
    public Object doAction() throws Exception {
        SearchRequest request = new SearchRequest();
        request.indices("userexample");
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("ageNameGroup").field("age.keyword").field("name.keyword");
        SearchSourceBuilder aggregation = new SearchSourceBuilder().aggregation(termsAggregationBuilder);
        request.source(aggregation);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        return response;
    }
}
