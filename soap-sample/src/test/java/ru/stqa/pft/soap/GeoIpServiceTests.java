package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * Created by RomanovaD on 07.07.2017.
 */
public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("77.246.237.162");
        assertEquals(geoIP.getCountryCode(),"RUS");
    }

    @Test
    public void testInvalidIp(){
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("77.246.237.xxx");
        assertEquals(geoIP.getCountryCode(),"RUS");
    }

}
