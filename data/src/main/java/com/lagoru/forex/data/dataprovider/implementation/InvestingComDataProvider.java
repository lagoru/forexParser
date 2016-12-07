package com.lagoru.forex.data.dataprovider.implementation;

import com.lagoru.forex.data.dataprovider.DataProviderInterface;
import com.lagoru.forex.data.model.Information;
import com.lagoru.forex.data.utils.DateUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lagoru on 29.11.16.
 */

public class InvestingComDataProvider extends DataProviderInterface {
    @Override
    public String getUrl() {
        return "http://www.investing.com/economic-calendar/";
    }

    @Override
    public List<Information> parseWebsite() throws IOException {
        List<Information> informationList = new ArrayList<>();
        Document document = Jsoup.connect(getUrl()).get().normalise();
        Elements elements = document.select("article[class=js-link-item calItem economic]");
        for (int i = 0; i < elements.size(); i++) {
            Information information = new Information();
            Element element = elements.get(i);
            try {
                information.setDate(DateUtils.parseDate(element.attr("event_timestamp"), DateUtils.investingComDateFormat));
            } catch (ParseException e) {
                e.printStackTrace();//ignore ?
            }
            information.setWebsiteMoreInfo(element.attr("data-href"));
            getEventTimeAndImportance(element, information);
            Element currencyElement = element.select("div[class=curr]").first();
            information.setCommodity(currencyElement.ownText());
            getEventValuesImportanceAndDescription(element, information);
            informationList.add(information);
        }

        return informationList;
    }

    private void getEventTimeAndImportance(Element element, Information information) {
        Element divTimeElement = element.select("div[class=time]").first();
        int importance = element.select("span[class=smallDarkBull]").size(); //od jednego do trzech
        Element pElement = divTimeElement.select("p[title]").first();
        String timeString = pElement.attr("evtstrttime"); //evtstrttime="02:30"
        information.setWebsiteImportance(importance);
        Date date = information.getDate();
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        String[] hM = timeString.split(":");
        calendar.set(Calendar.HOUR, Integer.parseInt(hM[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(hM[1]));

        information.setDate(date);
    }

    private void getEventValuesImportanceAndDescription(Element element, Information information) {
        Element descriptionElement = element.select("div[class=rightSide]").first();
        if (descriptionElement != null) {
            information.setDescription(descriptionElement.select("p").first().ownText());
            Elements values = descriptionElement.select("span");
            Element iElement = values.get(0).select("i[class]").first(); //actual
            if (iElement != null) {
                information.setActualWebsiteImpact(getImpactFromString(iElement.attr("class")));
                information.setActualValue(iElement.ownText());
            }
            iElement = values.get(1).select("i[class]").first();
            if (iElement != null) {
                information.setPredictedWebsiteImpact(getImpactFromString(iElement.attr("class"))); //za bardzo tego nie ogarniam ale się zobaczy
                information.setPredictedValue(iElement.ownText());
            }
            iElement = values.get(2).select("i[class]").first();
            if (iElement != null) {
                information.setPreviousValue(iElement.ownText());
            }
        }
    }

    public int getImpactFromString(String string) {
        if (string.contains("blackFont")) {
            return 1;
        } else if (string.contains("redFont")) {
            return 0;
        } else if (string.contains("greenFont")) {
            return 2;
        }

        return 1;
    }
}
