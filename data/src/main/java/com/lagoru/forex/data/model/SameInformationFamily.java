package com.lagoru.forex.data.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SameInformationFamily extends RealmObject {

    @Index
    @PrimaryKey
    int id;

    String informationFamilyName;

    RealmList<Information> informations = new RealmList<>();
}
