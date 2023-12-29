package com.mysite.shop.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

public class SecurityUtils {

    public static final String ROLE_PREFIX = "ROLE_";
    public static final String AUTH_HEADER = "authorization";
    public static final String AUTH_TOKEN_TYPE = "Bearer";
    public static final String AUTH_TOKEN_PREFIX = AUTH_TOKEN_TYPE + " ";


    //시큐리티에서 "ROLE_ADMIN", "ROLE_USER" 로 설정하기 때문에 앞에 "ROLE"을 붙여줌
    public static SimpleGrantedAuthority convertToAuthority(String role){
        String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
        return new SimpleGrantedAuthority((formattedRole));
    }

    //요청 헤더에 토큰이 있으면 실제 토큰만 잘라서 리턴 또는 없을경우 null 리턴
    public static String extractAuthTokenFromRequest(HttpServletRequest request){

        String bearerToken = request.getHeader(AUTH_HEADER);
        //토큰이 있고 && 토큰의 시작이 Bearer 로 시작하면
        if(StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AUTH_TOKEN_PREFIX)){
            return bearerToken.substring(7); //실제 토큰부분부터 잘라서 리턴
        }

        return null; //토큰이 없을경우
    }

}
