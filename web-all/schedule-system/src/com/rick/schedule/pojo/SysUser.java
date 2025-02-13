package com.rick.schedule.pojo;



import lombok.*;

import java.io.Serializable;
import java.util.Objects;
/*
 1 實體類的類名和表格名稱應該對應(對應不是一致)
 2 實體類的屬性名和表格的列名應該對應
 3 每個屬性都必須是私有的
 4 每個屬性都應該具備getter setter
 5 必須具備無參構造器
 6 應該實現序列化接口( 緩存    分布式項目傳遞 可能會將對象序列化)
 7 應該重寫類的hashcode和equals方法
 8 toString都可以

    使用Lombok幫助我們生成內容 getter setter 全參構造 無參構造 equals hashcode
        Lombok使用步驟
            1 檢查idea是否已經安裝了lombok
            2 檢查是否勾選了 enable annotation processing
            3 導入lombok的依賴
            在實體類上添加註解

 */

@AllArgsConstructor  //添加了全參構造
@NoArgsConstructor //添加了無參構造
@Data               //getter setter  equals hashcode
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;


}
