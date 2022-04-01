package com.wangxm.flowanalysis.dataparser.mysql.command;

import com.wangxm.flowanalysis.util.ByteUtil;

/**
 * 作者: wangxm
 * 日期: 2022/4/1
 * 版本: v2.2.0
 * 备注:
 */
public class ComQuery implements BaseCommand {
    /**
     * value
     */
    private String value;

    @Override
    public void init(byte[] payload) {
        this.value = ByteUtil.byte2String(payload);
    }

    @Override
    public String value() {
        return this.value;
    }
}
