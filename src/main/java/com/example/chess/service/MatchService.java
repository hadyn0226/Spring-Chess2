package com.example.chess.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.chess.dto.MatchResponse;

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

        // 대기열에 유저 추가
        if (waitingQueue.isEmpty()) {
            waitingQueue.add(userId);
            return new MatchResponse("WAIT", null);
        } else {
            String opponentId = waitingQueue.poll();
            String gameId = UUID.randomUUID().toString();
            games.put(gameId, List.of(opponentId, userId));
            System.out.println("Matched!");
            return new MatchResponse("MATCHED", gameId);
        }
    }
	
}
