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
        int totalPrice = 0;
        int absDiff = Math.abs(totalDate - 50);

        //getting minimum value between
        int regularRateDays = (totalDate + 51 - absDiff) / 2;

        int flatRateDays = totalDate - regularRateDays;

        totalPrice += flatRateDays;

        //calculation of regular rate days
        regularRateDays = totalDate - flatRateDays;

        //price for weekday
        totalPrice += regularRateDays * 2;

        //add the whole week difference (sat+sun price - weekday price)
        totalPrice += (regularRateDays / 7) * 4;

        //add the stray saturday if any
        totalPrice += (regularRateDays % 7) / 6;

        return totalPrice;
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
