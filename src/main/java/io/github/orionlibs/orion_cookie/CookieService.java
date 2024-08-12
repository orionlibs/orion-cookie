package io.github.orionlibs.orion_cookie;

import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseCookie;

public class CookieService
{
    public static ResponseCookie createSpringCookie(String cookieName, String cookieValue, String domain)
    {
        return createSpringCookie(cookieName, cookieValue, domain, 86400);
    }


    public static Cookie createJavaCookie(String cookieName, String cookieValue, String domain)
    {
        return createJavaCookie(cookieName, cookieValue, domain, 86400);
    }


    public static ResponseCookie createSpringCookie(String cookieName, String cookieValue, String domain, int expirationInSeconds)
    {
        return CookieBuilder.createSpringCookie(cookieName, cookieValue, domain, expirationInSeconds);
    }


    public static Cookie createJavaCookie(String cookieName, String cookieValue, String domain, int expirationInSeconds)
    {
        return CookieBuilder.createJavaCookie(cookieName, cookieValue, domain, expirationInSeconds);
    }


    public static ResponseCookie updateSpringCookieValue(ResponseCookie cookie, String cookieValue)
    {
        return updateSpringCookieValue(cookie, cookieValue, 86400);
    }


    public static Cookie updateJavaCookieValue(Cookie cookie, String cookieValue)
    {
        return updateJavaCookieValue(cookie, cookieValue, 86400);
    }


    public static ResponseCookie updateSpringCookieValue(ResponseCookie cookie, String cookieValue, int expirationInSeconds)
    {
        return CookieModifier.updateCookieValue(cookie, cookieValue, expirationInSeconds);
    }


    public static Cookie updateJavaCookieValue(Cookie cookie, String cookieValue, int expirationInSeconds)
    {
        return CookieModifier.updateCookieValue(cookie, cookieValue, expirationInSeconds);
    }


    public static ResponseCookie invalidateSpringCookie(ResponseCookie cookie)
    {
        return CookieModifier.invalidateCookie(cookie);
    }


    public static Cookie invalidateJavaCookie(Cookie cookie)
    {
        return CookieModifier.invalidateCookie(cookie);
    }
}