package cn.edu.shu.intelldesk.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


public class JwtFilter extends GenericFilterBean {

    //用于校验token
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//强转为http
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //获得token，这里是从头中获得

        try {
            String jwtToken = req.getHeader("authorization");

            Jws<Claims> jws = Jwts.parser().setSigningKey("wull")
                    .parseClaimsJws(jwtToken.replace("Bearer", ""));//将头上的bearer这几个字符去除
            Claims claims = jws.getBody();//获得token中的数据
            String username = claims.getSubject();//获得用户名
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));//获得角色
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);//校验
            SecurityContextHolder.getContext().setAuthentication(token);
            filterChain.doFilter(servletRequest, servletResponse);
        }catch (Exception e){

        }

    }
}
