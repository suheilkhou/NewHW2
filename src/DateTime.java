public class DateTime extends Date{
    private int hour;
    private int minute;

    public DateTime(int year, int month, int day, int hour, int minutes){
        super(year,month,day);
        this.hour = hour;
        this.minute = minutes;
        if (this.hour < 0 || this.hour > 23) {this.hour = 0;}
        if (this.minute < 0 || this.minute > 59) {this.minute = 0;}
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
        if (this.hour < 0 || this.hour > 23) {this.hour = 0;}
    }

    public void setMinute(int minute) {
        this.minute = minute;
        if (this.minute < 0 || this.minute > 59) {this.minute = 0;}
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof DateTime)){
            return false;
        }
        DateTime otherDateTime = (DateTime) obj;
        return this.getDay() == otherDateTime.getDay()
                && this.getMonth() == otherDateTime.getMonth()
                && this.getYear() == otherDateTime.getYear()
                && this.hour == otherDateTime.getHour()
                && this.minute == otherDateTime.getMinute();
    }

    @Override
    public int hashCode(){
        return (super.hashCode() * 10000) + (10 * this.hour) + this.minute;
    }

    @Override
    public String toString(){
        String sHour = String.valueOf(this.hour);
        if (sHour.length() == 1) {sHour = "0" + sHour;}
        String sMinutes = String.valueOf(this.minute);
        if (sMinutes.length() == 1) {sMinutes = "0" + sMinutes;}
        return super.toString() + " " + sHour +":"+ sMinutes;
    }
}
