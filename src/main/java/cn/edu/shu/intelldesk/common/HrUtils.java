package cn.edu.shu.intelldesk.common;

import cn.edu.shu.intelldesk.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.Authentication;

/**
 * Created by happybaby on 2018/12/30.
 */
public class HrUtils {
    public static User getCurrentHr() {
        System.out.println("getprinciple中的信息为："+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        System.out.println("getCredentials中的信息为："+SecurityContextHolder.getContext().getAuthentication().getCredentials());
        System.out.println("getName中的信息为："+SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println("getAuthorities中的信息为："+SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        System.out.println("getDetails中的信息为："+SecurityContextHolder.getContext().getAuthentication().getDetails());
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
