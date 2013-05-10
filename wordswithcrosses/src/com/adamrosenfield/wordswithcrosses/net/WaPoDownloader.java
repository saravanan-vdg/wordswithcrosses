package com.adamrosenfield.wordswithcrosses.net;

import java.text.NumberFormat;
import java.util.Calendar;

/**
 * Washington Post downloader
 * URL: http://www.washingtonpost.com/r/WashingtonPost/Content/Puzzles/Daily/csYYMMDD.jpz
 * Date = Daily
 */
public class WaPoDownloader extends AbstractJPZDownloader {
    private static final String NAME = "Washington Post";
    NumberFormat nf = NumberFormat.getInstance();

    public WaPoDownloader() {
        super("http://www.washingtonpost.com/r/WashingtonPost/Content/Puzzles/Daily/", NAME);
        nf.setMinimumIntegerDigits(2);
        nf.setMaximumFractionDigits(0);
    }

    public int[] getDownloadDates() {
        return DATE_DAILY;
    }

    @Override
    protected String createUrlSuffix(Calendar date) {
        return ("cs" +
                (date.get(Calendar.YEAR) % 100) +
                nf.format(date.get(Calendar.MONTH) + 1) +
                nf.format(date.get(Calendar.DAY_OF_MONTH)) +
                ".jpz");
    }
}
