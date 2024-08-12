package io.github.orionlibs.orion_cookie;

import org.springframework.http.ResponseCookie;

class SpringCookieInvalidator
{
    private ResponseCookie cookie;


    SpringCookieInvalidator(ResponseCookie cookie)
    {
        this.cookie = cookie;
    }


    ResponseCookie invalidateCookie()
    {
        if(cookie == null)
        {
            throw new IllegalArgumentException(CookieService.ErrorMessage);
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
}