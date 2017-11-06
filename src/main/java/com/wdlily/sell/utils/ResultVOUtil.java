package com.wdlily.sell.utils;

import com.wdlily.sell.vo.ResultVO;

/**
 * @author wangDi
 * @description 返回结果的工具类
 * @date 2017/10/21 23:20
 */
public class ResultVOUtil {

    //成功-有结果
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        //0 成功
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    //成功-无结果
    public static ResultVO success(){
        return success(null);
    }

    //错误
    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
