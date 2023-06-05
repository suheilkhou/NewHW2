public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
        if (this.day < 1 || this.day > 31) {this.day = 1;}
        if (this.month < 1 || this.month > 12) {this.month = 1;}
        if (this.year < -3999 || this.year > 3999) {this.year = 0;}
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
        if (this.month < 1 || this.month > 12) {this.month = 1;}
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Date)){
            return false;
        }
        Date otherDate = (Date) obj;
        if (this.hashCode() != otherDate.hashCode()){
            return false;
        }
        return this.day == otherDate.getDay()
                && this.month == otherDate.getMonth()
                && this.year == otherDate.getYear();
    }

    @Override
    public int hashCode(){
        int num = 0;
        num += this.year * 1000;
        num += this.month * 100;
        num += this.day;
        return num;
    }

    @Override
    public String toString(){
        String sDay = String.valueOf(this.day);
        if (sDay.length() == 1) {sDay = "0" + sDay;}
        String sMonth = String.valueOf(this.month);
        if (sMonth.length() == 1) {sMonth = "0" + sMonth;}
        String sYear = String.valueOf(this.year);
        while (sYear.length() < 4){
            sYear = "0" + sYear;
        }
        return sDay+"/"+sMonth+"/"+sYear;
    }
}
