package com.lagoru.forex.data.dataprovider.implementation;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by lagoru on 29.11.16.
 */

public class InvestingComDataProviderUnitTest {
    InvestingComDataProvider investingComDataProvider = new InvestingComDataProvider();

    @Test
    public void testParser() {
        try {
            assertNotNull(null == investingComDataProvider.parseWebsite());
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
