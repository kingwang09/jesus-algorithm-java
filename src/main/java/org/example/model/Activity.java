package org.example.model;

import lombok.*;
import org.example.constant.CampaignType;


@ToString
@Getter
@Builder
@AllArgsConstructor
public class Activity {

    private CampaignType campaignType;
    private Integer campaignId;

    private Integer userId;

    public String getCampaignTypeAndCampaignId(){
        return campaignType + "_" + campaignId;
    }
}
