package com.Service.impl;

import com.Dao.ISysLogDao;
import com.Domain.SysLog;
import com.Service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysLogService")
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private ISysLogDao iSysLogDao;

    @Override
    public List<SysLog> findAll() {
        return iSysLogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) {

        iSysLogDao.save(sysLog);
    }
}
