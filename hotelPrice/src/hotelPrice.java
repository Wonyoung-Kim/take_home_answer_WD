/**
 * Time complexity - > constatn O(1) since input year is limited to same year
 * Space complexity - > constant O(1) since the value of T(n) is bounded by a value
 * that does not depend on the size of the input
 */
public class hotelPrice {
    int startMonth;
    int startDay;
    int endMonth;
    int endDay;
    int totalDate;

    public hotelPrice(int startMonth, int startDay, int endMonth, int endDay) {
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.startMonth = startMonth;
        this.startDay = startDay;
    }

    public int getPrice() {
        getTotalDate();
        System.out.println(totalDate);
        int totalPrice = 0;
        int fridayAdjustor = 0;
        int flatRateApplied = 50;
        for (int i = 1; i <= totalDate; i++) {
            if (i <= flatRateApplied) {
                //sunday
                if (i % 7 == 0 && i >= 7) {
                    totalPrice += 5;
                    //friday
                } else if ((i - fridayAdjustor) % 6 == 0 && i >= 6) {
                    totalPrice += 3;
                    fridayAdjustor++;
                    //weekday
                } else {
                    totalPrice += 2;
                }
                //flat rate applied for all days
            } else {
                totalPrice++;
            }
        }
        return totalPrice;
    }


    public int getTotalDate() {
        int gapOfMonth = endMonth - startMonth;
        totalDate = 0;
        //calculate total days from start month to end month excluding start and end day.
        if (gapOfMonth != 0) {
            for (int i = startMonth; i < endMonth; i++) {
                if (i % 2 == 0) {
                    for (int j = 1; j <= 31; j++) {
                        totalDate++;
                    }
                } else {
                    for (int j = 1; j <= 30; j++) {
                        totalDate++;
                    }
                }
            }
            // including start and end day to totaldate.
            totalDate = (totalDate - startDay) + endDay;
        } else {
            for (int i = 1; i < endDay; i++) {
                totalDate++;
            }
        }
        return totalDate;
    }
}
