package com.tracefy.search.Helpers;

import io.github.cdimascio.dotenv.Dotenv;

public class Url {
    /**
     * Get backoffice url from env
     * @return String
     */
    public static String getBackofficeUrl() {
        return Dotenv.load().get("BACKOFFICE_URL", "http://localhost:8080");
    }
}
