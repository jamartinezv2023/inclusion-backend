package com.teac.inclusion.repository;

import com.teac.inclusion.model.WebSocketMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSocketMessageRepository extends JpaRepository<WebSocketMessage, Long> {
}

