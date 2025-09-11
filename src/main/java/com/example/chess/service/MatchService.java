package com.example.chess.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.chess.dto.MatchResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MatchService {
	
	private final Queue<String> waitingQueue = new LinkedList<>();
    private final Map<String, List<String>> games = new HashMap<>();

    public MatchResponse addToQueue(String userId) {
        // 이미 매칭된 유저인지 확인
        for (var entry : games.entrySet()) {
            if (entry.getValue().contains(userId)) {
                return new MatchResponse("MATCHED", entry.getKey());
            }
        }

        return matchPlayer(userId);
       
    }
    
    public List<String> getUserIds(String gameId) {
    	return games.get(gameId);
    }
    
    // 대기열에 유저 추가
    private MatchResponse matchPlayer(String userId) {
    	 if (waitingQueue.isEmpty()) {
             waitingQueue.add(userId);
             return new MatchResponse("WAIT", null);
         } else {
             String opponentId = waitingQueue.poll();
             String gameId = UUID.randomUUID().toString();
             games.put(gameId, List.of(opponentId, userId));
             log.info("Matched! gameId={}, players={}", gameId, List.of(opponentId, userId));
             return new MatchResponse("MATCHED", gameId);
         }
    }
    	
	
}
