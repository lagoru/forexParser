package com.lagoru.forex.utils;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lagoru on 25.09.16.
 */
@EBean(scope = EBean.Scope.Singleton)
public class InformationUtils {
    @Bean
    DatabaseHelper databaseHelper;

    /***
     * If returns true then information was updated/ added
     *
     * @param information
     * @return
     */
    public boolean addOrUpdateInformation(Information information) {
        try {
            Dao<Information, Integer> informationIntegerDao = databaseHelper.getDaoObject(Information.class);
            QueryBuilder<Information, Integer> queryBuilder = informationIntegerDao.queryBuilder();
            queryBuilder.where().eq(Information.DESCRIPTION_FIELD_NAME, information.getDescription())
                    .and().eq(Information.WEBPAGE_FIELD_NAME, information.getWebpage());
            PreparedQuery<Information> preparedQuery = queryBuilder.prepare();
            List<Information> informationList = informationIntegerDao.query(preparedQuery);
            if (informationList.isEmpty()) {
                informationIntegerDao.create(information);
                return true;
            } else {
                boolean found = false;
                for (Information informationResult : informationList) {
                    if (information.getDate().equals(informationResult.getDate())) {
                        found = true;
                        information.setInformationId(informationResult.getInformationId());
                        if (!information.equals(informationResult)) {
                            informationIntegerDao.update(information);
                            return true;
                        }
                        break;
                    }
                }
                if (!found) {
                    informationIntegerDao.create(information);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
