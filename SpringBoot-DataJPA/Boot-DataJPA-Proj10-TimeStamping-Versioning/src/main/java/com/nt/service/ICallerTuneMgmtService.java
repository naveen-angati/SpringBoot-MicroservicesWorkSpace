package com.nt.service;

import java.util.Optional;

import com.nt.entity.CallerTuneInfo;

public interface ICallerTuneMgmtService {
        public    String saveCallerTuneInfo(CallerTuneInfo info);
        public    String  updateTuneInfoById(Integer id, String tuneName, String movieName);
        public     CallerTuneInfo showCallerTuneDetailsById(Integer id);
}
