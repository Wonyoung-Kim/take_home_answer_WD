import static org.junit.jupiter.api.Assertions.*;

class hotelPriceTest {

    @org.junit.jupiter.api.Test
    void getPrice() {
        hotelPrice hp_1 = new hotelPrice(1,1,2,1);
        hotelPrice2 hp2_1 = new hotelPrice2(1,1,2,1);
        hotelPrice hp_2 = new hotelPrice(2,1,2,15);
        hotelPrice hp2_2 = new hotelPrice(2,1,2,15);
        hotelPrice hp_3 = new hotelPrice(1,1,11,1);
        hotelPrice hp2_3 = new hotelPrice(1,1,11,1);
        hotelPrice hp_4 = new hotelPrice(2,1,5,21);
        hotelPrice hp2_4 = new hotelPrice(2,1,5,21);
        hotelPrice hp_5 = new hotelPrice(1,1,12,1);
        hotelPrice hp2_5 = new hotelPrice(1,1,12,1);
        hotelPrice hp_6 = new hotelPrice(3,15,6,21);
        hotelPrice hp2_6 = new hotelPrice(3,15,6,21);


        assertEquals(hp_1.getPrice(), 76);
        assertEquals(hp2_1.getPrice(), 76);
        assertEquals(hp_2.getPrice(), 36);
        assertEquals(hp2_2.getPrice(), 36);
        assertEquals(hp_3.getPrice(), 383);
        assertEquals(hp2_3.getPrice(), 383);
        assertEquals(hp_4.getPrice(), 190);
        assertEquals(hp2_4.getPrice(), 190);
        assertEquals(hp_5.getPrice(), 413);
        assertEquals(hp2_5.getPrice(), 413);
        assertEquals(hp_6.getPrice(), 175);
        assertEquals(hp2_6.getPrice(), 175);

    }
}