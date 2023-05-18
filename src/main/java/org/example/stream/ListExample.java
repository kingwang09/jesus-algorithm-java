package org.example.stream;

import org.example.constant.CampaignType;
import org.example.model.Activity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListExample {

    //Map<Object, List<Identify>> -> group by를 사용하면 된다.
    public static void main(String[] args){
        List<Activity> values = Arrays.asList(
                Activity.builder()
                        .campaignId(1)
                        .campaignType(CampaignType.FUNDING)
                        .userId(100)
                        .build(),
                Activity.builder()
                        .campaignId(1)
                        .campaignType(CampaignType.FUNDING)
                        .userId(200)
                        .build(),
                Activity.builder()
                        .campaignId(2)
                        .campaignType(CampaignType.STORE)
                        .userId(200)
                        .build(),
                Activity.builder()
                        .campaignId(3)
                        .campaignType(CampaignType.COMING)
                        .userId(300)
                        .build()
        );

        Map<String,List<Activity>> map = values.stream().collect(Collectors.groupingBy(d -> d.getCampaignTypeAndCampaignId()));
        System.out.println(map);

    }
}
