package com.revature.user;

    public class DataSourceException extends RuntimeException {

        public DataSourceException(Throwable cause) {
            super("Something went wrong when communicating with the database. Developers please check logs for more details.");
        }

        public DataSourceException(String message, Throwable cause) {
            super(message);
        }
    }
