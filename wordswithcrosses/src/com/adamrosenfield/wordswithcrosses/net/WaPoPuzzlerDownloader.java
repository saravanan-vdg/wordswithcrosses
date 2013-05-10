package com.adamrosenfield.wordswithcrosses.net;

import java.text.NumberFormat;
import java.util.Calendar;

/**
 * Washington Post Puzzler
 * URL: http://crosswords.washingtonpost.com/wp-srv/style/crosswords/util/csserve2.cgi?t=puz&z=puzzler&f=csYYMMDD.puz
 * Date = Sundays
 */
public class WaPoPuzzlerDownloader extends AbstractDownloader {
    private static final String NAME = "Washington Post Puzzler";
    NumberFormat nf = NumberFormat.getInstance();

    public WaPoPuzzlerDownloader() {
        super("http://crosswords.washingtonpost.com/wp-srv/style/crosswords/util/csserve2.cgi?t=puz&z=puzzler&f=",
            NAME);
        nf.setMinimumIntegerDigits(2);
        nf.setMaximumFractionDigits(0);
    }

    public int[] getDownloadDates() {
        return DATE_SUNDAY;
    }

    @Override
    protected String createUrlSuffix(Calendar date) {
        return ("cs" +
                nf.format(date.get(Calendar.YEAR) % 100) +
                nf.format(date.get(Calendar.MONTH) + 1) +
                nf.format(date.get(Calendar.DAY_OF_MONTH)) +
                ".puz");
    }
}
