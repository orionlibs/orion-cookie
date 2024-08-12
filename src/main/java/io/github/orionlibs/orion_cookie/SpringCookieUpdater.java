package io.github.orionlibs.orion_cookie;

import org.springframework.http.ResponseCookie;

class SpringCookieUpdater
{
    private ResponseCookie cookie;
    private String cookieValue;
    private int expirationInSeconds;


    SpringCookieUpdater(ResponseCookie cookie, String cookieValue, int expirationInSeconds)
    {
        this.cookie = cookie;
        this.cookieValue = cookieValue;
        this.expirationInSeconds = expirationInSeconds;
    }


    ResponseCookie updateCookieValue()
    {
        if(cookie == null)
        {
            throw new IllegalArgumentException(CookieService.ErrorMessage);
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
}