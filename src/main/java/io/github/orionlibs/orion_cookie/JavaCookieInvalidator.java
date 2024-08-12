package io.github.orionlibs.orion_cookie;

import jakarta.servlet.http.Cookie;

class JavaCookieInvalidator
{
    private Cookie cookie;


    JavaCookieInvalidator(Cookie cookie)
    {
        this.cookie = cookie;
    }


    Cookie invalidateCookie()
    {
        if(cookie == null)
        {
            throw new IllegalArgumentException(CookieService.ErrorMessage);
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