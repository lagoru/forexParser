package com.lagoru.forex.data.model;

import com.lagoru.forex.data.utils.ListUtils;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.Required;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by lagoru on 27.11.16.
 */

@Data
@NoArgsConstructor
public class Information extends RealmObject {

    public static final String DESCRIPTION_FIELD_NAME = "description";

    public static final String DATE_FIELD_NAME = "date";

    public static final String WEBPAGE_FIELD_NAME = "webpage";

    int id;

    SameInformationFamily sameInformationFamily;

    String webpage;

    @Index
    @Required
    String commodity;

    @Index
    @Required
    Date date;

    String description;

    String websiteMoreInfo;

    String predictedValue;

    String previousValue;

    String actualValue;

    int websiteImportance; //impakt jaki uwaza strona

    int userImportance;// impakt jaki uważa uzytkownik

    int predictedWebsiteImpact;

    int actualWebsiteImpact;

    int userImpact;

    public enum Importance {
        BIG,
        MEDIUM,
        SMALL;

        public static Importance getImpact(int val) {
            if (val == 1) {
                return SMALL;
            } else if (val == 2) {
                return MEDIUM;
            } else if (val == 3) {
                return BIG;
            } else {
                return null;
            }
        }
    }

    public enum Impact {
        NEGATIVE,
        NEUTRAL,
        POSITIVE
    }

    public boolean equals(Information other) {
        return webpage.equals(other.webpage) && description.equals(other.description) &&
                ListUtils.equals(actualWebsiteImpact, other.actualWebsiteImpact) && ListUtils.equals(actualValue, other.actualValue);
    }
}
