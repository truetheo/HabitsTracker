package com.example.a.theohabittraker.data;

import android.provider.BaseColumns;

/**
 * Created by a on 06-Jul-17.
 */

public final class HabitContract {
    //preventing accidentally instantiating the contract class
    private HabitContract() {
    }

    /**
     * Inner class to describe table content
     */
    public static class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_HOURS = "hours per week";
        public static final String COLUMN_FREQUENCY = "frequency";
        /**
         * attaches the integer to the frequency tracker
         */
        public static final int FREQUENCY_UNKNOWN = 0;
        public static final int FREQUENCY_ONE_DAY = 1;
        public static final int FREQUENCY_WEEKDAYS = 2;
        public static final int FREQUENCY_WEEKENDS = 3;
        public static final int FREQUENCY_DAILY = 4;
    }
}
