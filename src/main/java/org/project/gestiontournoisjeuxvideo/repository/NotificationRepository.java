package org.project.gestiontournoisjeuxvideo.repository;

import org.project.gestiontournoisjeuxvideo.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
