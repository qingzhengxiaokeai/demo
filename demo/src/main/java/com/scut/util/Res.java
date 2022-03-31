package com.scut.util;

import lombok.Data;

@Data
public class Res {
    private Integer code;
    private String msg;
    private Object data;

    public Res(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Res(){
    }


    public static Res sucess(Integer code,String msg,Object data) {
        Res res = new Res();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }


}
