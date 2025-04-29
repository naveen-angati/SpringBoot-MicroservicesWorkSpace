package com.nt.service;

import java.util.List;

import com.nt.document.PlayerInfo;

public interface IPlayerMgmtService {
    public   String  registerPlayer(PlayerInfo player);
    public   List<PlayerInfo>  showAllPlayers();
}
