package cn.helloworld1999.work2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuBody extends SysPerm{
    private List<SysPerm> children;

    public List<MenuBody> sysPermsToMenuBody(List<SysPerm> sysPerms) {
        List<MenuBody> menuBodyList = new ArrayList<>();
        for (SysPerm sysPerm : sysPerms) {
            MenuBody menuBody = new MenuBody();
            menuBody.setId(sysPerm.getId());
            menuBody.setIsDelete(sysPerm.getIsDelete());
            menuBody.setPermName(sysPerm.getPermName());
            menuBody.setPid(sysPerm.getPid());
            menuBody.setRoute(sysPerm.getRoute());
            menuBody.setChildren(null);
            menuBodyList.add(menuBody);
        }
        return menuBodyList;
    }
}
