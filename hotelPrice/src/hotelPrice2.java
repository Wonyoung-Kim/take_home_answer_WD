/**
 * Time complexity - > constatn since input year is limited to same year
 * Space complexity - > constant since the value of T(n) is bounded by a value
 * that does not depend on the size of the input
 */
public class hotelPrice2 {
    int startMonth;
    int startDay;
    int endMonth;
    int endDay;
    int totalDate;

    public hotelPrice2 (int startMonth, int startDay, int endMonth, int endDay) {
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.startMonth = startMonth;
        this.startDay = startDay;
    }
    public int getPrice() {
        getTotalDate();
        int regularPrice = 0;
        //get flat rate number of days
        int flatRateApllied = totalDate > 50 ? totalDate - 50 : 0;
        //get normal days
        totalDate = totalDate > 50 ? 50 : totalDate % 50;

        int sunDay = totalDate / 7;
        //(totalDate%7)/6 -> in case endDay ends at Saturday.
        int satDay = totalDate / 7 + (totalDate % 7) / 6;
        int weekDay = totalDate - sunDay - satDay;
        //get price of normal rate.
        regularPrice+= sunDay * 5 + satDay * 3 + weekDay * 2;
        //return normal price + flat price.
        return regularPrice + flatRateApllied;

    }
    public int getTotalDate() {
        //int gapOfMonth = endMonth - startMonth;
        //totalDate = gapOfMonth*30 + (gapOfMonth +1)/2 + (endDay - startDay);
        //return totalDate;
        //add month difference
        totalDate += 30 * (endMonth - startMonth);

        //add day difference
        totalDate += (endDay - startDay);

        //add the extra from having 31 days every two months
        totalDate += (endMonth - startMonth) / 2;

        //if the month start from even months and the end month is different,
        //add another day since it ends with 31
        //if startMonth == endMonth, startMonth/endMonth = 1,
        //so 1-1 is 0, nothing get added
        //while if startMonth<endMonth, startMonth/endMont = 0, so 1-0 is 1
        totalDate += ((startMonth + 1) % 2) * (1 - startMonth / endMonth);

        return totalDate;
    }
}
