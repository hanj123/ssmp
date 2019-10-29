package com.Service;

import com.Domain.SysLog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SysLogService {

    List<SysLog> findAll();

    void save(SysLog sysLog);
}
