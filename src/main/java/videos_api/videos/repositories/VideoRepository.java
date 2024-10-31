package videos_api.videos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import videos_api.videos.domain.video.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
