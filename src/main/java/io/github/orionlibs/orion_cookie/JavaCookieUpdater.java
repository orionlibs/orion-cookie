package io.github.orionlibs.orion_cookie;

import jakarta.servlet.http.Cookie;

class JavaCookieUpdater
{
    private Cookie cookie;
    private String cookieValue;
    private int expirationInSeconds;


    JavaCookieUpdater(Cookie cookie, String cookieValue, int expirationInSeconds)
    {
        this.cookie = cookie;
        this.cookieValue = cookieValue;
        this.expirationInSeconds = expirationInSeconds;
    }


    Cookie updateCookieValue()
    {
        if(cookie == null)
        {
            throw new IllegalArgumentException(CookieService.ErrorMessage);
        }
        Cookie cookie1 = new Cookie(cookie.getName(), cookieValue);
        cookie.setDomain(cookie.getDomain());
        cookie.setPath(cookie.getPath());
        cookie.setHttpOnly(cookie.isHttpOnly());
        cookie.setSecure(cookie.getSecure());
        cookie.setMaxAge(expirationInSeconds);
        return cookie1;
    }
}