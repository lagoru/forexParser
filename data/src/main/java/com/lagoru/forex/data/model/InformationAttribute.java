package com.lagoru.forex.data.model;

import io.realm.RealmObject;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by lagoru on 05.12.16.
 */
@Data
@NoArgsConstructor
public class InformationAttribute extends RealmObject {

    int informationId;

    //moze wskazywac na pojedyncza informacje
    Information information;

    //moze wskazywac na cala rodzine
    SameInformationFamily sameInformationFamily;

    String attributeName;

    String attributeValue;

    String attributeDescription;

    int importanceLevel;
}
