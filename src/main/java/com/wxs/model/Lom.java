package com.wxs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2017/3/29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

@Log
@Setter
@Getter
public class Lom {


    private String  name;

    public void read(){
        log.info("lombok  =======================================");
    }

}


class TestLom{
    public static void main(String[] args) {
        Lom lom = new Lom();
        String name = lom.getName();
        lom.setName("hahahhah");
        lom.read();
        System.out.println(lom.getName());
    }
}
