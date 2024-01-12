public class time {

    // "static" method can be called without creating object first!!!
    static void currentTime(){
        long timeMilliseconds = System.currentTimeMillis();
        long timeDays = timeMilliseconds/1000/60/60/24;
        long timeHours = timeMilliseconds/1000/60/60; // Näin monta tuntia on kulunut epokin alun jälkeen

        long hoursLeftOver = timeHours%24;
        long minutesLeftOver = ;

        long timeMillisecondsLeftOver = timeMilliseconds%(1000*60*60*24);
        long timeSecondsLeftOver = timeMillisecondsLeftOver/1000;
        long timeHoursLeftOver = timeSecondsLeftOver/60/60;
        long timeMinutesLeftOver = timeSecondsLeftOver%(60*60)/60;
        long finalSecondsLeftOver = timeSecondsLeftOver%(60*60*60)/60;
        //long timeSecondsLeftOver = 0;
        System.out.println("" +
                "Milliseconds from January 1st, 1970: " + timeMilliseconds + "\n" +
                "Same time in days:" + timeDays + "\n" +
                "Same time in years:" + timeMilliseconds/1000/60/60/24/365 + "\n" +
                "Hours left over from days: " + hoursLeftOver + "\n" +
                "Minutes left over from hours: " + minutesLeftOver + "\n" +
                "Seconds left over from minutes: " + finalSecondsLeftOver
        );
    }
}
