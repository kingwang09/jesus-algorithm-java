package org.example.stream;

import org.example.constant.CampaignType;
import org.example.model.Activity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListExample {

    //Map<Object, List<Identify>> -> group by를 사용하면 된다.
    public static void main(String[] args){
        List<Activity> values = Arrays.asList(
                Activity.builder()
                        .campaignId(1)
                        .campaignType(CampaignType.FUNDING)
                        .userId(600)
                        .build(),
                Activity.builder()
                        .campaignId(1)
                        .campaignType(CampaignType.FUNDING)
                        .userId(200)
                        .build(),
                Activity.builder()
                        .campaignId(1)
                        .campaignType(CampaignType.FUNDING)
                        .userId(400)
                        .build(),
                Activity.builder()
                        .campaignId(1)
                        .campaignType(CampaignType.FUNDING)
                        .userId(300)
                        .build(),
                Activity.builder()
                        .campaignId(1)
                        .campaignType(CampaignType.FUNDING)
                        .userId(500)
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

        Stream<Activity> streamValues = values.stream().sorted(Comparator.comparing(Activity::getUserId));//정렬
        //values.stream().sorted(Comparator.comparing(Activity::getUserId));//정렬
        Map<String,List<Activity>> map = streamValues.collect(Collectors.groupingBy(d -> d.getCampaignTypeAndCampaignId()));
        //한번더 groupingBy UserId

        for(String key : map.keySet()){
            List<Activity> groupingByCampaigns = map.get(key);
            System.out.println("key="+key+", "+groupingByCampaigns);
        }

    }
}
