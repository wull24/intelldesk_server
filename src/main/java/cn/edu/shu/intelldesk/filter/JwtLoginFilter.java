package cn.edu.shu.intelldesk.filter;

import cn.edu.shu.intelldesk.common.HrUtils;
import cn.edu.shu.intelldesk.entity.Login;
import cn.edu.shu.intelldesk.entity.RespBean;
import cn.edu.shu.intelldesk.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Date;


public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter{


    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(authenticationManager);//第二个参数用户名校验会用到
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {

        BufferedReader br;
        StringBuilder sb = null;
        String jsonString = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    req.getInputStream()));
            String line = null;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println(sb);
            jsonString = URLDecoder.decode(sb.toString(), "UTF-8");
            jsonString = jsonString.substring(jsonString.indexOf("{"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s=""+ sb;
        Gson gson = new Gson();
        Login m = new Login();
        m = gson.fromJson(s, m.getClass());
        System.out.println(m);
        /*Login l = new ObjectMapper().readValue(req.getInputStream(),Login.class);
        System.out.println(l);*/
        /*User user = new ObjectMapper().readValue(req.getInputStream(),User.class);
        System.out.println(user);*/
        User user = new User();
        user.setUsername(m.getUsername());
        user.setPassword(m.getPassword());
        //进行登录操作
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
    }

    //登录成功的操作
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();//获取登录用户的角色
        StringBuffer sb = new StringBuffer();
        for (GrantedAuthority authority : authorities) {
            sb.append(authority.getAuthority()).append(",");
        }//对角色进行遍历，使用逗号进行隔开
        //生成token
        String jwt = Jwts.builder()
                .claim("authorities", sb)//配置用户的角色
                .setSubject(authResult.getName())//主题
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))//过期的时间
                .signWith(SignatureAlgorithm.HS512, "wull")//设置签名的算法，以及密钥
                .compact();
        //设置返回的对象
        RespBean respBean = RespBean.ok("登录成功!",null ,jwt);//HrUtils.getCurrentHr()
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(respBean));
        out.flush();
        out.close();
    }

    //登录失败的操作
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e)
            throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        RespBean respBean = null;
        if (e instanceof BadCredentialsException ||
                e instanceof UsernameNotFoundException) {
            respBean = RespBean.error("账户名或者密码输入错误!");
        } else if (e instanceof LockedException) {
            respBean = RespBean.error("账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            respBean = RespBean.error("密码过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            respBean = RespBean.error("账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            respBean = RespBean.error("账户被禁用，请联系管理员!");
        } else {
            respBean = RespBean.error("登录失败!");
        }
        resp.setStatus(401);
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
