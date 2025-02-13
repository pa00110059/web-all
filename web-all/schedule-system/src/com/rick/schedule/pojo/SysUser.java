package com.rick.schedule.pojo;

/*
 1 實體類的類名和表格名稱應該對應(對應不是一致)
 2 實體類的屬性名和表格的列名應該對應
 3 每個屬性都必須是私有的
 4 每個屬性都應該具備getter setter
 5 必須具備無參構造器
 6 應該實現序列化接口( 緩存    分布式項目傳遞 可能會將對象序列化)


 */

import java.io.Serializable;

public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;
}
