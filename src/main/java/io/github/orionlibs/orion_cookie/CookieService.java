package io.github.orionlibs.orion_cookie;

import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseCookie;

public class CookieService
{
    static final String ErrorMessage = "The cookie input cannot be null.";


    private CookieService()
    {
    }


    public static ResponseCookie createSpringCookie(String cookieName, String cookieValue, String domain)
    {
        return createSpringCookie(cookieName, cookieValue, domain, CookieDefaults.expirationInSeconds);
    }


    public static Cookie createJavaCookie(String cookieName, String cookieValue, String domain)
    {
        return createJavaCookie(cookieName, cookieValue, domain, CookieDefaults.expirationInSeconds);
    }


    public static ResponseCookie createSpringCookie(String cookieName, String cookieValue, String domain, int expirationInSeconds)
    {
        return new SpringCookieBuilder(cookieName, cookieValue, domain, expirationInSeconds).createCookie();
    }


    public static Cookie createJavaCookie(String cookieName, String cookieValue, String domain, int expirationInSeconds)
    {
        return new JavaCookieBuilder(cookieName, cookieValue, domain, expirationInSeconds).createCookie();
    }


    public static ResponseCookie updateSpringCookieValue(ResponseCookie cookie, String cookieValue)
    {
        return updateSpringCookieValue(cookie, cookieValue, CookieDefaults.expirationInSeconds);
    }


    public static Cookie updateJavaCookieValue(Cookie cookie, String cookieValue)
    {
        return updateJavaCookieValue(cookie, cookieValue, CookieDefaults.expirationInSeconds);
    }


    public static ResponseCookie updateSpringCookieValue(ResponseCookie cookie, String cookieValue, int expirationInSeconds)
    {
        return new SpringCookieUpdater(cookie, cookieValue, expirationInSeconds).updateCookieValue();
    }


    public static Cookie updateJavaCookieValue(Cookie cookie, String cookieValue, int expirationInSeconds)
    {
        return new JavaCookieUpdater(cookie, cookieValue, expirationInSeconds).updateCookieValue();
    }


    public static ResponseCookie invalidateSpringCookie(ResponseCookie cookie)
    {
        return new SpringCookieInvalidator(cookie).invalidateCookie();
    }


    public static Cookie invalidateJavaCookie(Cookie cookie)
    {
        return new JavaCookieInvalidator(cookie).invalidateCookie();
    }
}