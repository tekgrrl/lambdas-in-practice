package org.arw.examples;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.arw.examples.Asset.AssetType;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    final List<Asset> assets = Arrays.asList(
        new Asset(Asset.AssetType.BOND, 1000),
        new Asset(Asset.AssetType.BOND, 2000),
        new Asset(Asset.AssetType.STOCK, 3000),
        new Asset(Asset.AssetType.STOCK, 4000)
        );

    @BeforeEach
    void setup() {
        // nothing to do here
    }
    
    @Test
    @DisplayName("Total all Asset values")
    public void testTotalAssetValues()
    {
        assertEquals(10000, AssetUtil.totalAssetValues(assets, asset -> true) );
    }

    @Test
    @DisplayName("Total all Bond Values")
    public void testBondAssetValues()
    {
        assertEquals(3000, AssetUtil.totalAssetValues(assets, asset -> asset.getType() == AssetType.BOND));
    }

    @Test
    @DisplayName("Total all Stock Values")
    public void testStockAssetValues() 
    {
        assertEquals(7000, AssetUtil.totalAssetValues(assets, asset -> asset.getType() == AssetType.STOCK));
    }
}
