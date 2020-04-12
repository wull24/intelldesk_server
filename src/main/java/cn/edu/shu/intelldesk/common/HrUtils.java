package cn.edu.shu.intelldesk.common;

import cn.edu.shu.intelldesk.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by happybaby on 2018/12/30.
 */
public class HrUtils {
    public static User getCurrentHr() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
