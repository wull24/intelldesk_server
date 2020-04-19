package cn.edu.shu.intelldesk.service;

import cn.edu.shu.intelldesk.common.HrUtils;
import cn.edu.shu.intelldesk.entity.Menu;
import cn.edu.shu.intelldesk.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenusByUserId() {
        return menuMapper.getMenusByUserId(HrUtils.getCurrentHr().getId());
    }
}
