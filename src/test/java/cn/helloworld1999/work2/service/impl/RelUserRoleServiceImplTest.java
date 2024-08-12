package cn.helloworld1999.work2.service.impl;

import cn.helloworld1999.work2.bean.RelUserRole;
import cn.helloworld1999.work2.mapper.RelUserRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@Service
@SpringBootTest
public class RelUserRoleServiceImplTest{
    private RelUserRoleMapper relUserRoleMapper;

        @Test
        public void findUserRole() {
            RelUserRole relUserRole = new RelUserRole();
            relUserRole.setUid(1L);
            LambdaQueryWrapper<RelUserRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(RelUserRole::getUid,relUserRole.getUid());
    }
}
