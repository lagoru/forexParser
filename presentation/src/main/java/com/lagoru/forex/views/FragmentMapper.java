package com.lagoru.forex.views;

import com.lagoru.forex.data.utils.ListUtils;
import com.lagoru.forex.views.fragments.SingleWebsiteInfoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Getter;

/**
 * Created by lagoru on 13.12.16.
 */
@Singleton
public class FragmentMapper {

    @Getter
    List<Class> allBaseFragmentsForMainScreen = new ArrayList<>();

    @Inject
    public FragmentMapper() {
        allBaseFragmentsForMainScreen.add(SingleWebsiteInfoView.class);
    }

    public List<Class> transform(Set<String> fragmentNamesSet) {
        List<Class> baseFragmentClassSet = new ArrayList<>();
        for (String fragmentName : fragmentNamesSet) {
            for (Class clazz : allBaseFragmentsForMainScreen) {
                if (clazz.getCanonicalName().equals(fragmentName)) {
                    baseFragmentClassSet.add(clazz);
                }
            }
        }
        return baseFragmentClassSet;
    }

    public Set<String> getDefaultScreenNames() {
        return ListUtils.linkedHashSetFrom(SingleWebsiteInfoView.class.getCanonicalName());
    }
}
