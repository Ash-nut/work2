package cn.helloworld1999.work2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuBody extends SysPerm{
    private List<SysPerm> children;
}
