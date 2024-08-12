package io.github.orionlibs.orion_cookie;

import org.springframework.http.ResponseCookie;

class SpringCookieBuilder
{
    private String cookieName;
    private String cookieValue;
    private String domain;
    private int expirationInSeconds;


    SpringCookieBuilder(String cookieName, String cookieValue, String domain, int expirationInSeconds)
    {
        this.cookieName = cookieName;
        this.cookieValue = cookieValue;
        this.domain = domain;
        this.expirationInSeconds = expirationInSeconds;
    }


    ResponseCookie createCookie()
    {
        if(cookieName == null || cookieName.isEmpty())
        {
            throw new IllegalArgumentException("cookieName cannot br null/empty.");
        }
        ResponseCookie cookie = ResponseCookie.from(cookieName, cookieValue)
                        .domain(domain)
                        .httpOnly(CookieDefaults.HTTPOnly)
                        .maxAge(expirationInSeconds)
                        .path(CookieDefaults.path)
                        .sameSite(CookieDefaults.sameSite)
                        .secure(CookieDefaults.secure)
                        .build();
        return cookie;
    }
}