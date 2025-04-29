package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.PlayerInfo;

public interface PlayerInfoRepository extends MongoRepository<PlayerInfo, Integer> {

}
