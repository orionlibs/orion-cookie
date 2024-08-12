package io.github.orionlibs.orion_cookie;

import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseCookie;

class CookieBuilder
{
    static ResponseCookie createSpringCookie(String cookieName, String cookieValue, String domain, int expirationInSeconds)
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


    static Cookie createJavaCookie(String cookieName, String cookieValue, String domain, int expirationInSeconds)
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