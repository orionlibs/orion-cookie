package io.github.orionlibs.orion_cookie;

import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseCookie;

class CookieModifier
{
    private static final String ErrorMessage = "The cookie input cannot be null.";


    static ResponseCookie updateCookieValue(ResponseCookie cookie, String cookieValue, int expirationInSeconds)
    {
        if(cookie == null)
        {
            throw new IllegalArgumentException(ErrorMessage);
        }
        ResponseCookie cookie1 = ResponseCookie.from(cookie.getName(), cookieValue)
                        .domain(cookie.getDomain())
                        .httpOnly(cookie.isHttpOnly())
                        .maxAge(expirationInSeconds)
                        .path(cookie.getPath())
                        .sameSite(cookie.getSameSite())
                        .secure(cookie.isSecure())
                        .build();
        return cookie1;
    }


    static Cookie updateCookieValue(Cookie cookie, String cookieValue, int expirationInSeconds)
    {
        if(cookie == null)
        {
            throw new IllegalArgumentException(ErrorMessage);
        }
        Cookie cookie1 = new Cookie(cookie.getName(), cookieValue);
        cookie.setDomain(cookie.getDomain());
        cookie.setPath(cookie.getPath());
        cookie.setHttpOnly(cookie.isHttpOnly());
        cookie.setSecure(cookie.getSecure());
        cookie.setMaxAge(expirationInSeconds);
        return cookie1;
    }


    static ResponseCookie invalidateCookie(ResponseCookie cookie)
    {
        if(cookie == null)
        {
            throw new IllegalArgumentException(ErrorMessage);
        }
        ResponseCookie cookie1 = ResponseCookie.from(cookie.getName(), null)
                        .domain(cookie.getDomain())
                        .httpOnly(cookie.isHttpOnly())
                        .maxAge(0L)
                        .path(cookie.getPath())
                        .sameSite(cookie.getSameSite())
                        .secure(cookie.isSecure())
                        .build();
        return cookie1;
    }


    static Cookie invalidateCookie(Cookie cookie)
    {
        if(cookie == null)
        {
            throw new IllegalArgumentException(ErrorMessage);
        }
        Cookie cookie1 = new Cookie(cookie.getName(), null);
        cookie1.setDomain(cookie.getDomain());
        cookie1.setPath(cookie.getPath());
        cookie1.setHttpOnly(cookie.isHttpOnly());
        cookie1.setSecure(cookie.getSecure());
        cookie1.setMaxAge(0);
        return cookie1;
    }
}