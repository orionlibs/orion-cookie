package io.github.orionlibs.orion_cookie;

import jakarta.servlet.http.Cookie;

class JavaCookieBuilder
{
    private String cookieName;
    private String cookieValue;
    private String domain;
    private int expirationInSeconds;


    JavaCookieBuilder(String cookieName, String cookieValue, String domain, int expirationInSeconds)
    {
        this.cookieName = cookieName;
        this.cookieValue = cookieValue;
        this.domain = domain;
        this.expirationInSeconds = expirationInSeconds;
    }


    Cookie createCookie()
    {
        if(cookieName == null || cookieName.isEmpty())
        {
            throw new IllegalArgumentException("cookieName cannot br null/empty.");
        }
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setDomain(domain);
        cookie.setPath(CookieDefaults.path);
        cookie.setHttpOnly(CookieDefaults.HTTPOnly);
        cookie.setSecure(CookieDefaults.secure);
        cookie.setMaxAge(expirationInSeconds);
        return cookie;
    }
}