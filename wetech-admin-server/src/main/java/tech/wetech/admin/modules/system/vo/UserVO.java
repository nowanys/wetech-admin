package tech.wetech.admin.modules.system.vo;

import lombok.Data;
import tech.wetech.admin.modules.system.po.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserVO {

    private Long id; //编号
    private Long organizationId; //所属公司
    private String username; //用户名
    private String roleIds; //拥有的角色列表
    private List<Long> roleIdList;
    private String roleNames;
    private String groupIds;
    private List<Long> groupIdList;
    private String groupNames;

    private Boolean locked;
    private String organizationName;

    public UserVO() {

    }

    public UserVO(User user) {
        this.id = user.getId();
        this.organizationId = user.getOrganizationId();
        this.username = user.getUsername();
        this.roleIds = user.getRoleIds();
        this.roleIdList = Arrays.asList(user.getRoleIds().split(",")).stream().map(Long::valueOf).collect(Collectors.toList());
        this.groupIds = user.getGroupIds();
        this.groupIdList = Arrays.asList(user.getGroupIds().split(",")).stream().map(Long::valueOf).collect(Collectors.toList());
        this.locked = user.getLocked();
    }

}
